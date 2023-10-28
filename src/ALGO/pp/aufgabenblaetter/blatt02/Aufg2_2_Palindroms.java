package ALGO.pp.aufgabenblaetter.blatt02;

import java.util.Set;
import java.util.TreeSet;

public class Aufg2_2_Palindroms {

	/** Erzeugt die Menge aller Palindrome der L�nge length, die mit den durch chSet 
	 * gegebenen Zeichen gebildet werden k�nnen 
	 */
	public static TreeSet<String> palindroms(int length, char[] chSet) {
		//TODO
		//TODO
		//TODO
		//TODO
		//TODO
		return null; 	//TODO
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

		System.out.println("chSet2: Palindroms of length 3:");
		Set<String> palindroms = palindroms(4, chSet2);
		for (String p : palindroms) {
			System.out.println("'" + p + "'");
		}
		System.out.println();
	}
}
