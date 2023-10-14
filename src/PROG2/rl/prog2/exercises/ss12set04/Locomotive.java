package rl.prog2.exercises.ss12set04;

/**
 * Represents a locomotive with length and typ. A car can be attached
 * by means of attribute <code>first</code>.
 * @author Ruediger Lunde
 */
public class Locomotive {
	private int length;
	private int type;
	private Car first;
	public Car getFirst() {
		return first;
	}
	
	public Locomotive(int length, int type) {
		this.length = length;
		this.type = type;
	}
	
	public void setFirst(Car first) {
		this.first = first;
	}
	public int getLength() {
		return length;
	}
	public int getType() {
		return type;
	}
}
