package rl.prog2.demos.gui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Creates frames which demonstrate the behavior of different layout managers.
 * 
 * Fore details see: "A Visual Guide to Layout Managers" at
 * http://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
 * 
 * @author Ruediger Lunde
 */
public class LayoutManagerDemo {

	public static void main(String[] args) {
		startNullLayoutDemo();
		startBoxLayoutDemo(false);
		// startBoxLayoutDemo(true);
		startGridBagLayoutDemo();
		startLayoutDemo(new GridLayout(2, 3, 10, 10));
		// startLayoutDemo(new GridLayout(2, 3));
		startLayoutDemo(new FlowLayout());
		startBorderLayoutDemo();
	}

	/** Creates a frame, sets the frame layout as specified and adds 6 buttons. */
	public static void startLayoutDemo(LayoutManager layout) {
		JFrame frame = new JFrame(layout.getClass().getSimpleName());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(layout);

		JButton[] buttons = createButtons("Button 0", "Button 1", "Button 2",
				"Very Long Button 3", "Button 4", "Button 5");
		for (int i = 0; i < buttons.length; i++)
			frame.add(buttons[i]);

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Creates a frame, sets the frame layout to BorderLayout and adds 5
	 * buttons at the 5 predefined positions.
	 */
	public static void startBorderLayoutDemo() {
		JFrame frame = new JFrame("BorderLayout");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		JButton[] buttons = createButtons("NORTH", "WEST", "CENTER", "EAST",
				"SOUTH");

		frame.add(buttons[0], BorderLayout.NORTH);
		frame.add(buttons[1], BorderLayout.WEST);
		frame.add(buttons[2], BorderLayout.CENTER);
		frame.add(buttons[3], BorderLayout.EAST);
		frame.add(buttons[4], BorderLayout.SOUTH);

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Creates a frame, sets the frame layout to GridBagLayout and adds 6
	 * buttons at special grid positions.
	 */
	public static void startGridBagLayoutDemo() {
		JFrame frame = new JFrame("GridBagLayout");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridBagLayout());

		JButton[] buttons = createButtons("Button 0", "Button 1", "Button 2",
				"Very Long Button 3", "Button 4", "Button 5");
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.insets = new Insets(10, 10, 10, 10);

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		frame.add(buttons[0], c);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 2;
		frame.add(buttons[1], c);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.add(buttons[2], c);
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		frame.add(buttons[3], c);
		c.gridx = 1;
		c.gridy = 2;
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.EAST;
		frame.add(buttons[4], c);
		c.gridx = 2;
		c.gridy = 2;
		c.anchor = GridBagConstraints.WEST;
		frame.add(buttons[5], c);

		frame.pack();
		frame.setVisible(true);
	}

	/** Creates a frame, sets the frame layout to BoxLayout and adds 6 buttons. */
	public static void startBoxLayoutDemo(boolean horizontal) {
		JFrame frame = new JFrame("BoxLayout");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// note: the layout constructor needs the container object!
		Container content = frame.getContentPane();
		if (horizontal)
			content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
		else
			content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

		JButton[] buttons = createButtons("Button 0", "Button 1", "Button 2",
				"Very Long Button 3", "Button 4", "Button 5");
		for (int i = 0; i < buttons.length; i++)
			frame.add(buttons[i]);

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Creates a frame, sets the frame layout to null and adds 6 buttons at
	 * arbitrary positions. It is not recommended to use this pattern!
	 */
	public static void startNullLayoutDemo() {
		JFrame frame = new JFrame("null-Layout");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);

		JButton[] buttons = createButtons("Button 0", "Button 1", "Button 2",
				"Very Long Button 3", "Button 4", "Button 5");
		buttons[0].setBounds(5, 10, 200, 50);
		buttons[1].setBounds(250, 30, 100, 50);
		buttons[2].setBounds(50, 75, 100, 50);
		buttons[3].setBounds(150, 150, 200, 50);
		buttons[4].setBounds(100, 175, 200, 50);
		buttons[5].setBounds(50, 200, 100, 50);
		for (int i = 0; i < buttons.length; i++) {
			frame.add(buttons[i]);
		}

		frame.setSize(400, 300);
		frame.setVisible(true);
	}
	
	
	/** Creates Buttons (for each specified name one). */
	private static JButton[] createButtons(String... names) {
		JButton[] result = new JButton[names.length];
		Color[] colors = new Color[] { Color.RED, Color.ORANGE, Color.YELLOW,
				Color.GREEN, Color.BLUE, Color.MAGENTA };
		for (int i = 0; i < names.length; i++) {
			result[i] = new JButton(names[i]);
			result[i].setBackground(colors[i % colors.length]);
		}
		return result;
	}
}
