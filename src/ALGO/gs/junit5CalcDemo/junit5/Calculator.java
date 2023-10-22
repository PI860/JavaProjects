package junit5;

public class Calculator {
	private int value = 0;
	
	public int getValue() {
		return value;
	}
	
	public int add(int n) {
		value += n;
		return value;
	}

	public int sub(int n) {
		value += n;   //!!!Fehler!!!
		return value;
	}

	public int mult(int n) {
		value *= n;
		return value;
	}
	
	public int div(int n) {
		value /= n;
		return value;
	}
	
	public void reset() {
		value = 0;
	}
}
