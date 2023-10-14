package PROG1.abgaben.uebungsblatt3;

import PROG1.Terminal;


/**
 * @author Paulina Pyczot
 **/

public class ExerciseSet03 {
    public static void main(String[] args) {

        // A1 Aufrufen der Methode printName:
        printName(0);

        // A2 Aufrufen der Methode "Projektplaner":
        planProject();

        // A3 Aufrufen der Methode "Ausgabe der Tage im Monat":
        System.out.println("*** Days of Month ***");
        int readYear = Terminal.readInt("Provide a year");
        int readMonth = Terminal.readInt("Provide a month between 1 and 12");
        getDaysOfMonth(readMonth, readYear);

        // A4 Aufrufen der Methode "Ausgabe des Wochentags":
        System.out.println("*** Day of Week ***");
        int readDay = Terminal.readInt("Provide day between 1 and 31");
        getDayOfTheWeek(readDay, readMonth, readYear);

        // A5 in Bearbeitung:
        // printCalendar(readMonth, readYear);

    }

    // Aufgabe 1 (zum Warmwerden):
    public static void printName (int i) {
        while (i < 3) { // Anweisung wird 3 Mal wiederholt
            System.out.println("Paulina Pyczot");
            i++;
        }
        System.out.println();
    }

    // Aufgabe 2:
    public static void planProject () {
        System.out.println("*** Project planner ***");

        int workingHours = 8;
        double estProjHours = Terminal.readDouble("Type in the estimated time for the project (in hours)");
        int estProjDays = (int) Math.ceil(estProjHours / workingHours); //project hours rounded up to full days
        double salPerHour = Terminal.readDouble("Type in your salary per hour in €");
        int availEmpl = Terminal.readInt("Type in the amount of available employees");

        System.out.println();

        double totCost = estProjHours * salPerHour*availEmpl; // Gesamtkosten des Projekts
        int totDaysRounded = (int) Math.ceil(estProjHours / (availEmpl*workingHours)); // Math.ceil rundet auf die nächstgrößere integer Zahl auf
        // double totDays2 = (estProjHours + availEmpl*8-1) / (availEmpl * 8); // Test aus Tutorium

        System.out.println("Estimated total project days: " + estProjDays); // rounded up to full days
        System.out.println("Estimated total project costs: " + totCost + " €");
        // System.out.println("Estimated working days for the project per employee: " + totDays);
        System.out.println("Estimated working days for the project per employee: " + totDaysRounded); // rounded up to full days
        // System.out.println("Estimated working days for the project: " + totDays2); // Test aus Tutorium
        // System.out.println("Estimated working days for the project rounded tutorium: " + totDays2Rounded); // Test aus Tutorium

        System.out.println();
    }

    // Aufgabe 3:
    public static int getDaysOfMonth (int month, int year) {

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month ==12) { // Alle Monate mit 31 Tagen
            System.out.println("The month of " + month + " has 31 days.");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) { // Alle Monate mit 30 Tagen
            System.out.printf("The month of " + month + " has 30 days.");
        } else if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) { // Februar laut Schaltjahr
            System.out.printf(year + " is a leap year! The month of " + month + " has 29 days.");
        } else {
            System.out.println(year + " is not a leap year! The month of " + month + " has 28 days.");
        }
        /*
        else {
             System.out.printf("Monat " + month + " hat 28 Tage."); // Version ohne Schaltjahrberücksichtigung
        }
        */

        System.out.println();

        return 0;
    }

    // Aufgabe 4:
    public static int getDayOfTheWeek (int day, int month, int year) {
        if (month <= 2) { // Korrektur für Januar und Februar
            month += 12;
            year--;
        }

        int k = year % 100;
        int j = year / 100;

        int h = (day+((13*(month+1))/5)+k+(k/4)+(j/4)-2*j) % 7; // siehe https://de.wikipedia.org/wiki/Zellers_Kongruenz;

        /*
        Sonntag	Montag	Dienstag    Mittwoch	Donnerstag	Freitag	Samstag
        1	    2	    3	        4	        5	        6	    0           Laut Zellers Kongruenz
        7       1       2           3           4           5       6           Umkodiert auf europäische Wochentagszahl
         */
        if (h == 1) {
            h = 7;
        } else if (h == 0) {
            h = 6;
        } else {
            h = h -1;
        }

        System.out.print("Day of the week: " + h);

        return h;
    }

    /*
     * A5 Noch unfertig:
    public static void printCalendar (int month, int year) {

        System.out.println("*** Calendar ***");

        int dayOfWeek = getDayOfTheWeek(1, month, year);
        System.out.println(getDayOfTheWeek(1, month, year));

        System.out.println("Mo Tu We Th Fr Sa Su");

        // Initiiere Laufvariable row:
        int row = 0;

        //Solange die Zeilenanzahl echt kleiner der eingegebenen Zahl ist, soll Folgendes passieren:
        while (row < dayOfWeek) { // wenn der Erste des Monats nicht der Montag ist, müssen wir ein Leerzeichen ausgeben
            System.out.println(" ");
            row++;
        }


        int daysOfMonth = getDaysOfMonth(month,year);
        int j = 1;
        while (j < getDaysOfMonth(month,year)) {
            System.out.println("j");
            j++;
        }
    }

     */
}
