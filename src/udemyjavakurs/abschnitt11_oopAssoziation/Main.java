package udemyjavakurs.abschnitt11_oopAssoziation;

import udemyjavakurs.abschnitt11_oopAssoziation.*;

/**
 * @author Paulina Pyczot
 * @date 30.01.2023
 **/

public class Main {
    public static void main(String[] args) {

        Mainboard mainboardAsus = new Mainboard(4,2,4);
        Computer computerPeter = new Computer("Intel",400,mainboardAsus);

        System.out.println(computerPeter.mainboard.usbPorts);

        //Mainboard mainboardAsrock = new Mainboard(2,1,2);
        Computer computerOlga = new Computer(2,1,2,"AMD");
        System.out.println(computerOlga.mainboard.usbPorts);

        Auto bmw = new Auto("BMW", "Goodyear", "Winterreifen");
        Auto vw = new Auto("VW", "Michelin", "Sommerreifen");

        bmw.ausgabeDaten();
        vw.ausgabeDaten();
    }
}
