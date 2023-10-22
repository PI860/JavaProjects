package ALGO.pp.aufgabenblaetter.blatt01;

import java.util.Arrays;

public class Aufg15_Odd {

	/** 
	 * Checks if an odd value is contained in arr[0..endIndex]
	 * linear recursive version
	 */
	public static boolean containsOdd(int[] arr, int endIndex) {
		if (arr == null) {
			throw new IllegalArgumentException("Ungültige Eingabe");
		}

		// Läuft Array von 0 bis endIndex durch
		for (int j = 0; j <= endIndex; j++) {
			if (arr[j] % 2 != 0) {
				return true; // gibt true zurück, wenn ein ungerader Wert im Teilarray gefunden wurde
				// hier ist noch ein Fehler drin, den ich zeitlich nicht mehr fixen konnte, sry
			}
		}
		return false; //gibt false zurück, wenn kein ungerader Wert im Teilarray gefunden wurde
	}

	/** 
	 * checks if all values contained in array arr are odd numbers
	 */
	public static boolean allOdd(int[] arr) {
		return allOddHelpMethod(arr, 0);
	}

	private static boolean allOddHelpMethod(int[] arr, int index) {

		if (index == arr.length) {
			return true;
		}

		if (arr[index] % 2 == 0) {
			return false;
		}

		// Rekursiver Aufruf für das nächste Element im Array
		return allOddHelpMethod(arr, index + 1);
	}
	
	public static void main(String[] args) {
		System.out.println("containsOdd:");
		int[] arr1 = { 2, 4, 5, 8 };
		System.out.println("arr1: " + Arrays.toString(arr1));
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(i + ": " + containsOdd(arr1, i));
		}

		System.out.println();
		int[] arr2 = { 1, 3, 7, 5, 9 };
		System.out.println("arr2: " + Arrays.toString(arr2));
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(i + ": " + containsOdd(arr2, i));
		}

		System.out.println();

		System.out.println("allOdd(arr1):" + allOdd(arr1));
		System.out.println("allOdd(arr2):" + allOdd(arr2));

	}


}
