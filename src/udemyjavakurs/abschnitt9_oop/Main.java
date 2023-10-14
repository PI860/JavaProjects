package udemyjavakurs.abschnitt9_oop;

/**
 * @author Paulina Pyczot
 * @date 21.11.2022
 **/

public class Main {
    public static void main(String[] args) {
        // Klasse Auto:

        // Datentyp variablenName = new Konstruktor(); // rechte Seite wird der linken Seite zugewiesen
        // Konstruktor initialisiert das Objekt mit Werten; d.h.: Konstruktor erstellt sozusagen das Objekt und heißt immer genauso wie der Datentyp selbst
//        Auto bmw = new Auto(); // new-Operator reserviert den Speicherplatz im Arbeitsspeicher für den neuen Datentyp "Auto"
//        System.out.println(bmw); // gibt udemyjavakurs.abschnitt9_oop.Auto@e9e54c2 aus; das am Ende ist der Strichcode, welches genau zum Objekt "BMW" passt und dessen Identität ist
//        bmw.preis = 5000;
//        bmw.marke = "BMW";
//        bmw.reifen = 4;
//        System.out.println("Preis: "+ bmw.preis + ", Marke: " + bmw.marke + ", Reifen: " + bmw.reifen);
//
//        Auto mercedes = new Auto();
//        System.out.println(mercedes); // gibt udemyjavakurs.abschnitt9_oop.Auto@65ab7765 aus; ist andere Nummer wie bei "BMW"!
//        mercedes.preis = 6000;
//        mercedes.marke = "Mercedes";
//        mercedes.reifen = 4;
//        System.out.println("Preis: "+ mercedes.preis + ", Marke: " + mercedes.marke + ", Reifen: " + mercedes.reifen);
//
//        Auto vw = new Auto();
//        vw.preis = 4000;
//        vw.marke = "VW";
//        System.out.println("Preis: "+ vw.preis + ", Marke: " + vw.marke);

        Auto bmw = new Auto(); // new-Operator reserviert den Speicherplatz im Arbeitsspeicher für den neuen Datentyp "Auto"
        System.out.println(bmw); // gibt udemyjavakurs.abschnitt9_oop.Auto@e9e54c2 aus; das am Ende ist der Strichcode, welches genau zum Objekt "BMW" passt und dessen Identität ist
        bmw.preis = 5000;
        bmw.marke = "BMW";
        System.out.println("Preis: "+ bmw.preis + ", Marke: " + bmw.marke + ", Reifen: " + Auto.reifen1);
        bmw.gasGeben();
        bmw.bremsen();
        Auto.ausgabe(); // ruft static Methode auf, welche ohne Objekt funktioniert

        Auto mercedes = new Auto(4,6000, "Mercedes"); // die 3 Werte werden an this. übergeben
        System.out.println("Preis: "+ mercedes.preis + ", Marke: " + mercedes.marke + ", Reifen: " + Auto.reifen1);
        mercedes.gasGeben();
        mercedes.bremsen();
        mercedes.vergleichePreis(bmw.preis);

        bmw.vergleichePreis(mercedes.preis);

        // Klasse Hund:

        Hund bello = new Hund(12,"Bello","Golden Retriever");
        bello.bellen();
        System.out.println("Alter: " + bello.alter + ", Name: " + bello.name + ", Rasse: " + bello.rasse);

        // Laptop:

        Laptop lenovo = new Laptop(16,1200,"Lenovo");
        lenovo.getLaptopData();

        Laptop samsungLaptop = new Laptop(8,600,"Samsung");
        samsungLaptop.getLaptopData();

        Laptop medionLaptop = new Laptop(4, 400, "Medion");
       medionLaptop.getLaptopData();
    }


}
