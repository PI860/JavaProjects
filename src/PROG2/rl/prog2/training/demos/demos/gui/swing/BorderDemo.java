package rl.prog2.demos.gui.swing;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

/**
 * Simple demo which shows some borders provided by the BorderFactory.
 * 
 * @author Ruediger Lunde
 */
public class BorderDemo {

	/** Starts the demo. */
	public static void main(String[] args) {
		new BorderDemo().start();

	}
	
	/**
	 * Creates a frame, adds several labels with border to it, and makes it
	 * visible.
	 */
	public void start() {
		JFrame frame = new JFrame("Border Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		JLabel label;

		label = new JLabel(
				"label.setBorder(BorderFactory.createEmptyBorder(5, 20, 40, 80))");
		label.setBorder(BorderFactory.createEmptyBorder(5, 20, 40, 80));
		frame.add(label);

		label = new JLabel(
				"label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED))");
		label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		frame.add(label);

		label = new JLabel(
				"label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED))");
		label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		frame.add(label);

		label = new JLabel(
				"label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED))");
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		frame.add(label);

		label = new JLabel(
				"label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED))");
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		frame.add(label);

		label = new JLabel(
				"label.setBorder(BorderFactory.createTitledBorder(\"Title\"))");
		label.setBorder(BorderFactory.createTitledBorder("Title"));
		frame.add(label);

		label = new JLabel(
				"label.setBorder(BorderFactory.createCompoundBorder(etchedB, emptyB))");
		label.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
				BorderFactory.createEmptyBorder(5, 20, 40, 80)));
		frame.add(label);

		frame.setSize(600, 400);
		frame.setVisible(true);
	}
}
