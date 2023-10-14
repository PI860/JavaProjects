package thujavavorkurs.abschnitt3_schleifen;

import java.util.Scanner;

public class aufgabe1WiederUndWiederUndWieder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben Sie einen beliebigen Satz ein: ");
        String satz = scan.nextLine();
        System.out.println("Wie oft soll dieser Satz ausgegeben werden? Geben Sie eine beliebige Zahl ein: ");
        int anzahlSaetze = scan.nextInt();

        for (int i = 1; i <= anzahlSaetze;i++){ // (Anfangswert;Anzahl Durchgänge bzw. Abbruchbedingung;Zähler) {Anweisungsblock=Was soll in dieser Schleife wiederholt werden?}
            System.out.println(satz);
        }

        int i = 1;
        while (anzahlSaetze >= i){
            System.out.println(satz);
            i++;
        }

        int j = 1;
        do {
            System.out.println(satz);
            j++;
        }while (anzahlSaetze >= j);


    }
}
