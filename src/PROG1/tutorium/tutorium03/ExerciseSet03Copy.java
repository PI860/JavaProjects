package PROG1.tutorium.tutorium03;

import PROG1.Terminal;

/**
 * @author Paulina Pyczot
 **/

public class ExerciseSet03Copy {
    public static void main(String[] args) {
        /**
         * 1. Aufgabe:
         * Lösungen zur Berücksichtigung der angefangenen Tage:
         * - Math.ceil()
         * - Modulo
         * - "Offset dazuaddieren"
         */
        int numDay = Terminal.readInt("Provide day");
        int numMonth = Terminal.readInt("Provide month");
        int numYear = Terminal.readInt("Provide year");

        getDaysOfTheMonth(numMonth, numYear);
        getDayOfTheWeek(numDay, numMonth, numYear);

    }

    // 3. Aufgabe:
    public static int getDaysOfTheMonth (int month, int year) {
        // 1. Lösung mit if-Abfrage:
        if (month % 2 == 1) {
            // 31 Tage
        } else {
            // 30 Tage
        }

        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) { // && hat höhere Priorität als ||

            }
        } else {
            if (month % 2 == 0) {
                // 31 Tage
            } else {
                // 30 Tage
            }
        }
        return 0;
    }

    /**
     * 4. Aufgabe:
     * s. Wikipedia-Artikel:
     * https://en.wikipedia.org/wiki/Zeller%27s_congruence
     */
    public static int getDayOfTheWeek (int day, int month, int year) {
        if (month <= 2) { // Für Januar und Februar muss eine Korrektur vorgenommen werden
            month += 12;
            year--;
        }

        int k = year % 100;
        int j = year / 100;

        int h = (day+((13*(month+1))/5)+k+(k/4)+(j/4)-2*j) % 7;

        System.out.println(h);

        /*
         * Beispeil:
         * 20.10.2022
         * q = 20
         * m = 10
         * k = 22
         * j = 20
         * h = (20 + ... Formel einsetzen aus Wikipedia-Artikel
         * h = 40 % 7 = 5
         * d = (5 + 5) % 7 + 1 = 4 (Donnerstag)
         */
        return 0;
    }

    // 5. Aufgabe:
    public static void  printCalendar (int month, int year) {
        int dayOfWeek = getDayOfTheWeek(1,month, year);
        System.out.println("Mo Tu We Th Fr Sa Su");
        // Wie viele Leerzeichen müssen ausgegeben werden?
        int i = 0;
        while (i < dayOfWeek) { // wenn der erste des Monats nicht der Montag ist, müssen wir Leerzeichen ausgeben
            // Leerzeichen ausgeben:
            // i++;
        }
        int daysOfMonth = getDaysOfTheMonth(month,year); // Anzahl der Tage des Monats bestimmen

        /**
         * - Jetzt geben wir die Zahlen von 1 bis daysOfMonth aus
         * - dayOfWeek "läuft mit"
         * - Wenn wir am Sonntag sind (dayOfWeek == 7) -> Zeilenumbruch + dayOfWeek = 1
         */
    }

}
