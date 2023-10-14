package PROG1.prog1demos;

public class Rectangle implements Cloneable {
	public final static double FOUR_THREE = 4.0 / 3.0;
	public final static double SIXTEEN_NINE = 16.0 / 9.0;
	private static int count;

	private int left;
	private int bottom;
	private int width;
	private int height;

	public Rectangle() {
		this(0, 0, 20);
	}

	public Rectangle(int l, int b, int size) {
		this(l, b, size, size);
	}

	public Rectangle(int l, int b, int w, int h) {
		left = l;
		bottom = b;
		width = Math.abs(w); // safety first!
		height = Math.abs(h);
		count++;
	}

	public Rectangle(int left, int bottom, double diagonalSize,
			double aspectRatio) {
		this.left = left;
		this.bottom = bottom;
		height = (int) Math.round(Math.sqrt(Math.pow(diagonalSize, 2)
				/ (1 + Math.pow(aspectRatio, 2))));
		width = (int) Math.round(height * aspectRatio);
		count++;
	}

	public static int getCount() {
		return count;
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

	public void setPos(int l, int b) {
		left = l;
		bottom = b;
	}

	// Version with this
	public void setPos1(int left, int bottom) {
		this.left = left; // !
		this.bottom = bottom; // !
	}

	public void setDim(int w, int h) {
		width = w;
		height = h;
	}

	public int getArea() {
		return width * height;
	}

	public void print() {
		System.out.println("Rectangle(" + left + ", " + bottom + ", " + width
				+ ", " + height + ")");
	}

	public Rectangle move(int dx, int dy) {
		left += dx;
		bottom += dy;
		return this; // !
	}

	public Rectangle move(double deg, double dist) {
		double angle = deg / 180.0 * Math.PI;
		left += Math.round(Math.sin(angle) * dist);
		bottom += Math.round(Math.cos(angle) * dist);
		return this;
	}

	public String toString() {
		return "Rectangle(" + left + ", " + bottom + ", " + width + ", "
				+ height + ")";
	}

	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		else {
			Rectangle r = (Rectangle) o;
			return left == r.left && bottom == r.bottom
			    && width == r.width && height == r.height;
		}
	}

	@Override
	public int hashCode() {
		return left + bottom + width + height;
	}
	
	@Override
	public Rectangle clone() throws CloneNotSupportedException {
		return (Rectangle) super.clone();
	}
}
