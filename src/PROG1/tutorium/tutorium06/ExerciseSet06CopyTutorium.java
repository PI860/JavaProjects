package PROG1.tutorium.tutorium06;

import java.util.Random;
import java.util.Scanner;

public class ExerciseSet06CopyTutorium {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String DEFAULT_PROMPT = "Bitte Wert eingeben: ";

    public static void main(String[] args) {
        // Zufallszahlen im Bereich zwischen min und max (inklusive):
        Random random = new Random();
        int min = 10;
        int max = 20;
        int number = random.nextInt(max - min + 1) + min;

        // Zahlen mit dem Scanner einlesen (mit prompt):
        System.out.print("Bitte eine Zahl eingeben: ");
        int numberFromUser = scanner.nextInt();
        // oder mit Methode:
        numberFromUser = readIntNumber("Bitte eine Zahl eingeben: ");
    }

    public static int readIntNumber(final String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // Aufgabe 4: https://www.youtube.com/watch?v=-NRWPOH3VMQ
    public static String[] names = {"Angeregg", "Hanslettalm", "Wiedersberger_Horn"};
    public static int[] heightData = {950, 1616, 2127};
    public static double[] distanceFromStart = {0, 3.5, 5};
    public static int upwardSpeed = 300;
    public static int downwardSpeed = 500;
    public static int horizontalSpeed = 4;

    /**
     *
     * Place            A
     * Height           0 m
     * Dist from Start  0 km
     *
     * Place            B
     * Height           600 m
     * Dist from Start  1 km
     *
     * Upward Speed     200 m/h
     * Downward Speed   400 m/h
     * Speed horizontal 4 km/h
     *
     * hTime = 1 km / 4km/h = 0,25 h
     * vTime = 600 m / 200/h = 3,00 h
     *  time = 0,25/2 + 3 = 3,125 h
     *  0,125 * 60 = 7 Minuten
     */
     /*
        !!!Default Route!!!
        Number of places (-1 for default route): -1
        Upward speed      [m/h] : 300
        Downward speed    [m/h] : 500
        Horizontal speed  [km/h]: 4

        Angeregg 0:0
        Hanslettalm 2:39
        Wiedersberger_Horn 4:32
        Hanslettalm 5:44
        Angeregg 7:29

     */

}

