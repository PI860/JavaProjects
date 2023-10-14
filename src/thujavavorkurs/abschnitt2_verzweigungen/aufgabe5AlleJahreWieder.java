package thujavavorkurs.abschnitt2_verzweigungen;

import java.util.Scanner;

public class aufgabe5AlleJahreWieder {
    public static void main(String[] args) {
        System.out.println("Gib ein Jahr ein: ");
        Scanner scan = new Scanner(System.in);

        int jahr = scan.nextInt();

        if (jahr % 4 == 0 && jahr % 100 != 0 || jahr % 400 == 0) {
            System.out.printf(jahr + " ist ein Schaltjahr!");
        } else {
            System.out.println(jahr + " ist kein Schaltjahr!");
        }
    }
}
