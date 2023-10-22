package ALGO.pp.aufgabenblaetter.blatt01;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Aufg14_Rekursion {

	/**
	 * Checks if value x is contained in arr[0..endIndex]
	 */
	public static boolean contains(double x, double[] arr, int endIndex) {
		//TODO
		//TODO
		//TODO
		return false; //TODO
	}

	/** checks whether the given sequence of characters is a palindrome */
	public static boolean isPalindrome(char[] sequence) {
		//TODO
		//TODO
		//TODO
		return false; //TODO
	}


	public static void isPalindromeDemo() {
		String input = JOptionPane.showInputDialog("Sequence:");

		while (input != null) {
			char[] sequence = input.toCharArray();

			System.out.println(input + ": " + isPalindrome(sequence));
			input = JOptionPane.showInputDialog("Sequence:");
		}
		System.out.println("bye-bye");
	}

	public static void demoContains() {
		double[] a0 = {};
		double[] a1 = { 3.0 };
		double[] a2 = { 3.0, 4.0, 8.0 };

		System.out.println("a0: " + Arrays.toString(a0));
		System.out.println("3.0 contained in a0 enthalten: " + contains(3.0, a0, a0.length - 1));
		System.out.println("4.0 contained in a0 enthalten: " + contains(4.0, a0, a0.length - 1));

		System.out.println("a1: " + Arrays.toString(a1));
		System.out.println("3.0 contained in a1 enthalten: " + contains(3.0, a1, a1.length - 1));
		System.out.println("4.0 contained in a1 enthalten: " + contains(4.0, a1, a1.length - 1));

		System.out.println("a2: " + Arrays.toString(a2));
		System.out.println("3.0 contained in a2 enthalten: " + contains(3.0, a2, a2.length - 1));
		System.out.println("4.0 contained in a2 enthalten: " + contains(4.0, a2, a2.length - 1));
		System.out.println("5.0 contained in a2 enthalten: " + contains(5.0, a2, a2.length - 1));
		System.out.println("8.0 contained in a2 enthalten: " + contains(8.0, a2, a2.length - 1));
	}


	public static void main(String[] args) {
		demoContains();
		System.out.println();
		isPalindromeDemo();
	}

}
