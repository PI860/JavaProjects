package udemyjavakurs.abschnitt3_javagrundlagen;

public class StringZeichenkette_16 {
    public static void main(String[] args) {

        char varZeichen = '!'; //einzelne Anführungszeichen ''

        String varZeichenkette = "Ich bin eine Zeichenkette"; // normale Anführungzeichen ""

        /*
        String = komplexer Datentyp (kein primitiver) = Klasse
        Ein String besteht aus vielen einzelnen chars
        */

        //Programm zum Einloggen eines Users
        String name = "Christian";
        String alter = "25"; //hier ist die Zahl keine Zahl, sondern ein Text; sonst müsste man sie mit einem int angeben

        //Ausgabe beider Strings auf der Console
        System.out.println("Dein Name ist " + name + "\n" + "Dein Alter ist " + alter); // "\n" ist Zeilenumbruch
        //+ ist Zuweisungsoperator (wie = )
    }
}
