package PROG1.prog1demos.demos.rl.prog1.demos.exceptions;

import java.util.Scanner;

public class RectangleTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Rectangle r = null;
		while (r == null) {
			try {
				int l, b;
				Thread.sleep(100); // hack...
				System.out.print("\nSpecify left and bottom: ");
				l = scanner.nextInt();
				b = scanner.nextInt();
				r = new Rectangle(l, b, 10, 10);
			} catch (Exception e) {
				e.printStackTrace(); // for debugging only!
				scanner.nextLine();
			}
		}
		System.out.println("Created rectangle: " + r);
		scanner.close();
	}
}
