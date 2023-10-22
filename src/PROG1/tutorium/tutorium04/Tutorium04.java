//import PROG1.Terminal;
//
///**
// * @author phoenig
// * Date:
// * Time: 15:50
// */
//public class Tutorium04 {
//    public static void convertHexToDec0() {
//        System.out.print("Please provide a hexadecimal number (e.g. 1f): ");
//        int result = 0;
//        char ch = Terminal.readChar();
//        while (ch != '\n') {
//
//            if (ch >= '0' && ch <= '9') {
//                int decValue = ch - '0';
//                // Beispiel für oben: ch = '2' -> 50
//                //                         '0' -> 48
//                System.out.println(decValue);
//            } else if (ch >= 'a' && ch <= 'f') {
//                int decValue = ch - 'a' + 10;
//            }
//            ch = Terminal.readChar();
//        }
//        System.out.println("Corresponding decimal number: " + result);
//    }
//    public static void test() {
//        byte num = 3;
//        int i = 0;
//        while (i < 10) {
//            System.out.print(num + " ");
//            num+=20;
//            i++;
//        }
//        System.out.println();
//    }
//
//    /**
//     * Was erzeugt test()?
//     * Vermutung: // 3 23 43 63 83 103 123 -112???
//     * 123 ins Binärsystem umrechnen:
//     * 123 / 2 = 61 Rest 1
//     *  61 / 2 = 30 Rest 1
//     *  30 / 2 = 15 Rest 0
//     *  15 / 2 = 7  Rest 1
//     *   7 / 2 = 3  Rest 1
//     *   3 / 2 = 1  Rest 1
//     *   1 / 2 = 0  Rest 1
//     *   123 = 1111011
//     *    20 =   10100
//     *     +  10001111 = -128 + 1 + 2 + 4 + 8
//     *     = -128 + 15 = -113
//     */
//
//    /**
//     * Übung Horner Schema
//     * 1231 (hex) -> Dezimalsystem
//     * 0*16 + 1 = 1
//     * 1*16 + 2 = 18
//     * 18*16 + 3 = 291
//     * 291*16 + 1 = 4657
//     *
//     * siehe auch https://de.wikipedia.org/wiki/Horner-Schema#Umwandlung_ins_Dezimalsystem
//     */
//
//    /*
//    Aufgabe: Primzahltest / Mirpzahltest
//    (Eine Mirpzahl ist eine Primzahl, die rückwärts
//    gelesen eine andere Primzahl ergibt (mirp ist prim rückwärts geschrieben).)
//
//    Die ersten Mirpzahlen im Dezimalsystem sind
//    13, 17, 31, 37, 71, 73, 79, 97, 107, 113, 149, 157,
//    167, 179, 199, 311, 337, 347, 359 */
//    public static boolean isPrime(int number) {
//        if(number < 2) {
//            return false;
//        }
//        for (int i = 2; i < number; i++) {
//            if(number % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        //convertHexToDec0();
//        int number = Terminal.readInt("Bitte Zahl");
//        if(isPrime(number)) {
//            System.out.println(number + " ist eine Primzahl");
//        }
//        // TODO zahl umdrehen: 123 -> 321
//        int numberReverted = 0;
//        while (number > 0) {
//           numberReverted = numberReverted * 10 + (number % 10);
//           number = number / 10;
//        }
//        System.out.println(numberReverted);
//    }
//
//
//}