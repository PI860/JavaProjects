package udemyjavakurs.abschnitt3_javagrundlagen;

public class Aufgabe1_23 {
    public static void main(String[] args) {
        /*
        Aufgabe:

        1. Auto: 3500
        2. Alter: 18
        3. Vorname: Peter
        4. Nachname: Müller

        a) Überlege, welchen Datentyp die Informationen repräsentieren.
        b) Lege Variablen fest und speicher diese Werte in den Variablen ab.
        c) Gebe die Werte mit Hilfe von System.out.println(""); aus.
         */

        int auto = 3500;
        int alter = 18;
        String vorName = "Peter";
        String nachName = "Müller";

        System.out.println("Auto: " + auto + "€\n"
                + "Alter: " + alter + "\n"
                + "Vorname: " + vorName + "\n"
                + "Nachname: " + nachName);
    }
}
