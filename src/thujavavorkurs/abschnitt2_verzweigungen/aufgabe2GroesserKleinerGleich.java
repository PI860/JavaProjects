package thujavavorkurs.abschnitt2_verzweigungen;

import java.util.Scanner;

public class aufgabe2GroesserKleinerGleich {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("Geben Sie eine Zahl ein: ");
		float zahl1 = scan.nextFloat();
		System.out.println("Geben Sie eine weitere Zahl ein: ");
		float zahl2 = scan.nextFloat();

		if (zahl1 > zahl2) {
			System.out.println("Zahl 1 (" + zahl1 + ") ist die größte Zahl.");
			System.out.println("Zahl 2 (" + zahl2 + ") ist die kleinste Zahl.");
		} else if (zahl1 == zahl2) { //nur if hätte hier nicht gereicht (die Bedingung "else" wäre dann nur zum 2. if eine Bedingung und würde immer ausgeführt werden, wenn die erste if greift!
			System.out.println("Zahl 1 und Zahl 2 sind gleich (" + zahl1 + ").");
		} else {
			System.out.println("Zahl 2 (" + zahl2 + ") ist die größte Zahl.");
			System.out.println("Zahl 1 (" + zahl1 + ") ist die kleinste Zahl.");
		}


	}

}
