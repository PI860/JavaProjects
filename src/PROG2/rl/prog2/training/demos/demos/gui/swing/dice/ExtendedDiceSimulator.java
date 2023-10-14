package rl.prog2.demos.gui.swing.dice;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Extended version of the die simulator. Here, the number of dices can be
 * specified (by combo box) as well as the number of faces per dice (by
 * spinner). Dice are represented by extended <code>JToggleButtons</code>. The
 * user can fix face values by selection (e.g. when playing Kniffel).
 * 
 * @author Ruediger Lunde
 * 
 */
public class ExtendedDiceSimulator {

	private Random rand;

	private JFrame frame;
	private JComboBox<Integer> diceCombo;
	private JSpinner facesSpinner;
	private DicePanel dicePanel;

	/** Creates a dice simulator and starts it. */
	public static void main(String[] args) {
		// try {
		// UIManager
		// .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		new ExtendedDiceSimulator().start();
	}

	/** Constructs the frame of the dice simulator application. */
	public ExtendedDiceSimulator() {
		frame = new JFrame("Dice Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		frame.add(toolBar, BorderLayout.NORTH);
		toolBar.add(new JLabel("Dice: "));
		diceCombo = new JComboBox<Integer>(new Integer[] { 1, 2, 3, 4, 5, 6 });
		toolBar.add(diceCombo);
		toolBar.addSeparator();
		toolBar.add(new JLabel("Faces per Die: "));
		facesSpinner = new JSpinner();
		facesSpinner.setValue(6);
		toolBar.add(facesSpinner);
		toolBar.addSeparator();
		JButton button = new JButton("Clear Selection");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dicePanel.clearSelection();
			}
		});
		toolBar.add(button);

		dicePanel = new DicePanel();
		dicePanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 5));
		frame.add(dicePanel, BorderLayout.CENTER);
		ImageIcon image = createImageIcon("dice.gif", "Dice Icon");
		button = new JButton(image);
		if (image == null)
			button.setText("Throw Dice");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				throwDice();
			}
		});
		frame.add(button, BorderLayout.SOUTH);
	}

	/** Initializes the random number generator and shows the frame. */
	public void start() {
		rand = new Random();
		frame.setSize(500, 300);
		frame.setVisible(true);
	}

	/** Throws the dice and displays the face values in the dice panel. */
	public void throwDice() {
		int diceCount = (Integer) diceCombo.getSelectedItem();
		int faceCount = (Integer) facesSpinner.getValue();
		dicePanel.adjust(diceCount, faceCount > 6);
		for (ExtendedDieButton die : dicePanel.getDice()) {
			if (!die.isSelected()) {
				int r = rand.nextInt(faceCount) + 1;
				die.setFaceValue(r);
			}
		}
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	private ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	// ///////////////////////////////////////////////////////////////////
	// inner classes

	/**
	 * Panel to show face values of dice. Dice are represented by DieButtons.
	 * Press to fix!
	 * 
	 * @author Ruediger Lunde
	 */
	@SuppressWarnings("serial")
	private static class DicePanel extends JPanel {

		private ExtendedDieButton[] dice = new ExtendedDieButton[0];

		/** Adjusts number and type of contained dices. */
		void adjust(int diceCount, boolean textMode) {
			if (diceCount != dice.length || dice[0].textMode != textMode) {
				for (ExtendedDieButton die : dice)
					remove(die);
				dice = new ExtendedDieButton[diceCount];
				for (int i = 0; i < diceCount; i++) {
					dice[i] = new ExtendedDieButton(textMode);
					add(dice[i]);
				}
				validate(); // ensures that this component has a valid layout
				repaint();
			}
		}

		ExtendedDieButton[] getDice() {
			return dice;
		}

		void clearSelection() {
			for (JToggleButton die : dice)
				die.setSelected(false);
		}
	}

	/**
	 * Extends the <code>DieButton</code> by a text mode. In text mode, face
	 * values are displayed by button text. In graphic mode, dot graphics are
	 * used but values must be between 1 an 6.
	 * 
	 * @author Ruediger Lunde
	 */
	@SuppressWarnings("serial")
	static class ExtendedDieButton extends DieButton {
		private boolean textMode;

		public ExtendedDieButton(boolean textMode) {
			this.textMode = textMode;
			if (textMode) {
				setPreferredSize(null);
				setFont(new Font("SansSerif", Font.PLAIN, 40));
			}
		}

		@Override
		public void setFaceValue(int value) {
			super.setFaceValue(value);
			if (textMode)
				setText(Integer.toString(value));
		}

		/** Print dots only in graphic mode! */
		@Override
		protected void paintDots(Graphics g, int[] posIndices) {
			if (!textMode)
				super.paintDots(g, posIndices);
		}
	}
}
