package ALGO.pp.aufgabenblaetter.blatt05.aufg5_6_sort;

import javax.swing.JOptionPane;

public class SortMeasurement {

	public interface DoubleArrayConsumer {
		void accept(double[] arr);
	}

	public static int LEN_MIN = 10;

	public static void main(String[] args) {
		String eingabe = JOptionPane.showInputDialog("Maximum length:", 100000);
		int laenge = Integer.parseInt(eingabe);

		measureRuntime("Heapsort", Sort::heapsort, laenge);
		measureRuntime("Quicksort", Sort::quicksort, laenge);
		measureRuntime("Mergesort", Sort::mergesort, laenge);
		measureRuntime("Insertionsort", Sort::insertionsort, laenge);
		measureRuntime("Selectionsort", Sort::selectionsort, laenge);
		measureRuntime("Bubblesort", Sort::bubblesort, laenge);

		System.out.println("--- done ---");
	}

	private static void measureRuntime(String name, DoubleArrayConsumer algorithm, int maxLength) {
		System.out.println(name + ":");
		for (int len = LEN_MIN; len <= maxLength; len = 10 * len) {
			double[] daten = Sort.generateTestData(len);
			long tStart = System.nanoTime();
			algorithm.accept(daten);
			long tEnd = System.nanoTime();
			double tmilli = (tEnd - tStart) / 1e6;
			System.out.printf("n = %9d %10.3f msec.%n", len, tmilli);
		}
		System.out.println();
	}
}
