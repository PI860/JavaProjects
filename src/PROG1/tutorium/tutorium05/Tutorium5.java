package PROG1.tutorium.tutorium05;

/**
 * @author phoenig
 * Time: 20:19
 */
public class Tutorium5 {
    public static void main(String[] args) {
        // Mathematisch
        // Beispiel: 7 mod -3 = -3 Rest -2
        //         -3*-3 = 9 -> 9-2 = 7

        // Modulo bei Java: Symmetrisch!
        // Ergebnis hat gleiches Vorzeichen wie Dividend (Dividend : Divisor)
        // Unterschied nur bei negativen Zahlen
        // Warum wichtig? ... -> Bei Portierungen
        System.out.println(7 % 3); // 1
        System.out.println(7 % -3); // 1
        System.out.println(-7 % 3); // -1
        double a = 1.432243243243432;
        double b = 2.43254543543;
        double c = 3.32432432432;
        System.out.println(a + " " + b + " " + c);
        System.out.printf("Das ist der Wert von a: %10.2f Das ist der" +
                "Wert von b: %.3f",a,b);
        arrayTest();
    }

    private static void arrayTest() {
        int value = 10;
        // Array anlegen:
        int[] array = new int[10];
        array[0] = 123; // erster Eintrag ist immer bei Index 0
        array[array.length - 1] = 123; // letzer Eintrag ist immer bei Länge des Arrays - 1
        int firstValue = array[0]; // ersten Eintrag auslesen
        int secondValue = array[1]; // ersten Eintrag auslesen

        ///////////////////////Array vergrößern: (Alternativ mit Arrays.copyOf(...)
        int[] arrayTmp = new int[20];
        for(int i = 0; i < array.length; i++) {
            arrayTmp[i] = array[i];     // Einträge umkopieren
        }
        array = arrayTmp;
        ///////////////////////

        String[] stringArray = new String[10]; // nach der Erzeugung sind alle Einträge erst einmal null

        double[] verbrauchswerte = {5.6, 7.2, 4.5};

        int a = 1;
        tuWas(a); // Der Wert von a wird kopiert!
        System.out.println(a); // 1!

        int[] aArray = {1,2,3};
        tuWasArray(aArray); // Es wird hier die Refernz auf das Array kopiert!
        System.out.println(aArray[0]); // 55!
    }
    public static void tuWasArray(int[] a) {
        a[0] = 55;
    }
    public static int tuWas(int a) {
        a = 100;
        return a;
    }
}
