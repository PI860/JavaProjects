package lektion04;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Summe {

	/**
	 * akkumulierende Summe der Feldelemente berechnen 1. Version (fehlerhaft !! und
	 * ineffizient)
	 */
	public static void akkumuliere_1(double[] daten) {
		for (int i = 0; i < daten.length; i++) {
			double summe = 0;
			for (int k = 0; k <= i; k++) {
				summe += daten[k];
			}
			daten[i] = summe;
		}
	}

	/**
	 * akkumulierende Summe der Feldelemente berechnen 2. Version (korrekt, aber
	 * ineffizient) Korrigierte Fassung zur 1. Version
	 */
	public static void akkumuliere_2(double[] daten) {
		for (int i = daten.length - 1; i >= 0; i--) {
			double summe = 0;
			for (int k = 0; k <= i; k++) {
				summe += daten[k];
			}
			daten[i] = summe;
		}
	}

	/**
	 * akkumulierende Summe der Feldelemente berechnen 3. Version (korrekt und
	 * effizient)
	 */
	public static void akkumuliere_3(double[] daten) {
		for (int i = 1; i < daten.length; i++) {
			daten[i] = daten[i - 1] + daten[i];
		}
	}

	public static void main(String[] args) {
		// test1();
		test2();
	}

	private static void test1() {
		double[] f1 = { 1, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println("Ausgangswerte: " + Arrays.toString(f1));
		// akkumuliere_1(f1);
		// akkumuliere_2(f1);
		akkumuliere_3(f1);

		System.out.println("Ergebnis: " + Arrays.toString(f1));
	}

	public static final int MIN_N = 1000;

	private static void test2() {
		int maxN = Integer.parseInt(JOptionPane.showInputDialog("Max. Anzahl Elemente", 100000));

		for (int n = MIN_N; n <= maxN; n *= 10) {
			double[] daten = new double[n];
			System.out.println("Start: n = " + n);
			long tStart = System.nanoTime();
			// akkumuliere_1(daten);
			//akkumuliere_2(daten);
		    akkumuliere_3(daten);
			long tEnd = System.nanoTime();
			System.out.println("Ende: n = " + maxN + ", Laufzeit: " + (tEnd - tStart) / 1e6 + " msec.");
		}
		System.out.println("--- fertig ---");
	}

}
