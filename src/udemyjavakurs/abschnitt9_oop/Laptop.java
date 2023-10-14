package udemyjavakurs.abschnitt9_oop;

/**
 * @author Paulina Pyczot
 * @date 22.11.2022
 **/

public class Laptop {

    // Eigenschaften/ Attribute:
    int ram;
    int preis;
    String marke;

    // Konstruktoren:
    public Laptop (int ram, int preis, String marke) {
        this.ram = ram;
        this.preis = preis;
        this.marke = marke;
    }

    // Methoden:
    public void getLaptopData() {
        System.out.println("Die Marke ist: " + this.marke);
        System.out.println("Der Ram von " + this.marke + " beträgt " + this.ram + " GB.");
        System.out.println("Der Preis von " + this.marke + " beträgt " + this.preis + " €.");
    }

}
