package PROG1.prog1demos.demos.rl.prog1.demos;

import java.util.Scanner;

/**
 * Provides a test method for class <code>DoubleStack2</code> and
 * a simple calculator implementation using Reverse Polish notation (RPN).
 * @author Ruediger Lunde
 */
public class DoubleStack2Test {

	public static void startStackTest() {
		DoubleStack2 stack = new DoubleStack2(100);
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop()); // -> 2
		System.out.println(stack.pop()); // -> 1
		//System.out.println(stack.size); // error if private!
	}
	
	public static void startCalculator() {
		Scanner scanner = new Scanner(System.in);
		DoubleStack2 stack = new DoubleStack2(20);
		String token = scanner.nextLine();
		while (!token.equals("exit")) {
			if (token.equals("+"))
				stack.push(stack.pop() + stack.pop());
			else if (token.equals("-"))
				stack.push(-stack.pop() + stack.pop());
			else if (token.equals("*"))
				stack.push(stack.pop() * stack.pop());
			else if (token.equals("/")) {
				stack.push(1.0 / stack.pop() * stack.pop());
			} else if (!token.equals("exit"))
				stack.push(Integer.parseInt(token));
			System.out.println("-> " + stack);
			token = scanner.nextLine();
		}
		scanner.close();
	}
	
	public static void main(String[] args) {
		// startStackTest();
		startCalculator();
	}
}
