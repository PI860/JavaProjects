package PROG1.tutorium.tutorium04;

import PROG1.Terminal;

/**
 * @author Paulina Pyczot
 **/

public class ExerciseSet04Copy {
    public static void main(String[] args) {
        //test();
        //test2();
        convertHexToDec0();

        int number = Integer.MIN_VALUE;
        Integer number2 = 10;
        // Für erweiterbare Listen werden nicht Arrays benutzt, sondern es werden Objekte erstellt

        int num = Terminal.readInt("Provide number");
        if (isPrim(num)) {
            System.out.println(num + " ist eine Primzahl.");
        }

        //Zahlen umdrehen von Prim nach Mirp: 123-> 321
        /*
        int numberReverted = 0;
        while (num > 0) {
            numberReverted = numberReverted * 10 *
        }
        */
    }

    public static void test() {
        byte num = 3;
        int i = 0;
        while (i < 10) {
            System.out.print(num + " ");
            num += 20;
            i++;
        }
        System.out.println();

        // Ausgabe bis +127, dann bei -128 weiter
        /**
         * 3 23 43 63 83 103 123 ???
         *
         * 123 ins Binöre umrechnen:
         * 123 /  2 = 61    R1
         * 61 / 2 = 30      R1
         * 30 / 2 = 15      R0
         * 15/ 2 = 7        R1
         * 7 / 2 = 3        R1
         * 3 / 2 = 1        R1
         * 1 / 2 = 0        R1
         * 123 = 1111011
         *
         * 20 ins Binäre:
         * 20 / 2 = 10      R0
         * 10 / 2 = 5       R0
         * 5 / 2 =  2       R1
         * 2 / 2 = 1        R0
         * 1 / 2 = 0        R1
         * 20 = 10100
         *
         * 1111011
         * 0010100 addieren
         * -------
         * 10001111 = 1+2+4+8 = -15
         *
         * 3 23 ... 123 -113 (-128+15 = -113)
         */
    }

    public static void test2() {
        // zu Aufgabe 4:
        System.out.println(Terminal.readChar()); // Eingabe: 146; Ausgabe: 1
        System.out.println(Terminal.readChar()); // Ausgabe: 4
        System.out.println(Terminal.readChar()); // Ausgabe: 6
    }

    // Aufgabe 4: switch case, if-Anweisungen nicht benötigt, man kann einfach mit char rechnen!
    // War mal eine Klausuraufgabe mit char
    // Code 13 bei Eclipse muss ausgeblendet werden, in IntelliJ passiert das schon automatisch
    // Für Hexwerte kann man Hornerschema nehmen, die Variante mit Rechnen mit chars geht hier nicht!

    public static void convertHexToDec0() {
        System.out.print("Please provide a hexadecimal number (e.g. 1f): ");
        int result = 0;
        char ch = Terminal.readChar();
        while (ch != '\n') {
            int code = ch;
            if (ch >= '0' && code <= '9') {
                int decValue = ch - '0';
                // Beispiel für oben: ch =  '2' -> 50
                //                          '0' -> 48
                System.out.println(decValue);
            } else if (ch >= 'a' && ch <= 'f') {
                int decValue = ch -'a' + 10;
            }
            System.out.println(ch + " -> " + code);
            ch = Terminal.readChar();

        }
        System.out.println("Corresponding decimal number: " + result);
    }

    /**
     * Hornerschema: https://de.wikipedia.org/wiki/Horner-Schema#Umwandlung_ins_Dezimalsystem
     * Für Hexumrechnungen
     * 1231 (hex) -> Dezimalsystem
     * 0*16 + 1 = 1
     * 1*16 + 2 = 18 (Übernehme Erg. in nächste Zeile)
     * 18*16 + 3 = 3 291
     * 291*16 +1 = 4657
     * Für Hex am besten separate Methode!
     */

    public static boolean isPrim(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) { // Wenn die Zahl durch irgendein i kleiner der Zahl selbst teilbar ist, dann ist die Zahl ja keine Primzahl
                return false;
            } else {
                return true;
            }
        }
        return true; // return Methodentyp boolean == true!
    }

}
