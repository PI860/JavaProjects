package PROG1.prog1demos.demos.rl.util.painttool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

/**
 * Central component of the Paint Tool framework which provides infrastructure
 * for displaying shapes on a canvas. It consists of a window with a toolbar and
 * a canvas. A list of drawable objects is maintained to support animation. The
 * constructor expects a controller implementation which defines window title,
 * the buttons to be added to the tool bar, the button behavior, and the
 * reaction on other mouse events. Drawable primitives as well as other helper
 * classes are realized as inner classes. So the tool needs only a few source
 * files which simplifies integration into student Java projects. The following
 * test program demonstrates how to build a simple controller for the tool.
 * <code><pre>
 * import java.awt.Color;
 * import java.util.Random;
 *
 * import rl.util.painttool.AbstractController;
 * import rl.util.painttool.PaintTool;
 *
 * public class SimplePaintDemo extends AbstractController {
 *
 * 	public String[] getButtonNames() {
 * 		return new String[] {"Random Objects"};
 * 	}
 *
 * 	public void onButtonPressed(PaintTool ptool, int button) {
 * 		switch (button) {
 * 		case 0: // button with index 0 pressed
 * 			ptool.clearCanvas();
 * 			for (int i = 0; i < 16; i++) {
 * 				Random r = new Random();
 * 				int shape = r.nextInt(5);
 * 				int x = r.nextInt(ptool.getCanvas().getWidth());
 * 				int y = r.nextInt(ptool.getCanvas().getHeight());
 * 				int size1 = r.nextInt(50) + 10;
 * 				int size2 = r.nextInt(50) + 10;
 * 				boolean fill = r.nextBoolean();
 * 				ptool.setColor(shape == 4 ? Color.GRAY : Color.BLUE);
 * 				switch (shape) {
 * 				case 0: ptool.addCircle(x, y, size1, fill); break;
 * 				case 1: ptool.addRectangle(x, y, size1, size2, fill); break;
 * 				case 2: ptool.addTriangle(x, y, size1, fill); break;
 * 				case 3: ptool.addPolygon(new int[] {x, x+size1, x+size2, x+size2-size1},
 * 						new int[] {y, y+size2, y+size1, y+size1-size2}, fill); break;
 * 				case 4: ptool.addText(x, y, "Test"); break;
 * 				}
 * 				ptool.sleep(200);
 * 			}
 * 			break;
 * 		}
 * 	}
 *
 * 	public static void main(String[] args) {
 * 		PaintTool ptool = new PaintTool(new SimplePaintDemo());
 * 		ptool.setVisible(true);
 * 	}
 * }
 * </pre></code>
 *
 * @author Ruediger Lunde
 */
public class PaintTool {

	private final AbstractController controller;
	private final Vector<DrawableObject> drawableObjects;
	private final Canvas canvas;
	private final JFrame frame;
	private Color currColor;
	private boolean autoUpdate;
	private Thread currActionThread;

	/**
	 * Constructs a new paint tool. A controller must be provided. It defines
	 * window title, action button names and action button behavior.
	 */
	public PaintTool(AbstractController controller) {
		Locale.setDefault(Locale.US);
		this.controller = controller;
		drawableObjects = new Vector<DrawableObject>();
		canvas = new Canvas(drawableObjects);
		frame = new JFrame();
		currColor = Color.BLACK;
		autoUpdate = true;
		init();
	}

