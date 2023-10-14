package udemyjavakurs.abschnitt6_kontrollstrukturen;

import java.util.Scanner;

public class AufgabeVerzweigung_38 {
    public static void main(String[] args) {

        System.out.println("Wie viele Bundesländer hat Deutschland?");
        System.out.println("15, 3, 16 oder 30?");

        Scanner scan = new Scanner(System.in);
        int eingabeUser = scan.nextInt();
        int anzahlBundesländer = 16;

        for (int i = 1; i == 1000; i++) {
            if (eingabeUser != anzahlBundesländer) {
                System.out.println("Falsch!");
            } else
                System.out.println("Richtig, kriegst n Keks!");
        }
    }
}
