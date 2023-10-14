package rl.prog2.demos.gui.swing.dice;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Simple dice simulator application with two buttons. It creates random numbers
 * between 1 and 6 and shows them to the user. A central listener object which
 * is implemented as inner class listens to all button events.
 * 
 * @author Ruediger Lunde
 */
public class DiceSimulator3 {

	private Random rand;
	private JFrame frame;
	private JTextField faceValueField;
	private JButton throwButton;
	private JButton exitButton;

	/** Constructs the frame of the die simulator application. */
	public DiceSimulator3() {
		frame = new JFrame("Dice Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		faceValueField = new JTextField(3);
		faceValueField.setFont(new Font("SansSerif", Font.PLAIN, 60));
		frame.add(faceValueField, BorderLayout.CENTER);

		AppActionListener listener = new AppActionListener();
		JPanel panel = new JPanel();
		frame.add(panel, BorderLayout.SOUTH);
		throwButton = new JButton("Throw Die");
		throwButton.addActionListener(listener);
		panel.add(throwButton);
		exitButton = new JButton("Exit");
		exitButton.addActionListener(listener);
		panel.add(exitButton);
	}

	/**
	 * Initializes the random number generator, packs the frame and makes it
	 * visible.
	 */
	public void start() {
		rand = new Random();
		frame.pack();
		frame.setVisible(true);
	}
	
	/** Throws a die and displays the face value in the face value field. */
	public void throwDie() {
		int value = rand.nextInt(6) + 1;
		faceValueField.setText(Integer.toString(value));
	}

	/** Creates a die simulator and starts it. */
	public static void main(String[] args) {
		new DiceSimulator3().start();
	}

	// //////////////////////////////////////////////////////////////
	// inner classes

	/**
	 * Performs actions in response to user events. Here, the event source is
	 * analyzed and depending on the result, a die is thrown or the application
	 * is terminated.
	 */
	private class AppActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == throwButton) {
				throwDie();
			} else if (e.getSource() == exitButton) {
				System.exit(0); // 0 indicates normal termination
			}
		}
	}
}