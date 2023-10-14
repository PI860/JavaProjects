package udemyjavakurs.abschnitt6_kontrollstrukturen;

public class SchluesselwortIf_36 {
    public static void main(String[] args) {

        // Kontrollstrukturen steuern den Programmablaufplan

        // if = falls
        // else = ansonsten

        int score = 6000; //Falls sich dieser Wert ändern, greifen die Bedingungen für folgendes if-else

        if (score >= 5000){ // falls der Score = 5000 true wird, wird das untere ausgegeben
            System.out.println("Herzlichen Glückwunsch, neuer Rekord!");
        }else{
            System.out.println("Highscore nicht erreicht.");
        }

        int lebenPlayer = 0; //man kann in die Variable lebenPlayer auch Grafiken einspeichern, Grafiken haben dann einen anderen Variablentyp als z.B. hier int

        if (lebenPlayer == 0){
            System.out.println("Spiel verloren");
        }

        boolean gegnerHit = false; // diesen Wert verändert zwischen true und falls, um Änderung zu sehen
        int highscore = 0;

        if (gegnerHit == true){
            System.out.println("Gegner getroffen");
            highscore += 10;
            System.out.println("Dein Highscore: " + highscore);
        }else{
            System.out.println("Daneben!");
        }


    }
}
