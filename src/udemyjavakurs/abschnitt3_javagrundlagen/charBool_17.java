package udemyjavakurs.abschnitt3_javagrundlagen;

public class charBool_17 {
    public static void main(String[] args) {
        char varZeichen = 'd';
        /*
        Unicode gibt jedem Zeichen eine eigene Nummer, da der Computer ja nur Zahlen versteht;
        siehe Unicode-Table
         */

        char varHerz = '\u2764';
        ////Herz hat Unicode 2764, in Java muss U+ durch ein "\" "u" ersetzt werden
        System.out.println(varHerz);

        boolean userKlick = true; //true = wahr, false = nicht wahr; wird oft für if und else benutzt
        /*
        if = falls
        else = sonst
        zum Beispiel zur Bestätigung einer Schaltfläche
         */
    }
}
