package udemyjavakurs.abschnitt3_javagrundlagen;

public class Aufgabe2_24 {
    public static void main(String[] args) {
        /*
        Aufgabe:

        1. Auto kostet: 3500 €
        2. Auto kostet: 2340.48 €

        a) Daten in Variablen abspeichern.
        b) Kommazahl in Ganzzahl umwandeln.
        c) Beide Ganzzahlen zu einem Gesamtbetrag verrechnen.
        d) Gesamtbetrag ausgeben.
         */

        int auto1 = 3500;
        int auto2 = (int) 2340.48; //(int) heißt Castoperator

        int gesamtAuto = auto1 + auto2;

        System.out.println("Gesamtbetrag: " + gesamtAuto + "€");
    }
}
