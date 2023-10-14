package udemyjavakurs.abschnitt7_methoden;

public class ReturnTR_52 {
    public static void main(String[] args) {

        int summe = taschenrechner(-6,-3,'*');
        System.out.println(summe);
    }

    public static int taschenrechner (int zahl1, int zahl2, char operator) {

        int summe = 0; //lokale Variable -> nur sichtbar in dem Anweisungsblock von "taschenrechner"

        //Der folgende Anweisungsblock ist die Methode
        if (operator == '+') {
            summe = zahl1 + zahl2;
        } else if (operator == '-') {
            summe = zahl1 - zahl2;
        } else if (operator == '*') {
            summe = zahl1 * zahl2;
        } else if (operator == '/') {
            summe = zahl1/zahl2;
        }  else {
            System.out.println("Fehler");
        }
        return summe; //Lebensdauer der Methode ist ohne "return" zu Ende, somit ist die Lebensdauer der Variable "summe" abgelaufen, alle Variablen sind ab sofort im Programm "gelöscht"

        /*
        return = Schlüsselwort, sobald die Methode die Aufgabe erfüllt hat, wird mit diesem Schlüsselwort "return" den Wert von "summe" zurückgegeben und vor allem GESPEICHERT
         */
    }

}
