package PROG1.abgaben.uebungsblatt4;

import PROG1.Terminal;
import java.lang.Math;

/**
 * @author Paulina Pyczot
 **/

public class ExerciseSet04 {
    public static void main(String[] args) {
        // Aufgabe 1 (zum Warmwerden):
        startByteOverflowDemo();
        // Aufgabe 2:
        demonstrateArithmeticOperations();
        // Aufgabe 3:
        convertToBinary();
        //Aufgabe 4:
        convertHexToDec0();
        /* Test Rechnen mit char:
         * char s = 'a'; // a = 97 (Dezimal)
         * int decValue = s -'b' + 10; // b = 98 (Dezimal), erwartete Ausgabe: 97 - 98 + 10 = 9
         * System.out.println(decValue);
         */


    }

    // Aufgabe 1 (zum Warmwerden):
    public static void startByteOverflowDemo() {
        byte num = 0; // Wertebereich des Datentyps byte: -128 bis 127
        int i = 0; // Laufvariable i
        while (i < 10) { // Solange i kleiner 10 bleibt, folgende Anweisung durchführen:
            System.out.print(num + " ");
            num += 30;
            i++;
        }

        /*
         * Anweisung besagt:
         * Starte bei num = 0 und zähle bei jeder Erhöhung von Laufvariable i 30 dazu, also so:
         * 0 30 60 90 120 nächste wäre dann 150, das liegt aber außerhalb vom Wertebereich des byte!
         *
         * Lösung für das Problem: Darstellung als Binärzahl
         * 120 als Binärzahl:
         * 120 : 2 = 60 R0
         *  60 : 2 = 30 R0
         *  30 : 2 = 15 R0
         *  15 : 2 =  7 R1
         *   7 : 2 =  3 R1
         *   3 : 2 =  1 R1
         *   1 : 2 =  0 R1
         * -> 120 =  1111000, Achtung: da 120 ja eine positive Zahl ist, sollte diese im Zweierkomplement dargestellt werden, also:
         * -> 120 = 01111000 (0 für positives Vorzeichen)
         *
         * 30 als Binärzahl (siehe oben ab 30 : 2):
         * -> 30 = 011110 (0 für positives Vorzeichen)
         *
         *  01111000
         * +  011110
         *  10010110 = 22
         * i = 5: -128 + 22 = -106 (die berechnete Zahl aus 120+30 in Binär zum Anfang des negativen Wertebereichs vom byte in Dezimalschreibweise dazuaddieren)
         * i = 6: -106 + 30 = - 76 (ab jetzt wieder ganz normal die 30 im Dezimalsystem dazuaddieren)
         * i = 7: - 76 + 30 = - 46
         * i = 8: - 46 + 30 = - 16
         * i = 9: - 16 + 30 =   14
         *
         * Ausgabe ist also:
         * 0 30 60 90 120 -106 -76 -46 -16 14
         */
        System.out.println();
        System.out.println();
    }

    // Aufgabe 2:
    public static void demonstrateArithmeticOperations() {
        System.out.println("*** Arithmethic Operations ***");
        int firstOperand = Terminal.readInt("Please provide a number for the first operand");
        int secondOperand = Terminal.readInt("Please provide a number for the second operand");

        int sum = firstOperand + secondOperand;
        int diff = firstOperand - secondOperand;
        int multi = firstOperand * secondOperand;
        int div = firstOperand / secondOperand;
        int modSymm = firstOperand % secondOperand;

        System.out.println(firstOperand + " + " + secondOperand + " = " + sum);
        System.out.println(firstOperand + " - " + secondOperand + " = " + diff);
        System.out.println(firstOperand + " * " + secondOperand + " = " + multi);
        System.out.println(firstOperand + " / " + secondOperand + " = " + div);
        System.out.println(firstOperand + " % " + secondOperand + " = " + modSymm);
        System.out.println("Java benutzt die symmetrische Definition des Modulo, welche lautet: a mod m := a - m * (sign a * sign m * ⌊ (|a|/|m|) ⌋)");

        int modMath = ((firstOperand % secondOperand) + secondOperand) % secondOperand;

        System.out.println("Mathematische Definition des Modulo: " + firstOperand + " % " + secondOperand + " = " + modMath);
        System.out.println();
        /*
         * Kommentar zum Modulo:
         * Mathematische Definition:    a % m := a - m * ⌊ (a/m) ⌋
         * Symmetrische Definition:     a % m := a - m * (sign a * sign m * ⌊ (|a|/|m|) ⌋)
         *
         * Dabei sind die Klammern ⌊ ⌋ als Gaußklammern definiert. Es wird die größte ganze Zahl genommen, die nicht
         * größer als die Zahl in der Gaußklammer ist
         * (z.B. bei ⌊ (-8/6) ⌋ = ⌊ (-1,3333...) ⌋ = -2, da das die kleinere ganze Zahl als -1 ist).
         *
         * Mit sign a und sign m sind die Vorzeichen der beiden Zahlen a und m gemeint.
         *
         * Bsp. Berechnung: -8 % 6
         *
         * Math.:
         * -8 % 6
         * = -8 - 6 * ⌊ (-1,3333...) ⌋
         * = -8 - 6 * (-2)
         * = -8 + 12
         * = 4
         * -> das gibt bspw. Excel oder Google aus!
         *
         * Symm.:
         * -8 % 6
         * = -8 - 6 * ((-)1 * (+)1 * ⌊ ((+)1,3333...) ⌋ )
         * = -8 - 6 * (-1)
         * = -8 + 6
         * = -2
         * -> das gibt Java aus!
         * (Beweis: -8 / 6 = -1 * 6 R -2 (die 6 passt -1mal in die -8 rein und es bleibt ein Rest von -2 übrig))
         */
    }

