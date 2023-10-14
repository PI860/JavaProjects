package rl.prog2.demos.gui.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 * Simple demo which shows some of the most important Swing components.
 * 
 * @author Ruediger Lunde
 */
public class SwingComponentDemo {

	/** Starts the demo. */
	public static void main(String[] args) {
		new SwingComponentDemo().start();
	}

	/** Creates a frame, adds several components to it, and makes it visible. */
	public void start() {
		JFrame frame = new JFrame("Swing Component Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(6, 2));

		frame.add(new JButton("JButton"));
		frame.add(new JToggleButton("JToggleButton"));
		frame.add(new JLabel("JLabel"));
		frame.add(new JCheckBox("JCheckBox"));
		ButtonGroup group = new ButtonGroup();
		JRadioButton button1 = new JRadioButton("JRadioButton 1");
		group.add(button1);
		frame.add(button1);
		JRadioButton button2 = new JRadioButton("JRadioButton 2");
		group.add(button2);
		frame.add(button2);
		frame.add(withTitle(new JSpinner()));
		frame.add(withTitle(new JSlider()));
		frame.add(withTitle(new JComboBox<String>(new String[] { "item 1",
				"item 2" })));
		JProgressBar bar = new JProgressBar();
		bar.setValue(20);
		frame.add(withTitle(bar));
		frame.add(new JTextField("JTextField (one line only!)"));

		frame.add(new JScrollPane(new JTextArea(
				"JTextArea (should alway be\ncombined with a JScrollPane)")));

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Surrounds the component with a titled border showing the name of the
	 * component class.
	 */
	JComponent withTitle(JComponent comp) {
		JComponent result = new JPanel();
		result.setBorder(BorderFactory.createTitledBorder(comp.getClass()
				.getSimpleName()));
		result.setLayout(new BorderLayout());
		result.add(comp);
		return result;
	}
}
