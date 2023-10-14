package rl.prog2.demos.gui.swing.mvc;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Provides a view for the RPN Calculator. It is responsible for the visual
 * appearance of the application. Standard Swing components are used for this
 * purpose. Buttons and menu items are created based on special actions
 * (implemented as inner class) which delegate activities in response to user
 * actions to a controller. The view observes a calculator model and updates
 * after each change of the model state.
 * 
 * @author Ruediger Lunde
 */
@SuppressWarnings("serial")
public class CalculatorView extends JFrame implements Observer {

	/**
	 * Each {@link CalculatorView.CalcAction} stores its
	 * {@link CalculatorView.Command} identifier under this key.
	 */
	public static final String COMMAND_KEY = "CalcCmd";
	/**
	 * Some {@link CalculatorView.CalcAction}s (insert digit, set radix) store
	 * an integer number under this key to specify the activities to be
	 * performed.
	 */
	public static final String NUMBER_KEY = "CalcNum";

	// some central actions to be used to create buttons and menu items...

	private Action enterAction = new CalcAction("Enter", Command.ENTER);
	private Action addAction = new CalcAction("+", Command.ADD);
	private Action subtractAction = new CalcAction("-", Command.SUBTRACT);
	private Action multiplyAction = new CalcAction("*", Command.MULTIPLY);
	private Action divideAction = new CalcAction("/", Command.DIVIDE);
	private Action cAction = new CalcAction("C", Command.C);
	private Action ceAction = new CalcAction("CE", Command.CE);
	private Action dotAction = new CalcAction(".", Command.INSERT_DOT);
	private Action plusminusAction = new CalcAction("+-", Command.PLUSMINUS);

	private JRadioButtonMenuItem decimalItem = new JRadioButtonMenuItem(
			new CalcAction("Decimal", Command.SET_RADIX, 10));
	/**
	 * Displays the previous value and can be edited by the user. It corresponds
	 * to the element below the top element of the value stack.
	 */
	private JTextField prevValueField;
	/**
	 * Displays the current value and can be edited by the user. It corresponds
	 * to the top element of the value stack but updates are sometimes delayed.
	 */
	private JTextField currValueField;

	CalculatorController controller;
	CalculatorModel model;

