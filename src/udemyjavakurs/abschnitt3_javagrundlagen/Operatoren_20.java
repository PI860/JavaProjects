package udemyjavakurs.abschnitt3_javagrundlagen;

public class Operatoren_20 {
    public static void main(String[] args) {
        /*
        Vergleichsoperatoren:
        ==
        <
        >
        <=
        >=
        !=: ungleich
        &&: logisches Und
        ||: logisches Oder
        Werden oft mit if/ else zusammen genutzt:
        if (Bedingung) {

            Wenn die Bedingung true = wahr ist, dann wird alles zwischen { } ausgeführt
            }
         */

        int a = 3;
        int b = 3;
        boolean c;

        c = a == b; // c ist ein boolean, == prüft auf Gleichheit; d.h. c ist true

        System.out.println(c); // true, da a = b

        c = a < b;

        System.out.println(c); // false, da a = b

        //Spiel Level

        int lebenGegner = 1; //Wert verändern auf 0, damit if-Entscheidung genommen wird und ungleich 0 für else
        boolean hit = false; //Wert verändern auf true, damit if-Entscheidung genommen wird und ungleich false für else

        if (lebenGegner == 0) {
            System.out.println("Gegner hat verloren");
        }
        else{
            System.out.println("Gegner hat noch: " + lebenGegner + " Punkte");
        }

        if (lebenGegner == 0 && hit == true) { //&& ist logischer Und-Opeartor
            System.out.println("Gegner hat verloren");
        }
        else{
            System.out.println("Gegner hat noch: " + lebenGegner + " Punkte");
        }

        if (lebenGegner == 0 || hit == true) { //|| ist logischer Oder-Opeartor
            System.out.println("Gegner hat verloren");
        }
        else{
            System.out.println("Gegner hat noch: " + lebenGegner + " Punkte");
        }
    }
}
