package PROG1.myprogrammsvorlesung;

/**
 * @author Paulina Pyczot
 **/

public class project5_TrainingDataTypes {
    public static void main(String[] args) {
        //testFloat();
        //testDouble();
        //testByte();
        //testChar();
        testBool ();
        decodeBinaryRepresentation(42);
    }

    public static void testDouble () {
        //double d = 7 / 0; // Fehler: exception "Arithmetic exception : / by zero"
        double d = -7.0 / 0; // = -inf
        System.out.println(d);
        //d = 5 / d; // = 0
        //d = d + -1*d; // = NaN
        d = d * (1 / d); // = NaN
        System.out.println(d);
    }

    public static void testFloat () {
        float f = 1; //floats werden normalerweise nicht benutzt, wenn dann in der Computergrafik
    }

    private static void testByte () {
        byte  b = 127; // max. Wert des Bytes = 8 Bit ist: 2^7 -1 (-1 für Abzug der 0; nicht 2^8, da das Most Significant Bit für das Vorzeichen draufgeht!)
        // ab 128 gibt Compiler einen Fehler aus "possible lossy conversion from int to byte"
        // b = (byte) (b + 1); // = b++ =++b
        b++; // ergibt -127, was eigentlich ja komplett falsch ist! Achtung, der Compiler gibt hier gar keine Info darüber, bei z.B. Pascal wäre hier ne Fehlermeldung gekommen
        System.out.println(b);
    }

    private static void testChar () {
        int i = 0;
        char c = 0;

        // Ausgabe der zugehörigen
        while (i < 200) {
            System.out.println(i + "->" + c);
            //i++; // Inkrement
            //c++; // Inkrement
            System.out.println(i++ + "->" + c++); // = die letzten 3 Zeilen oben drüber
            // i = i + c;
            //c = 'X'; // für i > 0 wird für c immer X gesetzt
        }
    }

    private static void testBool () {
        int i = 0;
        if (i < 10 || i++ < 5) {
            System.out.println("Hello");
        }
        System.out.println(i);
    }


    private static void decodeBinaryRepresentation (int num) {
        int i = 31;
        while (i >= 0) {
            if ((num & (1 << i)) != 0) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
            i--;
        }
    }
}
