package PROG1.abgaben.uebungsblatt8.rl.util.painttool;


import PROG1.abgaben.uebungsblatt8.pp.prog1.exercises.set08.Point;
import PROG1.abgaben.uebungsblatt8.pp.prog1.exercises.set08.LeastSquaresEstimator;

import java.awt.*;

/**
 * This class implements a controller for the Paint Tool. Its main purpose is to
 * demonstrate some of the features of the Paint Tool.
 *
 * @author Ruediger Lunde
 *
 */
public class MyPaintDemoController extends AbstractController {

	/** Returns "Paint Demo". */
	@Override
	public String getTitle() {
		return "Linear Regression Paint Demo";
	}

	/**
	 * Prints a text on the canvas at the point where the click was done. It
	 * describes the state of the mouse.
	 */
	@Override
	public void onMouseClick(PaintTool ptool, int x, int y, int mouseButton,
							 boolean isShiftDown, boolean isControlDown) {
		ptool.setColor(Color.RED);
		ptool.addCircle(x, y, 4, true);
		ptool.addText(x,y, "" + x + y);
	}

	/** Returns the names of three buttons. */
	@Override
	public String[] getButtonNames() {
		return new String[] { /*"Random Objects", "Cross", "?"*/ "Perform Linear Regression"};
	}

	/**
	 * Depending on the button number, some random shapes are drawn, a red cross
	 * is popped up for some moments, or a dialog box is shown.
	 */
	@Override
	public void onButtonPressed(PaintTool ptool, int button) {
		int cWidth = ptool.getCanvas().getWidth();
		cWidth = 12;
		int cHeight = ptool.getCanvas().getHeight();

		 Point[] pointsFromMyPaintDemoController = new Point[ptool.getDrawableObjects().size()];
		int i = 0;
		ptool.setColor(Color.BLUE);
		for(DrawableObject object : ptool.getDrawableObjects()) {
			// Point point = new Point(object.getX(), object.getY());
			Point point = new Point(cWidth, object.getY());
			pointsFromMyPaintDemoController[i++] = point;
			// System.out.println(object.getX() + " " + object.getY());
		} // Jetzt stehen die Koordinaten der Drawableobjects in dem Point Array

		// Integration of class:
		LeastSquaresEstimator test = new LeastSquaresEstimator(pointsFromMyPaintDemoController);
		test.calculateRegressionLine();

		ptool.addLine(1, test.calculateFirstPointOnRegressionLine(), 12, test.calculateRegressionLine());

		}
}
