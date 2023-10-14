package udemyjavakurs.abschnitt3_javagrundlagen;

public class Variablen_14_15 {
    public static void main(String[] args) {
        /*
        8 primitive Datentypen von Java:
        byte
        short
        int
        long
        float
        double
        boolean
        char
         */
        /*
         Format zum Abspeichern solcher Daten:
         <Datentyp> <Variablenname> = <Wert>
         Linke Seite heißt Deklaration, rechte Seite ist Initialisierung (des Wertes in die Variable)
         Gleichzeichen ist Zuweisungsoperator, wir weisen den Wert auf der rechten Seite der linken Seite zu
         Deklaration | Zuweisungsoperator | Initialisierung=Wertzuweisung;
         Ein Datentyp gibt allgemein an, welche Information in einer Variable gespeichert werden kann
         */

        int varZahl1 = 3; /*Syntax gibt Semikolon vor, Semikolon kommt immer nach einer Anweisung
        Anweisung hier ist: Speicher die Zahl 3 in der Variable varZahl 1 ab*/
        long varZahl2 = 300;

        double varZahl3 = 322.45; //Kommazahlen immer mit Punkt abgrenzen, nicht mit Komma!
        float varZahl4 = 23.34f; /* es wird Fehler angezeigt, da Java beim Speichern von Kommazahlen double
        erwartet; deshalb muss hinter die Kommazahl ein "f", um explizit zu sagen, dass hier mit Absicht ein float
        verwendet werden soll; man nutzt float aus Speichereffizienzgründen (32bit float mit kleinerem Wertebereich,
        64bit double)*/

        boolean userKlick = true;//oder = false; auch bool genannt

        char zeichen = '!'; //es kann immer nur ein einziges Zeichen durch char initialisiert werden, nicht mehrere

        varZahl1 = 5; //hiermit wird die 3 mit der 5 überschrieben, nennt sich Zuweisung

        //Programm Highscore:

        int highscore = 0;
        System.out.println("Dein Highscore:" + highscore); //komplette Zeile kopieren mit Strg+C
        highscore = 10; // Zuweisung; Highscore steigt, sobald ein Gegner besiegt wurde um 10
        System.out.println("Dein Highscore:" + highscore);
        highscore = 20; //Gegner wurde besiegt
        System.out.println("Dein Highscore:" + highscore);

        /*
        Konvention für Variablennamen:
        - Anfang immer klein
        - Anfang immer Buchstabe, keine Zahl!
        - keine Schlüsselwörter (int, double, etc.) im Variablennamen verwenden
        - Camelcase Schreibweise: Schreibweise ist erster Teil der Variable klein, erster Großbuchstabe beim nächsten
        Wort derselben Variable, nächste Buchstaben wieder klein, beim nächsten Wort erster Buchstabe wieder groß:
        varCamelCase
         */
    }
}

/*
Variable = Container oder Wertspeicher
1. Schritt: Deklaration einer Variable
2. Schritt: Initialisierung = Zuweisung eines Anfangswert der Variable (also nur die Erstzuweisung heißt Initialisierung)
 */