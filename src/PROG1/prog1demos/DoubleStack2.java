package PROG1.prog1demos;

/**
 * Improved stack implementation with information hiding.
 * @author Ruediger Lunde
 */
public class DoubleStack2 {
	private double[] numbers;
	private int size;
	
	public DoubleStack2() {};
	
	public DoubleStack2(int capacity) {
		numbers = new double[capacity];
		size = 0;
	}
	
	public void push(double number) {
		numbers[size] = number;
		size++;
	}
	
	public double pop() {
		size--;
		return numbers[size];
	}
	
	public double top() {
		return numbers[size-1];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == numbers.length;
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++)
			result += " " + numbers[i];
		return result;
	}
}
