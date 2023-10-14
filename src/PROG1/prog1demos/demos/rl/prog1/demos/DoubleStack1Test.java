package PROG1.prog1demos.demos.rl.prog1.demos;

/**
 * Provides operations as well as a test method for class <code>DoubleStack1</code>.
 * @author Ruediger Lunde
 */
public class DoubleStack1Test {

	public static void reset(DoubleStack1 stack) {
		stack.numbers = new double[100];
		stack.size = 0;
	}
	
	public static void push(DoubleStack1 stack, double num) {
		stack.numbers[stack.size] = num;
		stack.size++;
	}
	
	public static double pop(DoubleStack1 stack) {
		stack.size--;
		return stack.numbers[stack.size];
	}
	
	// ...
	
	public static void main(String[] args) {
		DoubleStack1 stack = new DoubleStack1();
		reset(stack);
		push(stack, 1);
		push(stack, 2);
		System.out.println(pop(stack)); // -> 2
		System.out.println(pop(stack)); // -> 1
	}
}
