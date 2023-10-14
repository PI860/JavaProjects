package PROG1.prog1demos.exceptions;

public class Rectangle implements Cloneable {

	private int left;
	private int bottom;
	private int width;
	private int height;

	public Rectangle() throws Exception {
		this(0, 0, 20);
	}

	public Rectangle(int l, int b, int size) throws Exception {
		this(l, b, size, size);
	}

	public Rectangle(int l, int b, int w, int h) throws Exception {
		setPos(l, b);
		setDim(w, h);
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

	//...
	public void setPos(int l, int b) throws Exception {
		if (l < 0 || b < 0)
			throw new Exception("Position incorrect.");
		left = l;
		bottom = b;
	}

	public void setDim(int w, int h) throws Exception {
		if (w < 0 || h < 0)
			throw new Exception("Dimensions incorrect.");
		width = w;
		height = h;
	}

	public void setPos1(int l, int b) {
		if (l < 0 || b < 0)
			throw new RuntimeException("Position incorrect.");
		left = l;
		bottom = b;
	}

	public void setDim1(int w, int h) {
		if (w < 0 || h < 0)
			throw new RuntimeException("Dimensions incorrect.");
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

