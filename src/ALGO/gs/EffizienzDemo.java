package ALGO.gs;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JOptionPane;

public class EffizienzDemo {

	public static void main(String[] args) {
		int max_n = Integer.parseInt(JOptionPane.showInputDialog("Max array size:"));
		for (int n = 100; n <= max_n; n *= 10) {
			System.out.println("fill arrays, size = " + n);
			int[] arr1 = randomIntArray(n, 10 * n);
			int[] arr2 = randomIntArray(n, 10 * n);

			System.out.println("compute intersection");

			long startTime = System.nanoTime();
			Set<Integer> common = intersection_v1(arr1, arr2);
			long endTime = System.nanoTime();

			System.out.printf("n = %9d: Common elements %6d, runtime %8.4f sec.%n%n", n, common.size(),
					(endTime - startTime) * 1.0e-9);
		}
		System.out.println("--- finished ---");
	}

	public static int[] randomIntArray(int size, int bound) {
		int[] arr = new int[size];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(bound);
		}

		return arr;
	}

	public static Set<Integer> intersection_v1(int[] arr1, int[] arr2) {
		Set<Integer> resultSet = new HashSet<>();

		for (int x : arr1) {
			for (int y : arr2) {
				if (x == y) {
					resultSet.add(x);
				    break;
				}
			}
		}

		return resultSet;
	}

	
}
