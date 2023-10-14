package PROG1.prog1demos;

public class ScannerDemo {
	public static void main(String[] args) {
		int[] numbers = new int[3];
		// create new scanner for standard input stream
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		for (int i = 0; i < numbers.length; i++) {
			// read next number
			System.out.print("Provide next number: ");
			numbers[i] = scanner.nextInt();
		}
		for (int number : numbers)
			System.out.print(number + " ");
		scanner.close();
	}
}
