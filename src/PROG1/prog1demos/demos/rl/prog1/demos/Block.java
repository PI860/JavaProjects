package PROG1.prog1demos.demos.rl.prog1.demos;

/**
 * Enumeration which represents six blocks for a HS-Ulm timetable.
 * @author Ruediger Lunde
 */
public enum Block {
	FIRST(8, 0), SECOND(9, 50), THIRD(11, 30), FOURTH(14, 0), FIFTH(15, 50), SIXTH(17, 30);

	int h;
	int min;
	
	Block(int h, int min) {
		this.h = h;
		this.min = min;
	}

	public int getNum() {
		return ordinal()+1;
	}

	public int getH() {
		return h;
	}

	public int getMin() {
		return min;
	}
}
