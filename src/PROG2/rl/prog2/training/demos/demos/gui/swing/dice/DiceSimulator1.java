package rl.prog2.demos.gui.swing.dice;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Simple dice simulator application. It creates random numbers between 1 and 6
 * and shows them to the user. The application object itself listens to button
 * events.
 * 
 * @author Ruediger Lunde
 */
public class DiceSimulator1 implements ActionListener {

	private Random rand;
	private JFrame frame;
	private JTextField faceValueField;

	/** Constructs the frame of the die simulator application. */
	public DiceSimulator1() {
		frame = new JFrame("Dice Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		faceValueField = new JTextField(3);
		faceValueField.setFont(new Font("SansSerif", Font.PLAIN, 60));
		frame.add(faceValueField, BorderLayout.CENTER);
		JButton button = new JButton("Throw Die");
		//button.addActionListener(this);
		button.addActionListener( (e) -> throwDie() );
		frame.add(button, BorderLayout.SOUTH);
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

	/** Throws a die and displays the face value in the face value field. */
	@Override
	public void actionPerformed(ActionEvent e) {
		throwDie();
	}

	/** Creates a die simulator and starts it. */
	public static void main(String[] args) {
		new DiceSimulator1().start();
	}
}
