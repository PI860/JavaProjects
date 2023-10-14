package PROG1.prog1demos.demos.rl.util.painttool;

import java.awt.Graphics2D;

/**
 * Super class for all shapes to be drawn on canvas.
 * Subclasses must implement the method
 * {@link #draw(Graphics2D)}.
 * @author Ruediger Lunde
 */
public abstract class DrawableObject {
	private int x;
	private int y;
	
	/** Returns the x-position of the object. */
	public int getX() {
		return x;
	}
	
	/** Returns the y-position of the object. */
	public int getY() {
		return y;
	}
	
	/**
	 * Modifies the position of the object. Not everyone
	 * is allowed to do this!
	 */
	protected void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Draws the object on the canvas using 2d graphics.
	 */
	public abstract void draw(Graphics2D g2);
}
