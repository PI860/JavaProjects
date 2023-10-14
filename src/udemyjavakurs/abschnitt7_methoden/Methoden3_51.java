package udemyjavakurs.abschnitt7_methoden;

public class Methoden3_51 {
    public static void main(String[] args) {

        erstelleGegner("Peter", 100);
        erstelleGegner("Olaf", 80);
    }

    public static void erstelleGegner (String name, int lebenspunkte) {
        String gegnerName = name;
        int gegnerLeben = lebenspunkte;
        System.out.println("Gegner wurde erstellt: " + gegnerName + "\nLP: " + gegnerLeben);
    }}