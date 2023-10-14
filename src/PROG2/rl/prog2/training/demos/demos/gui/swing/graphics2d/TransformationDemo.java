package rl.prog2.demos.gui.swing.graphics2d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * Demonstrates, how affine transformations from the java2d API can be used to
 * map coordinates between different coordinate systems. Here, a model matrix is
 * used to map from model space to world space (for model positioning) and a
 * view matrix is used to map from world space to view space (to display the
 * scene on screen). When running the demo, play with the control buttons and
 * also klick on the canvas!
 * 
 * @author Ruediger Lunde
 */
public class TransformationDemo {

	private JCheckBox axisCheckBox;
	private DemoCanvas canvas;
	private JLabel infoLabel;

	private int modelX;
	private int modelY;
	private int modelCourse; // in degree!
	private double modelSpeed = 10.0;
	private double scale = 1.0;

	/** Creates the transformation demo and starts it. */
	public static void main(String[] args) {
		TransformationDemo demo = new TransformationDemo();
		demo.start();
	}

	/** Constructs the demo frame, and makes it visible. */
	public void start() {
		JFrame frame = new JFrame("Transformation Demo (click on canvas!)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JToolBar toolbar = new JToolBar();
		frame.add(toolbar, BorderLayout.NORTH);
		JButton button = new JButton("Move");
		toolbar.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				double theta = modelCourse * Math.PI / 180;
				modelX += Math.sin(theta) * modelSpeed;
				modelY -= Math.cos(theta) * modelSpeed;
				canvas.repaint();
				printModelInfo();
			}
		});
		button = new JButton("Turn Left");
		toolbar.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				modelCourse = (modelCourse + 350) % 360;
				canvas.repaint();
				printModelInfo();
			}
		});
		button = new JButton("Turn Right");
		toolbar.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				modelCourse = (modelCourse + 10) % 360;
				canvas.repaint();
				printModelInfo();
			}
		});
		toolbar.addSeparator();
		button = new JButton("Zoom In");
		toolbar.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				scale *= 1.5;
				canvas.repaint();
				canvas.updateMatrices(); // to get new matrix immediately
				infoLabel.setText("Scale: " + Math.round(scale * 10) / 10.0
						+ "  ViewMatrix: " + formatMatrix(canvas.viewMatrix));
			}
		});
		button = new JButton("Zoom Out");
		toolbar.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				scale /= 1.5;
				canvas.repaint();
				canvas.updateMatrices(); // to get new matrix immediately
				infoLabel.setText("Scale: " + Math.round(scale * 10) / 10.0
						+ "  ViewMatrix: " + formatMatrix(canvas.viewMatrix));
			}
		});
		toolbar.addSeparator();
		axisCheckBox = new JCheckBox("Axis of Coordinates");
		toolbar.add(axisCheckBox);
		axisCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.repaint();
			}
		});
		canvas = new DemoCanvas();
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				printPositionInfo(e.getX(), e.getY());
			}
		});
		frame.add(canvas, BorderLayout.CENTER);
		infoLabel = new JLabel(" ");
		infoLabel.setBorder(BorderFactory.createEtchedBorder());
		frame.add(infoLabel, BorderLayout.SOUTH);

		frame.setSize(600, 400);
		frame.setVisible(true);
	}

	void printModelInfo() {
		canvas.updateMatrices(); // make sure that matrix is up do date
		infoLabel.setText("Model Data: WorldPos (" + modelX + ", " + modelY
				+ "),  Course " + modelCourse + ";  ModelMatrix: "
				+ formatMatrix(canvas.modelMatrix));
	}

	/**
	 * Demonstrates how view coordinates can be mapped back to world coordinates
	 * by means of the inverse view matrix.
	 */
	void printPositionInfo(int xView, int yView) {
		try {
			String text = "ViewPos " + formatVector(xView, yView, 1);
			//double[] mx = new double[6];
			//canvas.viewMatrix.getMatrix(mx);
			text += " = ViewMatrix " + formatMatrix(canvas.viewMatrix);
			Point2D p = canvas.viewMatrix.inverseTransform(new Point(xView,
					yView), null);
			text += " * WorldPos " + formatVector(p.getX(), p.getY(), 1);
			infoLabel.setText(text);
		} catch (NoninvertibleTransformException e1) {
			e1.printStackTrace();
		}
	}

	String formatMatrix(AffineTransform at) {
		double[] mx = new double[6];
		at.getMatrix(mx);
		return "(" + formatVector(mx[0], mx[2], mx[4]) + " "
				+ formatVector(mx[1], mx[3], mx[5]) + " (0, 0, 1))";
	}

	String formatVector(double x, double y, double z) {
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		nf.setMaximumFractionDigits(1);
		return "(" + nf.format(x) + ", " + nf.format(y) + ", " + nf.format(z)
				+ ")";
	}

	/**
	 * Maintains view and model matrix and uses them to display the world origin
	 * (represented by two crossing lines) and a model (represented by a
	 * triangle). The view matrix is defined by the size of the canvas component
	 * (in pixel) and the scale factor. The model matrix is defined by the
	 * course and position (in world coordinates) of the model.
	 */
	@SuppressWarnings("serial")
	private class DemoCanvas extends JPanel {

		AffineTransform viewMatrix;
		AffineTransform modelMatrix;

		public void updateMatrices() {
			// note: execution is performed in reverse order!
			// 4. translate: world origin -> canvas center
			viewMatrix = AffineTransform.getTranslateInstance(getWidth() / 2,
					getHeight() / 2);
			// 3. scale: size in world -> size in view
			viewMatrix.scale(scale, scale);
			// 2. translate: model center -> position of model in world
			modelMatrix = AffineTransform.getTranslateInstance(modelX, modelY);
			// 1. rotate: model coordinates around model origin by modelCourse
			modelMatrix.rotate(modelCourse * Math.PI / 180);
		}

		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			AffineTransform saved = g2.getTransform();
			g.clearRect(0, 0, getWidth(), getHeight());
			updateMatrices();
			//paintModel(g2);
			paintAxis(g, "View");

			g2.transform(viewMatrix);
			paintWorldOrigin(g2);
			//paintModel(g2);
			paintAxis(g, "World");

			g2.transform(modelMatrix);
			paintModel(g2);
			paintAxis(g, "Model");
			
			g2.setTransform(saved); // restore original transformation
		}
		
		/** Paints two crossing lines. */
		private void paintWorldOrigin(Graphics2D g2) {
			g2.setColor(Color.GRAY);
			g2.drawLine(-10, 0, 10, 0);
			g2.drawLine(0, -10, 0, 10);
		}
		
		/** Paints a triangle at the origin pointing upwards */
		private void paintModel(Graphics2D g2) {
			g2.setPaint(new GradientPaint(0, -20, Color.LIGHT_GRAY, 0, 20,
					Color.DARK_GRAY));
			g2.fillPolygon(new int[] { 0, 10, -10 }, new int[] { -20, 20, 20 },
					3);
		}

		/** Paints two arrows - red represents x-axis, green represents y-axis. */
		private void paintAxis(Graphics g, String name) {
			if (axisCheckBox.isSelected()) {
				g.setColor(Color.RED);
				g.drawLine(0, 0, 15, 0);
				g.fillPolygon(new int[] { 20, 15, 15 }, new int[] { 0, -3, 3 },
						3);
				g.setColor(Color.GREEN);
				g.drawLine(0, 0, 0, 15);
				g.fillPolygon(new int[] { 0, -3, 3 },
						new int[] { 20, 15, 15 }, 3);
				g.setColor(Color.GRAY);
				g.drawString(name, 10, 20);
			}
		}
	}
}
