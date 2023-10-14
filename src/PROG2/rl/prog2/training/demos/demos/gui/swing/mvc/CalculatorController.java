package rl.prog2.demos.gui.swing.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import rl.prog2.demos.gui.swing.mvc.CalculatorView.Command;

/**
 * Provides a controller for the RPN Calculator application. It defines, how the
 * application reacts on user events. Arithmetic operation commands are directly
 * delegated to the model. Edits concerning the current value field (view) are
 * translated to value stack modifications with a delay to avoid parse errors in
 * intermediate states.
 * 
 * @author Ruediger Lunde
 * 
 */
public class CalculatorController implements ActionListener {

	private CalculatorView view;
	private CalculatorModel model;

	/**
	 * Indicates, whether the current value field state differs from the top
	 * stack element of the model.
	 */
	private boolean valueChanged;

	/** Creates a calculator controller for the specified calculator model. */
	public CalculatorController(CalculatorModel model) {
		this.model = model;
	}

	/**
	 * Establishes a link to a calculator view (should only be called by the
	 * view!).
	 */
	public void setView(CalculatorView view) {
		this.view = view;
	}

	/**
	 * In response to value edits in the current value field (view) the
	 * <code>valueChanged</code> flag is set and the enabled state of the view
	 * is updated.
	 */
	public void valueEdited(DocumentEvent e) {
		valueChanged = true;
		view.updateEnabledState();
	}

	/**
	 * Central dispatcher method for all action events from the view. Calls
	 * {@link #executeCommand(String, CalculatorView.Command, Integer)} for every
	 * <code>CalcAction</code> event and handles errors.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = null;
		CalculatorView.Command cmd = null;
		Integer num = null;
		if (e.getSource() instanceof AbstractButton) {
			AbstractButton button = (AbstractButton) e.getSource();
			Action action = button.getAction();
			if (action != null) {
				name = (String) action.getValue(Action.NAME);
				cmd = (Command) action.getValue(CalculatorView.COMMAND_KEY);
				num = (Integer) action.getValue(CalculatorView.NUMBER_KEY);
			}
		}
		try {
			if (cmd != null) {
				executeCommand(name, cmd, num);
			} else {
				view.showWarning("Error, no command found.");
			}
		} catch (Exception ex) {
			view.showWarning(ex.getClass().getSimpleName() + ": "
					+ ex.getMessage());
		}
	}

	/** Handles all <code>CalcAction</code> events. */
	protected void executeCommand(String name, CalculatorView.Command cmd,
			Integer num) throws Exception {
		switch (cmd) {
		case ENTER:
		case ADD:
		case SUBTRACT:
		case MULTIPLY:
		case DIVIDE:
			updateCurrValue(true);
			break;
		case SET_RADIX:
			updateCurrValue(false);
			break;
		default:
			break;
		}

		switch (cmd) {
		case ENTER:
			model.enter(Double.NaN);
			break;
		case ADD:
			model.add();
			break;
		case SUBTRACT:
			model.subtract();
			break;
		case MULTIPLY:
			model.multiply();
			break;
		case DIVIDE:
			model.divide();
			break;
		case C:
			model.clear();
			break;
		case CE:
			view.getValueField(true).setText("");
			break;
		case INSERT_DIGIT:
			insertIntoCurrValue(num.toString());
			break;
		case INSERT_DOT:
			insertIntoCurrValue(".");
			break;
		case PLUSMINUS:
			String value = view.getValueField(true).getText();
			if (value.startsWith("-"))
				value = value.substring(1);
			else
				value = "-" + value;
			view.getValueField(true).setText(value);
			break;
		case SET_RADIX:
			model.setRadix(num);
			break;
		case SET_LAF:
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if (info.getName().equals(name)) {
					UIManager.setLookAndFeel(info.getClassName());
					SwingUtilities.updateComponentTreeUI(view);
					view.pack();
				}
			}
			break;
		case SHOW_INFO:
			view.showInfo("Reverse Polish Notation Calculator"
					+ "\nAuthor: Ruediger Lunde (2011)");
			break;
		case EXIT:
			System.exit(0);
		}
	}

	/**
	 * Inserts <code>txt</code> into the text maintained by the current value
	 * field (view) at the current caret position.
	 */
	private void insertIntoCurrValue(String txt) throws BadLocationException {
		int pos = view.getValueField(true).getCaretPosition();
		Document doc = view.getValueField(true).getDocument();
		doc.insertString(pos, txt, null);
	}

	/**
	 * Replaces the top element of the value stack (model) by the value of the
	 * current value field (view).
	 * 
	 * @param signalErrors
	 *            Controls whether parse errors are signaled or ignored.
	 */
	private void updateCurrValue(boolean signalErrors) throws Exception {
		try {
			if (valueChanged) {
				String value = view.getValueField(true).getText();
				model.updateCurrent(model.parse(value));
				valueChanged = false;
			}
		} catch (Exception e) {
			if (signalErrors)
				throw e;
		}
	}
}
