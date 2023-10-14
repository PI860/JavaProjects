package udemyjavakurs.abschnitt5_inputoutputscanner;

import java.util.Scanner;

public class Einlesen_33_34 {
    public static void main(String[] args) {

        /*
        Was kann eingelesen werden?
        nextInt(): int
        nextFloat(): float
        nextDouble(): double
        nextLong(): long
        nextShort(): short
        next(): einzelnes Wort
        nextLine(): string
        nextBoolean(): boolean
         */

        Scanner scanner = new Scanner(System.in);
        // int zahl = scanner.nextInt();

        //System.out.println(zahl);

        // scanner.close();

        //Beispiel:
        System.out.println("Name?");
        String name = scanner.nextLine();

        System.out.println("Geschlecht?");
        char gender = scanner.next().charAt(0); //charAt(irgendeineZahl) = Index für die Stelle, die ausgelesen werden soll beim char

        System.out.println("Alter?");
        int age = scanner.nextInt();

        System.out.println("Telefonnummer?");
        long mobileNumber = scanner.nextLong(); //besser: String nehmen, damit hier die führende Null nicht weggelassen wird

        scanner.close(); // geht auch ohne scanner.close()

        System.out.println("Name: " + name);
        System.out.println("Geschlecht: " + gender);
        System.out.println("Alter: " + age);
        System.out.println("Mobil: " + mobileNumber);

        /*
        Eingabe mit double mobileNumber = scanner.nextDouble();
        Paula
        weiblich
        26
        01573 8404415

        Ausgabe:
        Name: Paula
        Geschlecht: w
        Alter: 26
        Mobil: 1573.0
         */


    }
}
