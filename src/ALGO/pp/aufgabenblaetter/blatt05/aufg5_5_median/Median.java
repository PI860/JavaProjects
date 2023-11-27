package ALGO.pp.aufgabenblaetter.blatt05.aufg5_5_median;

import java.util.Arrays;
import java.util.HashMap;

public class Median {

	/**
	 * Calculate the median of the values in array a
	 * 
	 * @param a data
	 * @return median of the data
	 */
	public static double median(double[] a) {
		// TODO
		// TODO
		// TODO
		return 42; // TODO
	}

	public static void main(String[] args) {
		measureRuntimeMedian();
	}

	public static void measureRuntimeMedian() {
		for (int n = 100; n <= 10000000; n *= 10) {

			// generate array with random data
			double[] an = new double[n + 1];
			for (int i = 0; i < an.length; i++) {
				an[i] = 1000 * Math.random();
			}

			// measure runtime
			System.out.println("n = " + an.length + ":");
			long start1 = System.nanoTime();
			double median1 = median(an);
			long ende1 = System.nanoTime();
			System.out.print("median: " + median1);
			System.out.printf(" time: %8.2f ms %n", (ende1 - start1) / 1e6);

			System.out.println();

		}
	}

}
