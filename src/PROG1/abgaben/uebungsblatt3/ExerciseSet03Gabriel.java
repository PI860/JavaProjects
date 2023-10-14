package PROG1.abgaben.uebungsblatt3;

import PROG1.Terminal;

/**
 * @author Paulina Pyczot
 **/

public class ExerciseSet03Gabriel {

    static double sum = 0.0;
    static double rate = 0.0;
    static int workers = 0;
    static int hours = 0;
    static int days = 0;

    public static void main(String[] args) {
        // Comment / Aufgabe 2:
        planProject();
        System.out.println("Costs for the Project: " + sum + " Euro");

        // Comment / Aufgabe 3:
        // int month = Terminal.readInt("month");
        // int year = Terminal.readInt("year");
        // System.out.println(getDaysOfMonth(month, year));
    }

    public static void planProject () {

        // Stunden:
        hours = Terminal.readInt("Hours of work");

        // Arbeitstage:
        if (hours % 8 == 0) {
            days = hours / 8;
        } else {
            days = (hours / 8) + 1;
        }
        System.out.println("Days worked: " + days);

        // Lohn
        rate = Terminal.readInt("Amount of money per hour");

        // Arbeiter (Anzahl)
        workers = Terminal.readInt("Workers available");

        // Gesamtbetrag
        sum = workers * rate * hours;
    }
}
