package PROG1.prog1demos.demos.rl.util.painttool;

/**
 * Super class for all Paint Tool controllers. A Paint Tool controller defines the
 * title for the window, the names of the buttons to be added to the
 * toolbar, and the reaction on mouse clicks on the canvas and the buttons.
 * Override the default implementations of the corresponding methods to realize
 * the desired behavior.
 * @author Ruediger Lunde
 */
public abstract class AbstractController {
	/** Provides the title for the Paint Tool window. */
	public String getTitle() {
		return "Paint Tool";
	}

	/**
	 * Provides the button names for all action buttons to be added to the
	 * toolbar.
	 */
	public String[] getButtonNames() {
		return new String[0];
	}

	/**
	 * Defines the behavior for all action buttons including the Clear button.
	 *
	 * @param ptool
	 *            The Paint Tool instance.
	 * @param button
	 *            Number indicating the button which was pressed. Value 0 means
	 *            the first action button in the list of buttons, -1 the Clear
	 *            button.
	 */
	public void onButtonPressed(PaintTool ptool, int button) {
	}

	/**
	 * Defines the behavior for mouse clicks on the canvas.
	 *
	 * @param ptool
	 *            The Paint Tool instance.
	 * @param x
	 *            Position of the mouse
	 * @param y
	 *            Position of the mouse
	 * @param mouseButton
	 *            Index of the mouse button which has changed its state.
	 * @param isShiftDown
	 *            Status of shift button
	 * @param isControlDown
	 *            Status of control button
	 */
	public void onMouseClick(PaintTool ptool, int x, int y, int mouseButton,
			boolean isShiftDown, boolean isControlDown) {
	}
}
