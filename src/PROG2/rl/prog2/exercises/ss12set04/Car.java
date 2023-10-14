package rl.prog2.exercises.ss12set04;

/**
 * Represents a railroad car with length and passenger capacity. Another car can
 * be attached to it by means of attribute <code>next</code>.
 * @author Ruediger Lunde
 */
public class Car {
	private int length;
	private int capacity;
	private Car next;

	public Car getNext() {
		return next;
	}

	public Car(int length, int capacity) {
		this.length = length;
		this.capacity = capacity;
	}

	public void setNext(Car next) {
		this.next = next;
	}

	public int getLength() {
		return length;
	}

	public int getCapacity() {
		return capacity;
	}

}
