package PROG1.tutorium.tutorium06;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Paulina Pyczot
 **/

public class ExerciseSet06Copy {

    public static Scanner scanner = new Scanner(System.in); // so kann man den Scanner in jeder Methode nutzen
    public static final String DEFAULT_PROMPT = "Bitte Wert eingeben: "; // final = diese Methode ist nicht mehr änderbar in anderen Methoden!; Variable alles groß geschrieben = Konstante!

    public static void main(String[] args) {
        // Aufgabe 1:
        Math.random(); // bringt für die Aufgabe wenig, um min und max zu bestimmen

        Random random = new Random();
        int min = 10;
        int max = 20;
        int number = random.nextInt(max - min + 1) + min; // liefert Zufallszahlen zwischen 10 und 20
        System.out.println(number);

        // Aufgabe 2: siehe Vorkurs Ratespiel
        // mit Scanner arbeiten statt Terminal
        // Scanner entweder in der main am Ende schließen (ist aber auch nicht schlimm, wenn er gar nicht geschlossen wird, ist nur schöner, wenn's doch passiert)
    }

    // Aufgabe 3:
    public static String[] names = {"Angeregg", "Hanslettalm", "Wiedersberger_Horn"};
    public static int[] heightData = {950, 1616, 2127};
    public static double[] distanceFromStart = {0, 3.5, 5};

    public static int upwardSpeed = 300;
    public static int downwardSpeed = 500;
    public static int horizontalSpeed = 4;
    // youtube Bergwandern: Wer berechnet die Zeit auf Hinweisschildern?| Gut zu wissen | BR

    /**
     * Place            A
     * Height           0 m
     * DistfromStart    0 km
     *
     * Place            B
     * Height           600 m
     * DistfromStart    1 km
     *
     * Upward Speed     200 m/h
     * Downward Speed   400 m/h
     * Speed horizontal 4 km/h
     *
     * Formel aus Übungsblatt:
     * Wenn der Höhenunterschied positiv ist: nimm Upward Speed
     * Wenn der Höhenunterschied negativ ist: nimm Downward Speed
     *
     * horizontalTime = 1 km / 4 km/h = 0,25h
     * verticalTime =   600 m / 200 m/h = 3,00 h
     * time =           (0,25h / 2) + 3,00 h = 3,125 h
     * 0,125 h in s =   0,125h * 60 = 7,5 Minuten
     */
}
