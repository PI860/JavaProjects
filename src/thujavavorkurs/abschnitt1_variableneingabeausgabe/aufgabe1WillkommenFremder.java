package thujavavorkurs.abschnitt1_variableneingabeausgabe;

import java.util.Scanner;

public class aufgabe1WillkommenFremder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Gib deinen Namen ein: ");
		String name = scan.nextLine();
		System.out.println("Hello " + name + "!");
	}

}
