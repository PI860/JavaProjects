package udemyjavakurs.abschnitt5_inputoutputscanner;

import java.util.Scanner;
//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/package-summary.html
//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html#method-summary


public class UsereingabeScanner_28 {
    public static void main(String[] args) {
        /*
        Klasse = Komplexer Datentyp, in dem mehrere (nicht nur eine wie bei primitiven Datentypen) Informationen abgespeichert werden können
        Scanner ist eine Klasse
         */
        Scanner scan = new Scanner(System.in); //new-Operator erstellt Objekt aus einer Klasse
        System.out.println("Bitte eine Zahl eingeben: ");
        double zahl = scan.nextDouble(); //Punktoperator . gibt eingelesenen Wert zurück; scan.nextDouble erwartet, dass der User eine Zahl eingibt
        System.out.println("Ihre Zahl lautet: " + zahl);
        //Klasse "Scanner" erkennt bei der Eingabe der Zahl, welches Betriebssystem genutzt wird und in welchem Land, weshalb man die Zahl in der Eingabe mit einem Komma schreibt

        Scanner scan2 = new Scanner(System.in);
        System.out.println("Geben Sie Ihren Namen ein: ");
        String zeichenkette = scan2.next();
        System.out.println("Bitte geben Sie Ihr Alter ein: ");
        int alter = scan2.nextInt();

        System.out.println("Ihr Name: " + zeichenkette + " Ihr Alter: " + alter);




        /*Taschenrechner:


        System.out.println("Was möchten Sie tun?");
        String add = "Addieren";
        String sub = "Subtrahieren";
        String multi = "Multiplizieren";
        String divid = "Dividieren";

        System.out.println("a) " + add +"\n"+ "b) " + sub + "\n" + "c) " + multi + "\n" + "d) " + divid);

        String rechner = scan.next();

        while (true){
            if (rechner.equals("a")) {
                System.out.println("Geben Sie die erste Zahl ein: ");
                double zahl1 = scan.nextDouble();
                System.out.println("Geben Sie die erste Zahl ein: ");
                double zahl2 = scan.nextDouble();
                double ergebnisAdd = zahl1 + zahl2;
                System.out.println(zahl1 + " + " + zahl2 + " = " + ergebnisAdd);
            }
            if (rechner.equals("b")) {
                System.out.println("Geben Sie die erste Zahl ein: ");
                double zahl1 = scan.nextDouble();
                System.out.println("Geben Sie die erste Zahl ein: ");
                double zahl2 = scan.nextDouble();
                double ergebnisAdd = zahl1 - zahl2;
                System.out.println(zahl1 + " - " + zahl2 + " = " + ergebnisAdd);
            }
            if (rechner.equals("c")) {
                System.out.println("Geben Sie die erste Zahl ein: ");
                double zahl1 = scan.nextDouble();
                System.out.println("Geben Sie die erste Zahl ein: ");
                double zahl2 = scan.nextDouble();
                double ergebnisAdd = zahl1 * zahl2;
                System.out.println(zahl1 + " * " + zahl2 + " = " + ergebnisAdd);
            }
            if (rechner.equals("d")) {
                System.out.println("Geben Sie die erste Zahl ein: ");
                double zahl1 = scan.nextDouble();
                System.out.println("Geben Sie die erste Zahl ein: ");
                double zahl2 = scan.nextDouble();
                double ergebnisAdd = zahl1 / zahl2;
                System.out.println(zahl1 + " / " + zahl2 + " = " + ergebnisAdd);
            } else {
                System.out.println("Geben Sie a, b, c oder d ein: ");
            }
        }
        */

    }

}

