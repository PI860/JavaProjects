package rl.prog2.demos.gui.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Simple demo which shows some example dialogs. Additionally, it demonstrates,
 * how a text field can be embedded into a scroll pane and how the
 * <code>System.out</code> print stream can be redirected into the text field.
 * 
 * @author Ruediger Lunde
 */
public class DialogDemo {

	/** Starts the demo. */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US); // button language is English!
		new DialogDemo().start();

	}

	JTextArea textArea = new JTextArea();

	/**
	 * Creates a frame, adds a text area with scroll pane to it, makes it
	 * visible and opens some dialogs on top of it. Results are printed to the
	 * text area.
	 */
	public void start() {
		JFrame frame = new JFrame("Dialog Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(600, 300));
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.add(scrollPane, BorderLayout.CENTER);
		System.setOut(new PrintStream(new TextAreaOutputStream()));
		frame.pack();
		frame.setVisible(true);

		String msg;

		final JDialog dialog = new JDialog(frame, "My Dialog");
		JLabel label = new JLabel("I am not modal!");
		label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		dialog.add(label);
		dialog.setModal(false);
		JPanel panel = new JPanel();
		dialog.add(panel, BorderLayout.SOUTH);
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose(); // can access dialog because it is final!
			}
		});
		panel.add(button);
		dialog.pack();
		dialog.setVisible(true);

		msg = "JOptionPane.showMessageDialog(frame, msg, \"My Title\", JOptionPane.INFORMATION_MESSAGE)";
		JOptionPane.showMessageDialog(frame, msg, "My Title",
				JOptionPane.INFORMATION_MESSAGE);

		msg = "JOptionPane.showMessageDialog(frame, msg, \"My Title\", JOptionPane.ERROR_MESSAGE)";
		JOptionPane.showMessageDialog(frame, msg, "My Title",
				JOptionPane.ERROR_MESSAGE);

		msg = "JOptionPane.showConfirmDialog(frame, msg)";
		int result = JOptionPane.showConfirmDialog(frame, msg);
		if (result == JOptionPane.YES_OPTION)
			System.out.println("ConfirmDialog: confirmed");
		else if (result == JOptionPane.NO_OPTION)
			System.out.println("ConfirmDialog: not confirmed");
		else if (result == JOptionPane.CANCEL_OPTION)
			System.out.println("ConfirmDialog: canceled");

		msg = "JOptionPane.showInputDialog(frame, msg, 4711)";
		String input = JOptionPane.showInputDialog(frame, msg, 4711);
		System.out.println("InputDialog: " + input);

		msg = "JOptionPane.showConfirmDialog(frame, new Object[] {msg, combo}, \"My Title\", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)";
		JComboBox<String> combo = new JComboBox<String>(new String[] {
				"Option 1", "Option 2" });
		result = JOptionPane.showConfirmDialog(frame,
				new Object[] { msg, combo }, "My Title",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		System.out.println("LastDialog: result=" + result
				+ " combo.selectedIndex=" + combo.getSelectedIndex());
	}

	// ///////////////////////////////////////////////////////////////////
	// nested classes

	/** Writes everything into the text area. */
	private class TextAreaOutputStream extends java.io.OutputStream {
		@Override
		public void write(int b) throws java.io.IOException {
			String s = new String(new char[] { (char) b });
			textArea.append(s);
			textArea.getDocument().getLength();
		}
	}
}
