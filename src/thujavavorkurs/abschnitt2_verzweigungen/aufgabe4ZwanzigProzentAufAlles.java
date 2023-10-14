package thujavavorkurs.abschnitt2_verzweigungen;

import java.util.Scanner;

public class aufgabe4ZwanzigProzentAufAlles {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Geben Sie den Preis/kg des Produkts ein: ");
		double kiloPreis = scan.nextFloat();
		System.out.println("Geben Sie die Bestellmenge in kg des Produkts ein: ");
		double bestellMenge = scan.nextFloat();
		
		double preis = Math.round(kiloPreis*100)/100.0 * Math.round(bestellMenge*100)/100.0;
		double rabatt10 = preis * 0.1; //ab 10kg Bestellung 10% Rabatt
		double rabatt20 = preis * 0.2; //ab 50kg Bestellung 20% Rabatt
		
		double preisRabatt10 = preis - rabatt10;
		double preisRabatt20 = preis - rabatt20;
		
		System.out.println("Ihr Preis beträgt: " + preis + " €");	
		
		if (bestellMenge>=10 && bestellMenge<50) {
			System.out.println("10% Rabatt ab 10kg Bestellung! Ihr Preis beträgt: " + preisRabatt10 + " €");
			System.out.println("Sie sparen: " + rabatt10 + " €");
		}else if (bestellMenge >= 50) {
			System.out.println("20% Rabatt ab 50kg Bestellung! Ihr Preis beträgt: " + preisRabatt20 + " €");
			System.out.println("Sie sparen: " + rabatt20 + " €");
			
		}
	}
}
