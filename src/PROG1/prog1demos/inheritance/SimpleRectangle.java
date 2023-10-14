package programming1lunde.prog1demos.inheritance;


public class SimpleRectangle implements Rectangle {
	
	private int left;
	private int bottom;
	private int width;
	private int height;
	
	public SimpleRectangle(int l, int b, int w, int h) {
		left = l;
		bottom = b;
		width = Math.abs(w); // safety first!
		height = Math.abs(h);
	}
	
	public int getLeft() {
		return left;
	}

	public int getRight() {
		return left + width;
	}

	public int getBottom() {
		return bottom;
	}

	public int getTop() {
		return bottom + height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getArea() {
		return width * height;
	}
	
	public boolean isDisjoint(Rectangle r) {
		return r.getRight() <= getLeft() // r to the left of this
				|| r.getTop() <= getBottom() // r below this
				|| r.getLeft() >= getRight() // r to the right of this
				|| r.getBottom() >= getTop(); // r above this
	}
	
	public String toString() {
		return "SimpleRectangle(" + left + ", " + bottom + ", " + width + ", "
				+ height + ")";
	}
}
