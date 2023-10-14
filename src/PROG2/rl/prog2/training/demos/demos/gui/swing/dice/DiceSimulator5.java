package rl.prog2.demos.gui.swing.dice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Simple dice simulator application with two buttons. It creates random numbers
 * between 1 and 6 and shows them to the user. For each button, a separate
 * action listener object is used, which is implemented as local inner class.
 * 
 * @author Ruediger Lunde
 */
public class DiceSimulator5 {

	private Random rand;
	private JFrame frame;
	private DieButton dieButton;

	/** Constructs the frame of the die simulator application. */
	public DiceSimulator5() {
		frame = new JFrame("Dice Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel, BorderLayout.CENTER);
		dieButton = new DieButton();
		panel.add(dieButton);

		panel = new JPanel();
		frame.add(panel, BorderLayout.SOUTH);
		JButton button = new JButton("Throw Die");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!dieButton.isSelected()) {
					throwDie();
				}
			}
		});
		panel.add(button);
		button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // 0 indicates normal termination
			}
		});
		panel.add(button);
	}

	/** Initializes the random number generator, and shows the frame. */
	public void start() {
		rand = new Random();
		frame.setSize(300, 200);
		frame.setVisible(true);
	}

	/** Throws a die and displays the face value in the face value field. */
	public void throwDie() {
		int value = rand.nextInt(6) + 1;
		dieButton.setFaceValue(value);
	}
	
	/** Creates a die simulator and starts it. */
	public static void main(String[] args) {
		new DiceSimulator5().start();
	}
}
