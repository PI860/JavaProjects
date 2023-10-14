package rl.prog2.demos.gui.swing;

import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;

public class ButtonModelDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Button Model Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu menu = new JMenu("Options");
		menuBar.add(menu);
		JCheckBoxMenuItem item = new JCheckBoxMenuItem("Look at my selection state...");
		menu.add(item);
		JToggleButton button = new JToggleButton("Press me");
		button.setModel(item.getModel()); // !
		frame.add(button);
		JCheckBox checkBox = new JCheckBox("My selection state will change...");
		checkBox.setModel(item.getModel()); // !
		frame.add(checkBox, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

}
