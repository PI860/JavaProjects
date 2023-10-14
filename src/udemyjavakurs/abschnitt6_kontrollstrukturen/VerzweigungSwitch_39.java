package udemyjavakurs.abschnitt6_kontrollstrukturen;

import java.util.Scanner;

public class VerzweigungSwitch_39 {
    public static void main(String[] args) {

        // switch = Fallunterscheidung
        // case = Fall

        // Bedingung = als Bedingung gilt nur ein int, char oder String

        switch (10){
            case 0:
                System.out.println("Die Zahl ist eine 0");
                break;
            case 3:
                System.out.println("Die Zahl ist eine 3");
                break;
            case 5:
                System.out.println("Die Zahl ist eine 5");
                break;

        }

        System.out.println("Wie viele Bundesländer hat Deutschland?");
        System.out.println("15, 3, 16 oder 30?");

        Scanner scan = new Scanner(System.in);
        int eingabeUser = scan.nextInt();


        switch (eingabeUser){
            case 15:
                System.out.println("Falsch!");
                break;
            case 3:
                System.out.println("Falsch!");
                break;
            case 16:
                System.out.println("Richtig!");
                break;
            case 30:
                System.out.println("Falsch!");
                break;
            default: //default = wie else bei if-else nur halt mit switch (switch-default)
                System.out.println("Zahl ist unbekannt!");

        }

    }
}
