package ALGO.pp.aufgabenblaetter.blatt08;

import java.util.Random;

/**
 * Runtime measurements for some search tree operations
 */
public class SearchTreeMeasurement {
	public static final int MIN_N = 100;
	public static final int MAX_N = 1000000;

	public static void main(String[] args) {
		System.out.println("Runtime equals():");

		for (int n = MIN_N; n <= MAX_N; n *= 10) {
			runtimeEquals(n);
		}

		System.out.println();
		System.out.println("- done -");

	}


	/**
	 * measure runtime of operation t1.equals(t2) for two trees build from random data
	 * of size n
	 */
	public static void runtimeEquals(int n) {
		SearchTree t1 = new SearchTree();
		SearchTree t2 = new SearchTree();

		// compute n random values
		Random rand = new Random();
		int[] werte = new int[n];
		for (int i = 0; i < werte.length; i++) {
			werte[i] = rand.nextInt();
		}

		// insert values into the first tree t1
		for (int i = 0; i < werte.length; i++) {
			int v = werte[i];
			t1.insert(v);
		}

		// insert same values in reverse order into second tree t2.
		// so t2 contains the same values as t1, but has another
		// tree structure
		for (int i = werte.length - 1; i >= 0; i--) {
			int v = werte[i];
			t2.insert(v);
		}

		System.out.printf("n=%8d : ", n);
		System.out.printf("height(t1)=%3d, ", t1.height());
		System.out.printf("height(t2)=%3d, ", t2.height());

		long tStart = System.nanoTime();
		boolean result1 = t1.equals(t2);
		long tEnd = System.nanoTime();
		double runtimeMS = (tEnd - tStart) / 1.0e6;

		System.out.printf("result: %4b, runtime %8.2f ms %n", result1, runtimeMS);

	}

}
