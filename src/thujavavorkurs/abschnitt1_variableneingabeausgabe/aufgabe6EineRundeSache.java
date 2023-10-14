package thujavavorkurs.abschnitt1_variableneingabeausgabe;

import java.util.Scanner;

public class aufgabe6EineRundeSache {
	public static void main(String[] args) {
		double pi = 3.14159;

		Scanner scan = new Scanner(System.in);
		System.out.println("Gib den Radius in cm ein: ");
		double radius = scan.nextDouble();

		double UmfangU = 2 * pi * radius;
		double FlaecheF = 2 * pi * radius * radius;

		System.out.println("Umfang U beträgt: " + UmfangU + " cm");
		System.out.println("Fläche F beträgt: " + FlaecheF + " cm²");
	}
}
