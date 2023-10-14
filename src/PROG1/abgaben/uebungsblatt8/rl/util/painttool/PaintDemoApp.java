package PROG1.abgaben.uebungsblatt8.rl.util.painttool;

/**
 * Starter for the Paint Demo Application.
 * 
 * @author Ruediger Lunde
 */
public class PaintDemoApp {
	/**
	 * Starts the application by creating a {@link PaintDemoController},
	 * providing it to the constructor of {@link PaintTool}, and then
	 * making the window visible.
	 */
	public static void main(String[] args) {
		PaintTool ptool = new PaintTool(new PaintDemoController());
		ptool.setVisible(true);
	}
}
