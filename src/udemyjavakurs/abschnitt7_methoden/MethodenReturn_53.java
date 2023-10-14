package udemyjavakurs.abschnitt7_methoden;

public class MethodenReturn_53 {
    public static void main(String[] args) { //mit public static void (Startprogramm der Methode) wird die Methode, die unten definiert wurde, entwickelt

        summe();
        System.out.println(summe());

        int a = summe();
        System.out.println("Der Wert der Variable a ist:" + a);

        int summe = a - 5;
        System.out.println("Der Wert in summe ist: " + summe );
    }

    public static int summe(){ //darf nicht "public static void" heißen, weil wir sonst eine leere Methode zurückgeben würden; da der Rückgabetyp von summe ein int ist, muss die Methode auch "public static int" heißen, sonst bekommen wir beim Startprogramm oben folgenden Fehler ausgegeben "java: 'void' type not allowed here'
        //2 Zahlen werden lokal erstellt:

        int a,b, summe;
        a = 5;
        b = 5; //a und b wurden somit initialisiert

        summe = a + b;  //Methode wurde somit definiert

        return summe; //ohne return bekommen wir beim Ausführen des Startprogramms Fehlermeldung "java: missing return statement"
        // Return = Rückgabe; "Nach getaner Arbeit gebe ich etwas zurück"
    }
}
