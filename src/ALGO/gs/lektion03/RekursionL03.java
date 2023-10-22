package lektion03;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class RekursionL03 {

	public static void main(String[] args) {
		testSum_A();
		testSum_B();
		demoCatalan();
	
	}
	
	
	public static double sum(double[] arr) {
		return sum_v1(arr);
//		return sum_v2(arr);
	}
	
	/** Summe aller Elemente des Arrays berechnen, 1. Version (lineare Rekursion) */
	public static double sum_v1(double[] arr) {
		return sum_v1(arr, arr.length-1);
	}
	
	/** Berechnet Summ der Werte des Teilarrays arr[0..lastIndex] */
	private static double sum_v1(double[] arr, int lastIndex) {
		if (lastIndex == 0) {
			return arr[0];
		} else {
			return arr[lastIndex] + sum_v1(arr, lastIndex-1);
		}
	}
	
	
	/** Summe aller Elemente des Arrays berechnen, 2. Version (Baumrekursion) */
	public static double sum_v2(double[] arr) {
		return sum_v2(arr, 0, arr.length-1);
	}
	
	private static double sum_v2(double[] arr, int firstIndex, int lastIndex) {
		if (firstIndex == lastIndex) {
			// zu summierender Bereich besteht nur aus einem Element
			return arr[firstIndex];
		} else {
			// zu summierenden Bereich in zwei Hälften teilen
			int mid = (firstIndex + lastIndex) / 2;
			return sum_v2(arr, firstIndex, mid) + sum_v2(arr, mid+1, lastIndex);
			
		}
	}

	
	public static void testSum_A() {
		double[] arrA = {1,2,3,4,5,6,7,8,9,10};
		System.out.println("sum_v1(arrA): " + sum_v1(arrA));
		System.out.println("sum_v2(arrA): " + sum_v2(arrA));
		
	}

	public static void testSum_B() {
		double[] arrB = new double[100000000];
//		System.out.println("sum_v1(arrB): " + sum_v1(arrB));
		System.out.println("sum_v2(arrB): " + sum_v2(arrB));
	}

	
	public static int catalan(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += catalan(i) * catalan(n-1-i);
			}
			return sum;
		}
	}
	
	public static void demoCatalan() {
		System.out.println("Catalan-Zahlen:");
		for (int n = 0; n <= 15; n++) {
			System.out.println(n + ": " + catalan(n));
		}
	}

	

}
