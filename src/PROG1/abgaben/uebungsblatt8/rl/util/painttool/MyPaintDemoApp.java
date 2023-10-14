package PROG1.abgaben.uebungsblatt8.rl.util.painttool;

/**
 * Starter for the Paint Demo Application.
 * 
 * @author Ruediger Lunde
 */
public class MyPaintDemoApp {
	/**
	 * Starts the application by creating a {@link MyPaintDemoController},
	 * providing it to the constructor of {@link PaintTool}, and then
	 * making the window visible.
	 */
	public static void main(String[] args) {
		PaintTool ptool = new PaintTool(new MyPaintDemoController());
		ptool.setVisible(true);
	}
}
