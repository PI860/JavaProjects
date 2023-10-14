package PROG1.myprogrammsvorlesung;

/**
 * @author Paulina Pyczot
 **/

public class project9_Formalparameter {
        public static void add1(int n) {
            n++;
            System.out.println(n);
        }

        public static void main(String[] args) {
            int i = 13;
            i = i++ * 2;
            System.out.println(i); // = 13 * 2 = 26

            int j = 13;
            j = ++j * 2; // = 14 * 2 = 28
            System.out.println(j);

            int k = 13;
            add1(k); // Ausgabe: n++ erhöht k um 1, d.h. k wird im nächsten Schritt zu k = 14; print = 14
            System.out.println(k); // Ausgabe: 13, da Änderungen in der aktuellen Funktion nichts am Wert des Formalparameters aus add1 verändern
        }
}
