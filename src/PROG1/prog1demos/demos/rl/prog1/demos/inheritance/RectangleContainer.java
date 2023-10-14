package programming1lunde.prog1demos.demos.rl.prog1.demos.inheritance;


/**
 * Container for non-overlapping rectangles. The area for the contained
 * rectangles is bounded by a rectangle.
 * 
 * @author Ruediger Lunde
 */
public class RectangleContainer implements Cloneable {
	// outer rectangle
	private Rectangle bounds;
	// inner rectangles
	private Rectangle[] elementData;
	/** Number of currently maintained inner rectangles. */
	private int size;

	/** Creates a new container. */
	public RectangleContainer(Rectangle bounds, int capacity) {
		this.bounds = bounds;
		elementData = new Rectangle[capacity];
	}

	/**
	 * Returns the bounds of the area for the contained rectangles.
	 */
	public Rectangle getBounds() {
		return bounds;
	}

	/** Returns the i-th contained rectangle (0 < i < size). */
	public Rectangle get(int i) {
		// we should check whether i < size
		return elementData[i];
	}

	/** Returns the number of contained rectangles. */
	public int size() {
		return size;
	}

	/**
	 * Adds a rectangle if it (1) fits with respect to capacity, (2) lies
	 * completely inside the the outer rectangle, and (3) does not overlap with
	 * existing rectangles.
	 * 
	 * @return Success.
	 */
	public boolean add(Rectangle rect) {
		if (size == elementData.length || rect.getLeft() < bounds.getLeft()
				|| rect.getBottom() < bounds.getBottom()
				|| rect.getRight() > bounds.getRight()
				|| rect.getTop() > bounds.getTop()) {
			return false;
		} else {
			for (int i = 0; i < size(); i++)
				if (!rect.isDisjoint(get(i)))
					return false;
		}
		elementData[size++] = rect;
		return true;
	}

	/** Returns the sum of the areas of all contained rectangles. */
	public int getCoveredArea() {
		int result = 0;
		for (int i = 0; i < size(); i++)
			result += get(i).getArea();
		return result;
	}

	/** Returns the covered to bounds-defined area ratio in percent. */
	public int getRatioOfCoverage() {
		return 100 * getCoveredArea() / bounds.getArea();
	}

	/** Describes all contained rectangles. */
	public String describeContents() {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < size(); i++)
			result.append(get(i) + "\n"); // calls toString
		return result.toString();
	}
	
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		RectangleContainer result = (RectangleContainer) super.clone();
//		result.bounds = bounds.clone();
//		result.elementData = result.elementData.clone();
//		for (int i = 0; i < size; i++)
//			result.elementData[i] = elementData[i].clone();
//		return result;
//	}

	/** for testing... */
	public static void main(String[] args) {
		
		RectangleContainer container = new RectangleContainer(
				new SimpleRectangle(0, 0, 50, 40), 100);
		// container.add(new SimpleRectangle(10, 10, 10, 10));
		// container.add(new SimpleRectangle(20, 10, 10, 10));
		container.add(new BorderedRectangle(
				new SimpleRectangle(10, 25, 10, 10), 5));
		container.add(new BorderedRectangle(
				new SimpleRectangle(30, 25, 10, 10), 5));
		System.out.println("Covered Area: " + container.getCoveredArea());
		System.out.println("Ratio of Coverage: "
				+ container.getRatioOfCoverage());
		System.out.println("Contents:\n" + container.describeContents());
	}

}
