package udemyjavakurs.abschnitt3_javagrundlagen;

public class Operatoren_19 {
    public static void main(String[] args) {
        /*
        Mit Operatoren kann man Variablen verändern
        = Zuweisungsoperator
        +
        -
        /
        *
        ++: immer +1
        --: immer -1
        -=: das gleiche wie var1 = var1 - var2 -> var -= var2
         */

        int varZahl = 5;

        int zahl1 = 10;
        int zahl2 = 5;
        int zahl3 = 66;
        float zahl4 = 66f;

        int ergebnis = zahl1 + zahl2; //15
        System.out.println(ergebnis);

        ergebnis = zahl1 + zahl3; //76
        System.out.println(ergebnis);

        ergebnis = zahl1 - zahl3; //-56
        System.out.println(ergebnis);

        ergebnis = zahl1 * zahl2; //50
        System.out.println(ergebnis);

        float ergebnis1;

        ergebnis1 = zahl4 / zahl1; //6.6
        System.out.println(ergebnis1);

        varZahl ++;
        System.out.println(varZahl); //5+1=6

        varZahl ++;
        System.out.println(varZahl); //6+1=7

        varZahl --;
        System.out.println(varZahl); //7-1=6

        //Spiel Level up/down

        int lebenGegner = 100;
        int geschossEnergie = 20;

        lebenGegner = lebenGegner - geschossEnergie; //passiert, wenn der Gegner einmal mit einem Geschoss getroffen wird
        System.out.println(lebenGegner); //80

        lebenGegner -= geschossEnergie; //-= ist das gleiche wie lebenGegner - geschossEnergie
        System.out.println(lebenGegner); //60
    }

}
