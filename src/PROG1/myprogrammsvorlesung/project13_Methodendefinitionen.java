package PROG1.myprogrammsvorlesung;

import PROG1.Terminal;

/**
 * @author Paulina Pyczot
 **/

public class project13_Methodendefinitionen {

    public static void main(String[] args) {
        int i = Terminal.readInt("Number 1");
        int j = Terminal.readInt("Number 2");
        System.out.println(multiply(i,j)); // für i = 2 und j = 5 Ausgabe: "10"
        printSquare(i); // Ausgabe: "Square of 2 is 4."
        System.out.println(fourtyTwo()); // i1 = 2 * 21 = 42, Ausgabe: "42"
        System.out.println(isPrime(i)); // true für 2
    }

    public static int multiply(int factor1, int factor2) {
        return factor1 * factor2;
    }
    public static void printSquare(int value) {
        System.out.println("Square of " + value + " is " + value * value + ".");
    }
    public static int fourtyTwo() {
        int i1 = 21;
        i1 = 2 * i1;
        return i1;
    }
    public static boolean isPrime(int number) {
        int max = (int) Math.sqrt(number); // bei number = 2 ist max = sqrt(2)
        for(int i= 2; i<= max; i++) // solange i kleiner gleich max ist, soll i = 2 erhöht werden um immer eins und der Anweisungsblock soll durchgeführt werden
            if(number % i== 0) // wenn 2 % 2 = 0 ist, dann gibt der boolean ein false zurück
                return false;
        return true; // bei number = 2 gerät man direkt hierher, da die Schleife von vornherein false ist (i<=max ist nicht erfüllt mit Anfangswert 2<=sqrt(2)
    }
}
