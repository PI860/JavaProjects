package udemyjavakurs.abschnitt6_kontrollstrukturen;

public class SchleifeWhile_44 {
    public static void main(String[] args) {

        // while = solange
        // for = sei...

        /* while (Bedingung){
           Anweisungsblock
           }
         */

        // Merke: Bedingung kann entweder true oder false sein

        int count = -1;
 //       while (count != 6){
 //           System.out.println("Ich bin:" + count);
 //           count ++;
 //       }

        while (true){
            System.out.println("HI");
            if (count == 3){
                break;
            }
            count ++;
        }

    }
}
