package PROG1.abgaben.uebungsblatt8.rl.util.painttool;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * This class implements a controller for the Paint Tool. Its main purpose is to
 * demonstrate some of the features of the Paint Tool.
 *
 * @author Ruediger Lunde
 *
 */
public class PaintDemoController extends AbstractController {

	/** Returns "Paint Demo". */
	@Override
	public String getTitle() {
		return "Paint Demo";
	}

	/** Returns the names of three buttons. */
	@Override
	public String[] getButtonNames() {
		return new String[] { "Random Objects", "Cross", "?" };
	}

	/**
	 * Depending on the button number, some random shapes are drawn, a red cross
	 * is popped up for some moments, or a dialog box is shown.
	 */
	@Override
	public void onButtonPressed(PaintTool ptool, int button) {
		int cWidth = ptool.getCanvas().getWidth();
		int cHeight = ptool.getCanvas().getHeight();
		switch (button) {
		case 0:
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
					ptool.addPolygon(new int[] { x, x + size1, x + size2,
							x + size2 - size1 }, new int[] { y, y + size2,
							y + size1, y + size1 - size2 }, fill);
					break;
				case 4:
					ptool.addText(x, y, "Test");
					break;
				}
				ptool.sleep(200);
			}
			break;
		case 1:
			ptool.setColor(Color.RED);
			DrawableObject o1 = ptool
					.addLine(20, 20, cWidth - 20, cHeight - 20);
			DrawableObject o2 = ptool
					.addLine(cWidth - 20, 20, 20, cHeight - 20);
			ptool.sleep(1000);
			ptool.removeObject(o1);
			ptool.removeObject(o2);
			break;
		case 2:
			JOptionPane.showMessageDialog(ptool.getCanvas(),
					"Paint Demo, Version 1.2"
							+ "\nThis is a simple application which"
							+ " demonstrates some features of the Paint Tool."
							+ "\nThe code of DemoController can be used "
							+ "as template for your own implementations."
							+ "\nTry also mouse clicks on the canvas."
							+ "\nHave fun, R. Lunde",
					"About Paint Demo",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}

	/**
	 * Prints a text on the canvas at the point where the click was done. It
	 * describes the state of the mouse.
	 */
	@Override
	public void onMouseClick(PaintTool ptool, int x, int y, int mouseButton,
			boolean isShiftDown, boolean isControlDown) {
		ptool.setColor(Color.MAGENTA);
		ptool.addText(x, y, "Click at (" + x + ", " + y + "): " + mouseButton
				+ " " + isShiftDown + " " + isControlDown);
	}
}
