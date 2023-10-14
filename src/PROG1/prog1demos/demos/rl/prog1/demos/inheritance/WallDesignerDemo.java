//package PROG1.prog1demos.demos.rl.prog1.demos.inheritance;
//
//import java.awt.Color;
//
//import javax.swing.JOptionPane;
//
//import PROG1.prog1demos.demos.rl.util.painttool.AbstractController;
//import PROG1.prog1demos.demos.rl.util.painttool.DrawableObject;
//import PROG1.prog1demos.demos.rl.util.painttool.PaintTool;
//
///**
// * Simple tool for experiments with picture placement on a wall. It demonstrates
// * a use case for the {@link RectangleContainer}. The architecture of this
// * implementation has major disadvantages: All rectangles are represented twice.
// * One representation is used for analysis, the other for presentation. A
// * model-view-controller architecture would be the better choice.
// *
// * @author Ruediger Lunde
// *
// */
//public class WallDesignerDemo extends AbstractController {
//
//	private RectangleContainer container;
//	private int lastButton;
//	private DrawableObject currText;
//
//	@Override
//	public String getTitle() {
//		return "Wall Designer";
//	}
//
//	@Override
//	public String[] getButtonNames() {
//		return new String[] { "Small Picture", "Medium Picture",
//				"Large Picture", "?" };
//	}
//
//	@Override
//	public void onButtonPressed(PaintTool ptool, int button) {
//		if (button >= 0 && button < getButtonNames().length - 1)
//			lastButton = button;
//		else if (button == getButtonNames().length - 1) {
//			String currDesign = "";
//			if (container != null)
//				currDesign = "\n\nCurrent Design:\n"
//						+ container.describeContents();
//			JOptionPane.showMessageDialog(ptool.getCanvas(),
//					"Wall Designer, Version 1.0"
//							+ "\nTry also mouse clicks on the canvas."
//							+ "\nHave fun, R. Lunde" + currDesign,
//					"About Wall Designer", JOptionPane.INFORMATION_MESSAGE);
//		} else if (button == -1) {
//			container = null;
//			currText = null;
//		}
//	}
//
//	@Override
//	public void onMouseClick(PaintTool ptool, int x, int y, int mouseButton,
//			boolean isShiftDown, boolean isControlDown) {
//		// create a new container with canvas dimensions as bounds if necessary
//		if (container == null) {
//			Rectangle bounds = new SimpleRectangle(0, 0, ptool.getCanvas()
//					.getWidth(), ptool.getCanvas().getHeight());
//			container = new RectangleContainer(bounds, 100);
//		}
//		// create a new picture at mouse position and try to add it
//		BorderedRectangle br = new BorderedRectangle(new SimpleRectangle(x,
//				transformY(y), 30 * (lastButton + 1), 20 * (lastButton + 1)),
//				10);
//		if (container.add(br)) {
//			// show the picture on the canvas
//			if (currText != null)
//				ptool.removeObject(currText);
//			ptool.setColor(Color.DARK_GRAY);
//			ptool.addRectangle(br.getLeft(), transformY(br.getTop()),
//					br.getWidth(), br.getHeight(), true);
//			ptool.setColor(Color.LIGHT_GRAY);
//			Rectangle r = br.getContent();
//			ptool.addRectangle(r.getLeft(), transformY(r.getTop()),
//					r.getWidth(), r.getHeight(), true);
//			String txt = "Number of Pictures: " + container.size();
//			txt += ", Covered Area: " + container.getCoveredArea();
//			txt += ", Degree of Coverage: " + container.getRatioOfCoverage();
//			ptool.setColor(Color.GRAY);
//			currText = ptool.addText(10, 20, txt);
//		}
//	}
//
//	/**
//	 * Reflects y using the horizontal mid-line between the container bounds as
//	 * axis. This is necessary because the the origin for the rectangle class is
//	 * assumed in the left lower corner while the canvas uses an origin which is
//	 * in the left upper corner.
//	 */
//	private int transformY(int y) {
//		int result = y;
//		if (container != null)
//			result = container.getBounds().getTop() - y;
//		return result;
//	}
//
//	/** Starts the Wall Designer. */
//	public static void main(String[] args) {
//		WallDesignerDemo demo = new WallDesignerDemo();
//		PaintTool ptool = new PaintTool(demo);
//		ptool.setVisible(true);
//	}
//}
