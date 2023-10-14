package rl.prog2.demos.gui.swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

/**
 * Demonstrates how to use <code>JTabbedPane</code>, <code>JSplitPane</code> and
 * <code>CardLayout</code>. A frame with a <code>JToolBar</code> and a
 * <code>JPanel</code> with <code>CardLayout</code> is constructed. One card is
 * filled with a <code>JTabbedPane</code>, another card is filled with a
 * <code>JSplitPane</code>. The visible card is controlled by a
 * <code>JComboBox</code>.
 * 
 * @author Ruediger Lunde
 */
public class SwingContainerDemo {
	/** Starts the demo. */
	public static void main(String[] args) {
		new SwingContainerDemo().start();
	}

	JPanel cards;

	/** Creates a frame, adds several components to it, and makes it visible. */
	public void start() {
		JFrame frame = new JFrame("Swing Container Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JToolBar toolbar = new JToolBar();
		frame.add(toolbar, BorderLayout.NORTH);
		JComboBox<String> combo = new JComboBox<String>(new String[] {
				"JTabbedPane", "JSplitPane" });
		combo.setToolTipText("Controls which card is shown.");
		combo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl = (CardLayout) cards.getLayout();
				cl.show(cards, (String) e.getItem());
			}
		});
		toolbar.add(combo);
		toolbar.add(Box.createHorizontalGlue());
		cards = new JPanel(new CardLayout());
		frame.add(cards, BorderLayout.CENTER);
		cards.add(createTabbedPane(), "JTabbedPane");
		cards.add(createSplitPane(), "JSplitPane");

		frame.setSize(600, 400);
		frame.setVisible(true);
	}

	JTabbedPane createTabbedPane() {
		JTabbedPane result = new JTabbedPane();
		JPanel panel = new JPanel();
		panel.add(new JButton("Button in first component"));
		result.addTab("Tab 1", panel);
		panel = new JPanel();
		panel.add(new JButton("Button in second component"));
		result.addTab("Tab 2", panel);
		return result;
	}

	JSplitPane createSplitPane() {
		JSplitPane result = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		result.setDividerLocation(200);
		result.setResizeWeight(0.5); // share extra space
		JPanel panel = new JPanel();
		panel.add(new JButton("Button in left component"));
		result.setLeftComponent(panel);
		panel = new JPanel();
		panel.add(new JButton("Button in right component"));
		result.setRightComponent(panel);
		return result;
	}
}
