package thujavavorkurs.abschnitt2_verzweigungen;

import java.util.Scanner;

public class aufgabe3BodyMassIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Geben Sie Ihr Gewicht in kg ein: ");
		float gewicht = scan.nextFloat();
		System.out.println("Geben Sie Ihre Größe in m ein: ");
		float groesse = scan.nextFloat();
		
		double bmi = gewicht/(groesse*groesse);
		
		System.out.println("Ihr BMI beträgt: " + bmi);
		
		if (bmi<20) {
			System.out.println("-> Sie sind untergewichtig.");
		}else if (20<=bmi && bmi<25) {
			System.out.println("-> Sie sind normalgewichtig.");
		}else if (25<=bmi && bmi<30) {
			System.out.println("-> Sie sind übergewichtig.");			
		}else if (30<=bmi && bmi<40) {
			System.out.println("-> Sie sind stark übergewichtig.");			
		}else if (bmi>=40) {
			System.out.println("-> Sie sind extrem übergewichtig.");
		}
				
	}

}
