package udemyjavakurs.abschnitt9_oop;

/**
 * @author Paulina Pyczot
 * @date 21.11.2022
 **/

public class Auto { // Klasse als Bauplan = Datentyp

    // Eigenschaften = Attribute vom Auto (hier die 3 folgenden):
    int reifen;
    double preis;
    String marke;

    static int reifen1 = 4; // globale Klassenvariable, funktioniert auch ohne Objekt und gilt für jedes Auto!
    // Vorteil: jedes Objekt hat diese Variable bereits mit einem Wert befüllt

    // Konstruktor initialisiert Objekt mit Werten; dieser wird von Java automatisch erstellt, also müsste man das theoretisch nicht explizit hier hin schreiben, wenn man hier nichts reinfüllen will
    // Standardkonstruktor:
    public Auto() {
    }

    // selbst erstellter Konstruktor:
    public Auto(int reifen, double preis, String marke) {
        this.reifen = reifen; //this weist jedem Objekt (bspw. BMW) genau den Wert zu (aber nicht dem Datentyp "Auto", sondern wirklich dem Objekt selbst!)
        this.preis = preis;
        this.marke = marke;
    }

    // Methoden = was kann das Auto tun? (Gegenstück zu Attributen = welche Eigenschaften hat das Auto?)
    public static void ausgabe() { // static = funktioniert auch ohne ein Objekt!
        System.out.println("Ich bin eine Klassenmethode und brauche kein Objekt.");
    }

    public void gasGeben () {
        System.out.println("Das Auto mit der Marke " + this.marke + " fährt jetzt los.");
    }

    public void bremsen () {
        System.out.println("Das Auto mit der Marke " + this.marke + " bremst jetzt.");
    }

    public void vergleichePreis (double preis) {
        if (this.preis <= preis) {
            System.out.println("Der " + this.marke + " ist billiger.");
        } else {
            System.out.println("Der " + this.marke + " ist teurer.");
        }
    }
}
