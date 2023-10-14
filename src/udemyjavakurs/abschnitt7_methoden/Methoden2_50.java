package udemyjavakurs.abschnitt7_methoden;

import java.util.Scanner;

public class Methoden2_50 {
    public static void main(String[] args) {

        // Merke: Eine Methode erledigt eine bestimmte Aufgabe

        for (int i = 1; i <= 10; i++){
            erstelleGegner();
            System.out.println("Nr. " + i);
        }

    }

        public static void erstelleGegner (){

        Scanner scan = new Scanner(System.in);
        System.out.println("Gebe Gegnernamen ein: ");
        String eingabeUser = scan.nextLine();

        String gegnerName = eingabeUser;
        int gegnerLeben = 100;
        System.out.println("Gegner wurde erstellt: " + gegnerName + "\nLP: " + gegnerLeben);
    }
}
