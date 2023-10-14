package programming1lunde.prog1demos.demos.rl.prog1.demos.inheritance;

public class BorderedRectangle implements Rectangle {

	private Rectangle rect;
	private int borderWidth;

	public BorderedRectangle(Rectangle rect, int borderWidth) {
		this.rect = rect;
		this.borderWidth = borderWidth;
	}

	public int getBorderWidth() {
		return borderWidth;
	}

	public Rectangle getContent() {
		return rect;
	}

	@Override
	public int getLeft() {
		return rect.getLeft() - borderWidth;
	}

	@Override
	public int getRight() {
		return rect.getRight() + borderWidth;
	}

	@Override
	public int getBottom() {
		return rect.getBottom() - borderWidth;
	}

	@Override
	public int getTop() {
		return rect.getTop() + borderWidth;
	}

	@Override
	public int getWidth() {
		return rect.getWidth() + 2 * borderWidth;
	}

	@Override
	public int getHeight() {
		return rect.getHeight() + 2 * borderWidth;
	}

	@Override
	public int getArea() {
		return getWidth() * getHeight();
	}

	public boolean isDisjoint(Rectangle r) {
		return r.getRight() <= getLeft() // r to the left of this
				|| r.getTop() <= getBottom() // r below this
				|| r.getLeft() >= getRight() // r to the right of this
				|| r.getBottom() >= getTop(); // r above this
	}

	public String toString() {
		return rect + " with Border(" + borderWidth + ")";
	}
}
