package udemyjavakurs.abschnitt5_inputoutputscanner;

import java.util.Scanner;

public class Einlesen_31 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //System.in = Inputgerät = Tastatur

        /*
        Aufgabe:

        Erstelle ein Objekt der Klasse Scanner und lese 2 Werte mithilfe dieser Klasse ein
        1. ist eine Ganzzahl, die Zahl soll dein Alter sein
        2. ist eine Zeichenkette mit deinem Namen

        Am Ende soll dein Alter und dein Name in der Konsole ausgegeben werden
         */
/*
        System.out.println("Gebe dein Alter ein: ");
        int alter = scan.nextInt();
        System.out.println("Gib deinen Namen ein: ");
        String name = scan.next();

        System.out.println("Dein Name: " + name + '\n' + "Dein Alter: " + alter);

 */
        Scanner scanner = new Scanner(System.in);
        String wort = scanner.nextLine();
        int zahl = scanner.nextInt();
        float zahl2 = scanner.nextFloat();
        System.out.println(wort);
        System.out.println(zahl);
        System.out.println(zahl2);
    }
}