	/**
	 * Initializes the tool frame and establishes listeners which delegate mouse
	 * event handling to the controller.
	 */
	private void init() {
		frame.setTitle(controller.getTitle());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JToolBar toolbar = new JToolBar();
		int i = 0;
		for (String buttonName : controller.getButtonNames()) {
			JButton button = new JButton(buttonName);
			button.addActionListener(new ButtonActionListener(i++));
			toolbar.add(button);
		}
		toolbar.addSeparator();
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ButtonActionListener(-1));
		toolbar.add(clearButton);
		frame.getContentPane().add(toolbar, BorderLayout.NORTH);
		canvas.setBackground(Color.WHITE);
		canvas.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
				PaintTool.this.controller.onMouseClick(PaintTool.this,
						me.getX(), me.getY(), me.getButton(), me.isShiftDown(),
						me.isControlDown());
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});
		frame.getContentPane().add(canvas, BorderLayout.CENTER);
		frame.pack();
	}

	/**
	 * Shows or hides the tool window depending on the value of <code>b</code>.
	 */
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

	/**
	 * Returns the list of currently maintained drawable objects.
	 */
	public List<DrawableObject> getDrawableObjects() {
		return drawableObjects;
	}

	/**
	 * Returns the canvas. The origin (0, 0) is in the left upper corner.
	 * Methods <code>getWidth()</code> and <code>getHeight()</code> provide the
	 * currently visible size.
	 */
	public JComponent getCanvas() {
		return canvas;
	}

	/**
	 * Empties the list of drawable objects, stops the currently running action
	 * thread if necessary and updates the canvas.
	 */
	public void clearCanvas() {
		getDrawableObjects().clear();
		if (autoUpdate)
			update();
	}

	/**
	 * Returns the color which is used for the next primitive shape to be added.
	 */
	public Color getColor() {
		return currColor;
	}

	/** Sets the color for the next primitive shape to be added. */
	public void setColor(Color color) {
		currColor = color;
	}

	/**
	 * Controls, whether the canvas is repainted automatically after each change
	 * in the list of drawable objects (value true) or only after the method
	 * {@link #update()} was called (value false). The default value is true;
	 * @return Previous value before executing the change;
	 */
	public boolean setAutoUpdate(boolean b) {
		boolean result = autoUpdate;
		autoUpdate = b;
		return result;
	}

	/**
	 * Adds a new line to the list of drawable objects and updates the canvas.
	 * The current color is used for the line.
	 */
	public DrawableObject addLine(int x0, int y0, int x1, int y1) {
		return addObject(new Line(x0, y0, x1, y1, currColor));
	}

	/**
	 * Adds a new circle to the list of drawable objects and updates the canvas.
	 * The current color is used for the circle.
	 */
	public DrawableObject addCircle(int x, int y, int radius, boolean fill) {
		return addObject(new Circle(x, y, radius, currColor, fill));
	}

	/**
	 * Adds a new rectangle to the list of drawable objects and updates the
	 * canvas. The current color is used for the rectangle.
	 */
	public DrawableObject addRectangle(int x, int y, int width, int height,
			boolean fill) {
		return addObject(new Rectangle(x, y, width, height, currColor, fill));
	}

	/**
	 * Adds a new triangle to the list of drawable objects and updates the
	 * canvas. The current color is used for the triangle.
	 */
	public DrawableObject addTriangle(int x, int y, int size, boolean fill) {
		return addObject(new Triangle(x, y, size, currColor, fill));
	}

	/**
	 * Adds a new polygon to the list of drawable objects and updates the
	 * canvas. The current color is used for the polygon.
	 */
	public DrawableObject addPolygon(int[] xCoords, int[] yCoords, boolean fill) {
		return addObject(new Polygon(xCoords, yCoords, currColor, fill));
	}

	/**
	 * Adds a new text to the list of drawable objects and updates the canvas.
	 */
	public DrawableObject addText(int x, int y, String text) {
		return addObject(new Text(x, y, text, currColor));
	}

	/**
	 * Adds an arbitrary drawable object to the list of maintained objects and
	 * updates the canvas.
	 */
	public DrawableObject addObject(DrawableObject o) {
		getDrawableObjects().add(o);
		if (autoUpdate)
			update();
		return o;
	}

	/**
	 * Removes a previously added drawable object from the list of maintained
	 * objects and updates the canvas.
	 */
	public void removeObject(DrawableObject o) {
		getDrawableObjects().remove(o);
		if (autoUpdate)
			update();
	}

	/** Causes the current thread to sleep for some milliseconds. */
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// do nothing...
			// e.printStackTrace();
		}
	}

	/**
	 * Repaints the canvas. If <code>autoUpdate</code> is enabled, this method
	 * is called automatically after each change in the list of drawable
	 * objects.
	 */
	public void update() {
		getCanvas().repaint();
	}

	/** for testing... */
	public static void main(String[] args) {
		AbstractController controller = new AbstractController() {
			@Override
			public String[] getButtonNames() {
				return new String[] { "Random Objects", "?" };
			}

			@Override
			public void onButtonPressed(PaintTool ptool, int button) {
				switch (button) {
				case 0: // button with index 0 pressed
					ptool.clearCanvas();
					for (int i = 0; i < 16; i++) {
						Random r = new Random();
						int shape = r.nextInt(5);
						int x = r.nextInt(ptool.getCanvas().getWidth());
						int y = r.nextInt(ptool.getCanvas().getHeight());
						int size1 = r.nextInt(50) + 10;
						int size2 = r.nextInt(50) + 10;
						boolean fill = r.nextBoolean();
						ptool.setColor(shape == 4 ? Color.GRAY : Color.BLUE);
						switch (shape) {
						case 0:
							ptool.addCircle(x, y, size1, fill);
							break;
						case 1:
							ptool.addRectangle(x, y, size1, size2, fill);
							break;
						case 2:
							ptool.addTriangle(x, y, size1, fill);
							break;
						case 3:
							ptool.addPolygon(new int[] { x, x + size1,
									x + size2, x + size2 - size1 },
									new int[] { y, y + size2, y + size1,
											y + size1 - size2 }, fill);
							break;
						case 4:
							ptool.addText(x, y, "Test");
							break;
						}
						ptool.sleep(200);
					}
					break;
				case 1:  // button with index 1 pressed
					JOptionPane
							.showMessageDialog(ptool.getCanvas(),
									"Paint Tool, Version 1.3"
											+ "\nHave fun, R. Lunde",
									"About Paint Tool",
									JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		};
		PaintTool ptool = new PaintTool(controller);
		ptool.setVisible(true);

	}

	// ////////////////////////////////////////////////////////////////////////
	// inner classes

	/** Primitive shape representing a line from (x0, y0) to (x1, y1). */
	public static class Line extends DrawableObject {
		int x1;
		int y1;
		Color color;

		public Line(int x0, int y0, int x1, int y1, Color color) {
			setXY(x0, y0);
			this.x1 = x1;
			this.y1 = y1;
			this.color = color;
		}

		@Override
		public void draw(Graphics2D g2) {
			g2.setColor(color);
			g2.drawLine(getX(), getY(), x1, y1);
		}
	}

	/** Primitive shape representing a circle at (x, y) with a specified radius. */
	public static class Circle extends DrawableObject {
		int radius;
		Color color;
		boolean fill;

		public Circle(int x, int y, int radius, Color color, boolean fill) {
			setXY(x, y);
			this.radius = radius;
			this.color = color;
			this.fill = fill;
		}

		@Override
		public void draw(Graphics2D g2) {
			g2.setColor(color);
			if (fill)
				g2.fillOval(getX()-radius, getY()-radius, 2*radius, 2*radius);
			else
				g2.drawOval(getX()-radius, getY()-radius, 2*radius, 2*radius);
		}
	}

	/**
	 * Primitive shape representing a rectangle at (x, y) with specified width
	 * and height.
	 */
	public static class Rectangle extends DrawableObject {
		int width;
		int height;
		Color color;
		boolean fill;

		public Rectangle(int x, int y, int width, int height, Color color,
				boolean fill) {
			setXY(x, y);
			this.width = width;
			this.height = height;
			this.color = color;
			this.fill = fill;
		}

		@Override
		public void draw(Graphics2D g2) {
			g2.setColor(color);
			if (fill)
				g2.fillRect(getX(), getY(), width, height);
			else
				g2.drawRect(getX(), getY(), width, height);
		}
	}

	/** Primitive shape representing a triangle at (x, y) with specified size. */
	public static class Triangle extends DrawableObject {
		int size;
		Color color;
		boolean fill;

		public Triangle(int x, int y, int size, Color color, boolean fill) {
			setXY(x, y);
			this.size = size;
			this.color = color;
			this.fill = fill;
		}

		@Override
		public void draw(Graphics2D g2) {
			g2.setColor(color);
			int x = getX();
			int y = getY();
			if (fill)
				g2.fillPolygon(new int[] { x, x + size, x + size / 2, x },
						new int[] { y + size, y + size, y, y + size }, 4);
			else
				g2.drawPolygon(new int[] { x, x + size, x + size / 2, x },
						new int[] { y + size, y + size, y, y + size }, 4);
		}
	}

	/**
	 * Primitive shape representing a polygon through the specified coordinates.
	 */
	public static class Polygon extends DrawableObject {
		int[] xCoords;
		int[] yCoords;
		Color color;
		boolean fill;

		public Polygon(int[] xCoords, int[] yCoords, Color color, boolean fill) {
			setXY(xCoords[0], yCoords[0]);
			this.xCoords = xCoords;
			this.yCoords = yCoords;
			this.color = color;
			this.fill = fill;
		}

		@Override
		public void draw(Graphics2D g2) {
			g2.setColor(color);
			if (fill)
				g2.fillPolygon(xCoords, yCoords, xCoords.length);
			else
				g2.drawPolygon(xCoords, yCoords, yCoords.length);
		}
	}

	/** Simple representation of a text at position (x, y). */
	public static class Text extends DrawableObject {
		String text;
		Color color;

		public Text(int x, int y, String text, Color color) {
			setXY(x, y);
			this.text = text;
			this.color = color;
		}

		@Override
		public void draw(Graphics2D g2) {
			g2.setColor(color);
			g2.drawString(text, getX(), getY());
		}
	}

	/**
	 * Helper class which delegates button events to the controller. A separate
	 * thread is used to support animation.
	 */
	private class ButtonActionListener implements ActionListener {
		int button;

		/**
		 * Creates a new listener.
		 *
		 * @param button
		 *            Indicates, which button was pressed. -1 is used for the
		 *            clear button.
		 */
		ButtonActionListener(int button) {
			this.button = button;
		}

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (currActionThread != null && currActionThread.isAlive())
				currActionThread.stop(); // quick and dirty...
			if (button == -1) {
				// clear button pressed
				clearCanvas();
				update();
				controller.onButtonPressed(PaintTool.this, button);
			} else {
				currActionThread = new Thread(new Runnable() {
					@Override
					public void run() {
						controller.onButtonPressed(PaintTool.this, button);
					}
				});
				currActionThread.start();
			}
		}
	}

	/**
	 * Component which displays a list of maintained drawable objects using 2d
	 * graphics.
	 */
	private static class Canvas extends JComponent {
		private static final long serialVersionUID = 1L;
		private Vector<DrawableObject> drawableObjects;

		Canvas(Vector<DrawableObject> drawableObjects) {
			this.drawableObjects = drawableObjects;
			this.setPreferredSize(new Dimension(600, 400));
		}

		@Override
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			super.paint(g2);
			g2.setBackground(getBackground()); // use component background color!
			g2.clearRect(0, 0, getWidth(), getHeight());
			@SuppressWarnings("unchecked")
			List<DrawableObject> objects = (List<DrawableObject>) drawableObjects
					.clone();
			for (DrawableObject o : objects)
				o.draw(g2);
		}
	}
}
