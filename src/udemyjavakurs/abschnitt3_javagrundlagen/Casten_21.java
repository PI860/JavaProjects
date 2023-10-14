package udemyjavakurs.abschnitt3_javagrundlagen;

public class Casten_21 {
    public static void main(String[] args) {
        /*
        Casten = Typumwandlung von Datentyp 1 auf Datentyp 2, z.B. von int auf double
         */

        //int userAlter = 18.5; //18.5 hat eigentlich Datentyp double
        int userAlter = (int) 18.5; // (neuerDatentyp) in Klammern gibt dann die Zahl als Ganzzahl statt Dezimalzahl wieder

        System.out.println(userAlter);

        /*
        Implizites Casten: Typenumwandlung von klein nach groß, kein Datenverlust (bspw. von int auf long, float oder double);
        Explizites Casten: Typenumwandlung von groß nach klein, Datenverlust!, bspw. von Dezimalzahl auf int;
        Umwandlung findet bereits bei der Zuweisung statt
         */
        int zahl1 = 30;
        double zahl2 = zahl1;

        System.out.println(zahl2); //es wird die 30.0 ausgegeben, implizites Casten

        //Autopreise ohne Kommazahlen (Explizites Casten):

        int autoPreis1 = (int)3450.45;
        int autoPreis2 = (int)2690.94;

        int gesamtPreis = autoPreis1 + autoPreis2;

        System.out.println("Preis Auto 1: " + autoPreis1
                + '\n' + "Preis Auto 2: " + autoPreis2
                + '\n' + "Preis gesamt: " + gesamtPreis);

        double varZahl3 = 3.454367;
        int varZahl4 = (int) varZahl3;

        System.out.println(varZahl4);
    }
}
