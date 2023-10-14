package rl.prog2.demos.gui.swing.dice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JToggleButton;

/**
 * Button, which represents a die. The current face value is visualized by drawn
 * dots on top of the button.
 * 
 * @author Ruediger Lunde
 */
@SuppressWarnings("serial")
public class DieButton extends JToggleButton {
	private int faceValue;

	/** Creates a die button with face value 1. */
	public DieButton() {
		setPreferredSize(new Dimension(80, 80));
		faceValue = 1;
	}

	/**
	 * Changes the face value of the die button.
	 * 
	 * @param value
	 *            Number between 1 and 6.
	 */
	public void setFaceValue(int value) {
		this.faceValue = value;
		repaint(); // causes a call to this component's paint method as
					// soon as possible
	}

	/** Uses normal button look and print dots on top. */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch (faceValue) {
		case 1:
			paintDots(g, new int[] { 4 });
			break;
		case 2:
			paintDots(g, new int[] { 2, 6 });
			break;
		case 3:
			paintDots(g, new int[] { 2, 4, 6 });
			break;
		case 4:
			paintDots(g, new int[] { 0, 2, 6, 8 });
			break;
		case 5:
			paintDots(g, new int[] { 0, 2, 4, 6, 8 });
			break;
		case 6:
			paintDots(g, new int[] { 0, 2, 3, 5, 6, 8 });
			break;
		}
	}

	/**
	 * Paints dots at the specified positions. Values between 0 (top left) and 8
	 * (bottom right) are expected.
	 */
	protected void paintDots(Graphics g, int[] posIndices) {
		int w = getWidth();
		int h = getHeight();
		int dotSize = Math.min(w, h) / 6;
		g.setColor(Color.BLACK);
		for (int i = 0; i < posIndices.length; i++)
			g.fillOval( // x=0, y=0 is top left corner of the button
					(posIndices[i] % 3 + 1) * w / 4 - dotSize / 2, // x
					(posIndices[i] / 3 + 1) * h / 4 - dotSize / 2, // y
					dotSize /* width */, dotSize /* height */);
	}
}
