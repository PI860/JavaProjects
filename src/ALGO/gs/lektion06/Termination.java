package lektion06;

import java.util.Arrays;

public class Termination {
	
	public static void hasseCollatz(int n) {
		while (n > 1 ) {
			System.out.print(n + " ");
			 
			if (n%2 == 0) {
				n = n/2;
			} else {
				n = 3*n + 1;
			}
		}
		System.out.println(n);
	}
	

	/**
	 * Bubblesort
	 */
	public static void bubblesort(double[] arr) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i <  arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					// swap neighboring values arr[i] and arr[i+1] that
					// are in the wrong order.
					double temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
				}
			}
		} while (swapped);
	}


	// Precondition: n > 0 and m > 0
	public static int gcdEuclid(int n, int m) {
	   while (n != m) {
	      if (n > m)
	         n = n - m;
	      else
	         m = m - n;
	   }
	   return n;
	}
		
	
	public static final int MAX = 20;
	
	public static void main(String[] args) {
		System.out.println("Hasse-Collatz:");
		for (int i = 2; i <= 20; i++) {
			hasseCollatz(i);
		}
		
		System.out.println();
		
		System.out.println("Bubblesort:");
		double[] values = {4.0, 9.0, 3.0, 8.0, 1.0, 1.0, 6.0 };
		System.out.println(Arrays.toString(values));
		bubblesort(values);
		System.out.println(Arrays.toString(values));
		
		System.out.println();
		
		System.out.println("gcdEuclid:");
		
		for (int n1 = 3; n1 <= MAX; n1++) {
			for (int n2 = 3; n2 <= MAX; n2++) {
				System.out.printf("gcd(%d,%d) = %d %n", n1, n2, gcdEuclid(n1,n2));
			}
		
		}

	
	}

}
