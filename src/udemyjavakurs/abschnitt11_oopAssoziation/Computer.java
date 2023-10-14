package udemyjavakurs.abschnitt11_oopAssoziation;

/**
 * @author Paulina Pyczot
 * @date 30.01.2023
 **/

public class Computer {
   //Attribute:
    String cpu;
    double preis;
    Mainboard mainboard;


    //Konstruktoren:
    public Computer() {

    }
    public Computer (String cpu, double preis, Mainboard mainboard) {
        this.cpu = cpu;
        this.preis = preis;
        this.mainboard = mainboard;
    }

    public Computer (int ramSlots, int kartenSlots, int usbPorts, String cpu) {
        mainboard = new Mainboard(ramSlots, kartenSlots, usbPorts);
        this.cpu = cpu;
    }

    //Methoden:
}
