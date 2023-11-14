package ALGO.pp.aufgabenblaetter.blatt02;

import java.util.Set;
import java.util.TreeSet;

public class Aufg2_2_Palindroms {

	/** Erzeugt die Menge aller Palindrome der L�nge length, die mit den durch chSet 
	 * gegebenen Zeichen gebildet werden k�nnen 
	 */
	public static TreeSet<String> palindroms(int length, char[] chSet) {
		TreeSet<String> result = new TreeSet<>();
		generatePalindromes(length, chSet, "", result);
		return result;
	}

	private static void generatePalindromes(int length, char[] chSet, String current, TreeSet<String> result) {
		if (current.length() == length) {
			if (isPalindrome(current)) {
				result.add(current);
			}
			return;
		}

		for (char ch : chSet) {
			generatePalindromes(length, chSet, current + ch, result);
		}
	}

	private static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		demo1();
		demo2();
	}

	private static void demo1() {
		char[] chSet1 = { 'a', 'b' };

		for (int length = 0; length <= 6; length++) {
			System.out.println("chSet1, Palindroms of length " + length + ":");
			Set<String> palindroms = palindroms(length, chSet1);
			for (String p : palindroms) {
				System.out.println("'" + p + "'");
			}
			System.out.println();
		}
	}

	private static void demo2() {
		char[] chSet2 = { '1', '2', '3', '4' };

		System.out.println("chSet2: Palindroms of length 4:");
		Set<String> palindroms = palindroms(4, chSet2);
		for (String p : palindroms) {
			System.out.println("'" + p + "'");
		}
		System.out.println();
	}
}
