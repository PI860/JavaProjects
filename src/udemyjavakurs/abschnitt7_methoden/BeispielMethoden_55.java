package udemyjavakurs.abschnitt7_methoden;

public class BeispielMethoden_55 {
    public static void main(String[] args) {

        int gegnerLeben = 100;
        System.out.println("LP: " + gegnerLeben);

        for (int i = 1; i == 10; i++) {
            gegnerLeben = gegnerHit(gegnerLeben);
            System.out.println("LP neu: " + gegnerLeben);
        }

    }

    public static int gegnerHit(int aktuellLeben){
        int neuGegnerLeben;

        neuGegnerLeben = aktuellLeben - 20;

        return neuGegnerLeben; //Fehler wird angezeigt, wenn die Methode mit einem return endet, aber die Methode mit "public static void" = "gebe NICHTS zurück am Ende" startet; deshalb muss die Methode mit "public static int/string/Datentyp/etc." anfangen


    }
}
