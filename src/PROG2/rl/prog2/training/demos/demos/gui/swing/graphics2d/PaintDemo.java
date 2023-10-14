package rl.prog2.demos.gui.swing.graphics2d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Demo application showing a simple random graph.
 * @author Ruediger Lunde
 */
public class PaintDemo {

	private MyCanvas canvas;
	
	/** Contains the x-coordinates of the graph nodes. */
	private ArrayList<Integer> xCoords;
	/** Contains the y-coordinates of the graph nodes. */
	private ArrayList<Integer> yCoords;
	private Random rand;

	/** Initializes the graph, constructs the demo frame, and makes it visible. */
	public void start() {
		xCoords = new ArrayList<Integer>();
		yCoords = new ArrayList<Integer>();
		rand = new Random();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new MyCanvas();
		frame.add(canvas, BorderLayout.CENTER);
		JButton addNodeButton = new JButton("Add Node");
		frame.add(addNodeButton, BorderLayout.SOUTH);
		addNodeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				xCoords.add(rand.nextInt(canvas.getWidth()));
				yCoords.add(rand.nextInt(canvas.getHeight()));
				canvas.repaint();
			}
		});

		frame.setSize(400, 400);
		frame.setVisible(true);
	}

	/** Creates the paint demo and starts it. */
	public static void main(String[] args) {
		PaintDemo demo = new PaintDemo();
		demo.start();
	}

	/** Shows the graph using 2D graphics. */
	@SuppressWarnings("serial")
	private class MyCanvas extends JPanel {
		private final int NODE_SIZE = 20;

		public void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.GRAY);
			for (int i = 1; i < xCoords.size(); i++) {
				g.drawLine(xCoords.get(i - 1), yCoords.get(i - 1),
						xCoords.get(i), yCoords.get(i));
			}
			g.setColor(Color.RED);
			for (int i = 0; i < xCoords.size(); i++) {
				g.fillOval(xCoords.get(i) - NODE_SIZE / 2, yCoords.get(i)
						- NODE_SIZE / 2, NODE_SIZE, NODE_SIZE);
			}
		}
	}
}
