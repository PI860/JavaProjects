package PROG1.tutorium.tutorium05;

/**
 * @author Paulina Pyczot
 **/

public class arrayTest {
    public static void main(String[] args) {

        int value = 10; // value nimmt hier nur einen integer Wert an

        int[] array = new int[10]; // array kann einen bestimmten Wert annehmen, der in den 2. eckigen Klammern steht; diese Länge ist fix!

        array[0] = 123; // erster Feldplatzeintrag ist immer bei Index 0
        array[9] = 123; // letzter Feldplatzeintrag immer bei Länge des Arrays -1
        array[array.length - 1] = 123; // array.length kann eine bestimmte Stelle des Arrays zurückgeben, hier bspw. length - 1 = 10 - 1 = 9, also ist das dasselbe wie array[9]

        // Fehlermeldung Compiler IndexOutOfBoundsException = Array ist zu klein gewählt für den Ausgabewert

        int firstValue = array[0]; // ersten Eintrag auslesen
        int secondValue = array[1]; // ersten Eintrag auslesen; dieser Wert ist Null als Zahl (genauso wie alle anderen Werte, die noch nicht vergeben wurden)!

        // Um ein Array zu verlängern im Lauf des Programms, können die Werte des einen Arrays auf ein anderes Array umkopiert werden, da die Länge vom 1. Array fix und nicht mehr veränderlich ist im Lauf des Programms
        // Hier eine Möglichkeit, das Array zu vergrößern:
        int[] arrayTmp = new int[20];
        for (int i = 0; i < array.length; i++) {
            arrayTmp[i] = array[i]; // Einträge werden umkopiert
        }
        // Bessere Möglichkeit: linked list, die hat eine undefinierte Länge

        String[] stringArray = new String[10]; // stringArray; alle Werte geben aktuell den Wert 'null' als Wort aus!

        double[] verbrauchswerte = {5.6, 7.2, 4.5}; // Array der Länge 3 wird erzeugt

        int a = 1;
        tuWas(a);
        System.out.println(a);

        int[] aArray = {1,2,3};
        int[] bArray = aArray;
        // Debugger zeigt aArray und bArray an der gleichen Adresse an der Stelle @718

        tuWasArray(aArray.clone()); //
        tuWasArray(aArray);
        System.out.println(aArray[0]);
    }
    public static void tuWasArray (int[] a) {
        a[0] = 55; // falls das Array nicht existieren sollte, dann hätte man mit dieser Variablenzuordnung ein Problem
        // Array ist ein Referenzdatentyp und übergibt deshalb aus der Methode in die main-Methode die 55, es wird die Referenz kopiert, nicht aber die Feldplätze


    } // Shift+Alt+Pfeiltaste: gesamten Block verschieben

    public static void tuWas (int a) {
        a = 100;
        // bei einem primitiven Datentyp wie int wird andererseits nichts an die main-Methode übergeben, da hier keine Referenz ist
    }

}