    // Aufgabe 3 (für ganze Zahlen, also ebenfalls für negative Zahlen getestet):
    public static int convertToBinary() {
        System.out.println("*** Binary Converter ***");
        int decimalNumber = Terminal.readInt("Please provide a number");
        System.out.println("Binary representation (from right to left!):");
        int newDecimalNumber = decimalNumber; // neu definiert, damit die Möglichkeit, mit decimalNumber weiterzuarbeiten, bestehen bleibt

        int i = 0; // Laufvariable i

        // Part für natürliche Zahlen:
        // bei Zahlen größer gleich Null muss am Ende der Ausgabe eine 0 für Plus ausgegeben werden:
        if (decimalNumber >= 0) {
            for (i = 0; newDecimalNumber >= 1; i++) { // solange newDecimalNumber größer oder gleich 1 ist, Anweisungsblock durchführen
                int newDiv = newDecimalNumber / 2; // bspw. 6 / 2 = 3
                int newMod = newDecimalNumber % 2; // bspw. 6 % 2 = 0
                newDecimalNumber = newDiv; // bspw. wird 6 zu 3, dann zu 1
                // System.out.println(newDecimalNumber + "  R" + newMod); // Kontrolle, ob die richtigen Modulowerte zum richtigen Divisorergebnis gehören
                System.out.print(newMod);
            }
            System.out.println("0"); // Print 0 für Bit des positiven Vorzeichens

            // System.out.println(decimalNumber); // Kontrolle, ob weiterhin die ursprünglich eingegebene Zahl ausgegeben wird

            // Part für negative Ganzzahlen:
            // bei Zahlen kleiner Null muss am Ender der Ausgabe eine 1 für Minus ausgegeben werden:
        } else {
            newDecimalNumber = newDecimalNumber * (-1); // Wir arbeiten mit derselben Ausgangszahl, nur dass für die Berechnung die positive Zahl davon benötigt wird;
            // im Grunde genommen ähnliches Programm zu natürlichen Zahlen

            // Part für Berechnung des Einerkomplements:
            System.out.println("Einerkomplement (from right to left):");
            for (i = 0; newDecimalNumber >= 1; i++) { // solange newDecimalNumber größer oder gleich 1 ist, Anweisungsblock durchführen
                int newDiv = newDecimalNumber / 2; // bspw. 6 / 2 = 3
                int newMod = newDecimalNumber % 2; // bspw. 6 % 2 = 0
                newDecimalNumber = newDiv; // bspw. wird 6 zu 3, dann zu 1
                // System.out.println(newDecimalNumber + "  R" + newMod); // Kontrolle, ob die richtigen Modulowerte zum richtigen Divisorergebnis gehören
                if (newMod == 0) {
                    // Einerkomplement: Inverse der positiven Zahl
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println("1"); // Print 1 für Bit des negativen Vorzeichens

            // Part für Ausgabe des Zweierkomplements:
            long einerKomp = Terminal.readLong("Please provide the given number above reading from right to left");
            // long, da int vom Zahlenbereich für 0 und 1 nicht ausreicht bei größeren Zahlen
            /** Achtung: neue Methode unter Terminal.java eingebaut! (Methode readLong) **/

            long zweiKomp1 = Long.parseLong(Long.toBinaryString(1));

            // Part für die Addition binärer Zahlen:
            int j = 0, carry = 0;

            int[] sum = new int[400]; // Anzahl der max. ausgegebenen Zahlen

            while (einerKomp != 0 || zweiKomp1 != 0) {
                sum[j++] = (int) ((einerKomp % 10 + zweiKomp1 % 10 + carry) % 2);
                carry = (int) ((einerKomp % 10 + zweiKomp1 % 10 + carry) / 2);
                einerKomp = einerKomp / 10;
                zweiKomp1 = zweiKomp1 / 10;
            }
            if (carry != 0) {
                sum[j++] = carry;
            }
            --j;
            System.out.println("Zweierkomplement: "); // Zweierkomplement: Inverse der positiven Zahl + 1, binär gerechnet
            while (j >= 0) {
                System.out.print(sum[j--]);
            }
            System.out.println();
        }

        System.out.println();
        // Eingabe von ganzen Zahlen möglich, die Definition für Gleitkommazahlen wurde bei der Programmierung dieser Aufgabe nicht berücksichtigt

        return 0;
    }


    // Aufgabe 4:

    static int[] arrSpeicher = new int[10]; // globales Array für beide Methoden aus Aufgabe 4

    /**
     * Template which reads a line of symbols and prints each symbol together
     * with its code number. It can be used as starting point for the
     * implementation of a hex-to-dec converter.
     */
    public static void convertHexToDec0() {
        System.out.println("*** Hexadecimal to Decimal Converter ***");
        System.out.print("Please provide a hexadecimal number with max. 10 characters (e.g. 1f): ");

        char ch = Terminal.readChar();
        int i = 0;

        while (ch != '\n') {
            arrSpeicher[i] = convertToNumber(ch);
            ch = Terminal.readChar();
            i++;
        }

        // Variante mit if else-Anweisungen (funktioniert genauso gut wie die switch case-Anweisung), if else-Anweisung ist hier noch nicht in convertToNumber ausgelagert:
        /*while (ch != '\n') {
            char code = ch;
            if (ch == 'A' || ch == 'a') {
                // System.out.print(10 + " ");
                arrSpeicher[i] = 10;
            } else if (ch == 'B' || ch == 'b') {
                // System.out.print(11 + " ");
                arrSpeicher[i] = 11;
            } else if (ch == 'C' || ch == 'c') {
                // System.out.print(12 + " ");
                arrSpeicher[i] = 12;
            } else if (ch == 'D' || ch == 'd') {
                // System.out.print(13 + " ");
                arrSpeicher[i] = 13;
            } else if (ch == 'E' || ch == 'e') {
                // System.out.print(14 + " ");
                arrSpeicher[i] = 14;
            } else if (ch == 'F' || ch == 'f') {
                // System.out.print(15 + " ");
                arrSpeicher[i] = 15;
            } else if (ch >= '0' && ch <= '9') {
                // System.out.print(code + " ");
                arrSpeicher[i] = ch - 48;
            } else {
                System.out.println("Nur Werte von a-f, A-F und 0-9 erlaubt!");
                break;
            }
            ch = Terminal.readChar();
            i++;
        }*/

        //System.out.println(i); // Benötigt für den Exponenten des Hornerschemas

        int result = 0;

        for (int j = 0; j < arrSpeicher.length; j++, i--) {
            //System.out.print(arrSpeicher[j] + " | ");
            int hornerSchema = arrSpeicher[j] * (int) Math.pow(16,i-1);
            // System.out.println(hornerSchema);
            result = hornerSchema + result;
        }

        System.out.println();

        System.out.println("Corresponding decimal number: " + result);
    }

    /**
     * Prof. Dr. R. Lunde 3/3
     * Converts a hexadecimal digit into the corresponding
     * number.
     *
     * @return value 0-16 or -1 for wrong digits.
     */
    public static int convertToNumber(char ch) {
        switch (ch) {
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                return (ch - 48);
            default:
                System.out.println("Please type in characters a-f, A-F or 0-9!");
                return -1;
        }
    }

}