	/**
	 * Creates a frame with menu and content and packs it.
	 * 
	 * @param model
	 *            A model or null for testing.
	 * @param controller
	 *            A controller to be connected with the view or null for
	 *            testing.
	 */
	public CalculatorView(CalculatorModel model, CalculatorController controller) {
		this.model = model;
		this.controller = controller;
		if (controller != null)
			controller.setView(this);

		setTitle("RPN Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setJMenuBar(createMenu());
		setContentPane(createContent());

		updateEnabledState();
		pack();
	}

	/** Creates the menu for the UPN Calculator and returns it. */
	protected JMenuBar createMenu() {
		JMenuBar result = new JMenuBar();
		setJMenuBar(result);
		JMenu menu = new JMenu("File");
		result.add(menu);
		JMenuItem item = new JMenuItem(new CalcAction("Exit", Command.EXIT));
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				KeyEvent.CTRL_DOWN_MASK));
		menu.add(item);
		menu = new JMenu("Operations");
		result.add(menu);
		item = new JMenuItem(enterAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
		menu.add(item);
		item = new JMenuItem(addAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS,
				KeyEvent.CTRL_MASK));
		menu.add(item);
		item = new JMenuItem(subtractAction);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS,
				KeyEvent.CTRL_MASK));
		menu.add(item);
		item = new JMenuItem(multiplyAction);
		menu.add(item);
		item = new JMenuItem(divideAction);
		menu.add(item);

		menu = new JMenu("Options");
		result.add(menu);
		JMenuItem submenu = new JMenu("Numeral System");
		menu.add(submenu);
		ButtonGroup group = new ButtonGroup();
		item = new JRadioButtonMenuItem(new CalcAction("Binary",
				Command.SET_RADIX, 2));
		group.add(item);
		submenu.add(item);
		item = new JRadioButtonMenuItem(new CalcAction("Octal",
				Command.SET_RADIX, 8));
		group.add(item);
		submenu.add(item);
		item = decimalItem;
		item.setSelected(true);
		group.add(item);
		submenu.add(item);
		item = new JRadioButtonMenuItem(new CalcAction("Hexadecimal",
				Command.SET_RADIX, 16));
		group.add(item);
		submenu.add(item);
		submenu = new JMenu("Look & Feel");
		menu.add(submenu);
		group = new ButtonGroup();
		// determine all supported look and feels and create menu items for them
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			item = new JRadioButtonMenuItem(new CalcAction(info.getName(),
					Command.SET_LAF));
			item.setSelected(info.getName().equals(
					UIManager.getLookAndFeel().getName()));
			group.add(item);
			submenu.add(item);
		}

		menu = new JMenu("?");
		result.add(menu);
		item = new JMenuItem(new CalcAction("About", Command.SHOW_INFO));
		menu.add(item);
		return result;
	}

	/** Creates the content for the UPN Calculator and returns it. */
	protected JPanel createContent() {
		JPanel result = new JPanel();
		result.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		// maximum height and width for all components
		c.fill = GridBagConstraints.BOTH;
		// share extra space in both directions
		c.weightx = 0.5;
		c.weighty = 0.5;

		c.gridwidth = 4;
		// adjust free space around the components (in pixel)
		c.insets = new Insets(10, 10, 0, 10);
		prevValueField = new JTextField();
		prevValueField.setEditable(false);
		prevValueField.setFocusable(false);
		addAt(result, prevValueField, c, 0, 0);
		c.insets = new Insets(0, 10, 10, 10);
		currValueField = new JTextField(14); // show at least 14 digits!
		currValueField.setFont(currValueField.getFont().deriveFont(24f));
		currValueField.getDocument().addDocumentListener(
				new DocumentChangedListener());
		addAt(result, currValueField, c, 0, 1);
		c.gridwidth = 1;

		c.insets = new Insets(10, 10, 10, 10);
		addAt(result, new JButton(addAction), c, 0, 2);
		addAt(result, new JButton(subtractAction), c, 1, 2);
		addAt(result, new JButton(multiplyAction), c, 2, 2);
		addAt(result, new JButton(divideAction), c, 3, 2);
		addAt(result, new JButton(plusminusAction), c, 3, 3);
		addAt(result, new JButton(cAction), c, 3, 4);
		addAt(result, new JButton(ceAction), c, 3, 5);
		JButton button;
		int[] posx = new int[] { 0, 0, 1, 2, 0, 1, 2, 0, 1, 2 };
		int[] posy = new int[] { 6, 5, 5, 5, 4, 4, 4, 3, 3, 3 };
		for (int i = 0; i < 10; i++) {
			Action action = new CalcAction(Integer.toString(i),
					Command.INSERT_DIGIT, i);
			button = new JButton(action);
			button.setFont(button.getFont().deriveFont(Font.BOLD));
			addAt(result, button, c, posx[i], posy[i]);
		}
		addAt(result, new JButton(dotAction), c, 1, 6);

		c.gridwidth = 2;
		button = new JButton(enterAction);
		addAt(result, button, c, 2, 6);
		c.gridwidth = 1;
		return result;
	}

	/**
	 * Helper method, adding a component to a container at a certain grid
	 * position. The container is assumed to have a GridBagLayout.
	 */
	private void addAt(Container container, Component comp,
			GridBagConstraints c, int gridx, int gridy) {
		c.gridx = gridx;
		c.gridy = gridy;
		container.add(comp, c);
	}

	/**
	 * Returns the current value field if parameter <code>current</code> is
	 * true, otherwise the previous value field.
	 */
	public JTextField getValueField(boolean current) {
		return current ? currValueField : prevValueField;
	}

	/**
	 * Updates the current and previous value field and enables/disables buttons
	 * after the model state has changed. The parameters are defined by the
	 * general observer interface but not used here (the view knows the model
	 * anyway).
	 */
	@Override
	public void update(Observable theModel, Object obj) {
		CalculatorController tmp = controller;
		controller = null; // disable controller to avoid cyclic notifications
		double value = model.getCurrValue();
		currValueField.setText(Double.isNaN(value) ? "" : model.format(value));
		value = model.getPrevValue();
		prevValueField.setText(Double.isNaN(value) ? "" : model.format(value));
		updateEnabledState();
		controller = tmp; // enable controller again
	}

	/**
	 * Enables/disables buttons depending on the current radix settings and
	 * value field values.
	 */
	protected void updateEnabledState() {
		boolean prevEmpty = prevValueField.getText().equals("");
		boolean currEmpty = currValueField.getText().equals("");
		addAction.setEnabled(!prevEmpty && !currEmpty);
		subtractAction.setEnabled(!prevEmpty && !currEmpty);
		multiplyAction.setEnabled(!prevEmpty && !currEmpty);
		divideAction.setEnabled(!prevEmpty && !currEmpty);
		enterAction.setEnabled(!currEmpty);
		dotAction.setEnabled(decimalItem.isSelected());
	}

	/** Shows an information message dialog. */
	public void showInfo(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Info",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/** Shows a waring message dialog. */
	public void showWarning(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Warning",
				JOptionPane.WARNING_MESSAGE);
	}

	// /**
	// * For testing. This view can be shown even without model and controller.
	// */
	// public static void main(String[] args) {
	// new CalculatorView(null, null).setVisible(true);
	// }

	// //////////////////////////////////////////////////////////////
	// inner classes

	/**
	 * Defines unique identifiers for all relevant actions of the RPN Calculator
	 * Actions store their command in a key-value pair, using
	 * {@link CalculatorView#COMMAND_KEY} as key. The information is used by the
	 * controller to understand what the user wants to do next.
	 */
	public static enum Command {
		ENTER, ADD, SUBTRACT, MULTIPLY, DIVIDE, C, CE, INSERT_DIGIT, INSERT_DOT, PLUSMINUS, SHOW_INFO, SET_RADIX, SET_LAF, EXIT
	}

	/**
	 * Represents a calculator action. Every calculator action has a name for
	 * visual representation in menus and buttons (use
	 * <code>getValue(Action.NAME)</code> to access), a unique command
	 * identifier (<code>getValue(CalculatorView.COMMAND_KEY)</code>), and
	 * optionally a number (<code>getValue(CalculatorView.NUMBER_KEY)</code>).
	 * When a calculator action is informed about a new event, it forwards the
	 * event to the controller (if any).
	 */
	private class CalcAction extends AbstractAction {

		CalcAction(String text, Command command) {
			super(text);
			this.putValue(COMMAND_KEY, command);
		}

		CalcAction(String text, Command command, Integer number) {
			this(text, command);
			putValue(NUMBER_KEY, number);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (controller != null)
				controller.actionPerformed(e);
		}

	}

	/** Forwards value field related document events to the controller. */
	private class DocumentChangedListener implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent e) {
			if (controller != null)
				controller.valueEdited(e);
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			if (controller != null)
				controller.valueEdited(e);

		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			if (controller != null)
				controller.valueEdited(e);
		}
	}
}
