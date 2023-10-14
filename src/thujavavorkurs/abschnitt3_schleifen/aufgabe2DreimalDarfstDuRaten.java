package thujavavorkurs.abschnitt3_schleifen;

import java.util.Random;
import java.util.Scanner;

public class aufgabe2DreimalDarfstDuRaten {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Random rand = new Random();
        int randomNumber = rand.nextInt(101);
        System.out.println(randomNumber);

        int anzahlDurchgänge = 1;

        System.out.println("Der Computer hat eine Zufallszahl zwischen 0 und 100 bestimmt. Raten Sie die Zahl, Sie haben 3 Versuche: ");
        int eingabeUser = scan.nextInt();

        while (anzahlDurchgänge < 3) {
            if (eingabeUser > randomNumber) {
                System.out.println("Leider daneben. Die gesuchte Zahl ist kleiner! Raten Sie nochmal: ");
                eingabeUser = scan.nextInt();
            } else if (eingabeUser < randomNumber) {
                System.out.println("Leider daneben. Die gesuchte Zahl ist größer! Raten Sie nochmal: ");
                eingabeUser = scan.nextInt();
            } else {
                System.out.println("Sie haben richtig geraten, Glückwunsch!");
                break;
            }
            anzahlDurchgänge++;
        }
        System.out.println("Das Spiel ist beendet.");

    }
}
