package udemyjavakurs.abschnitt6_kontrollstrukturen;

public class VerzweigungIfElse_37 {
    public static void main(String[] args) {

        int i = -2;
        if (i == 1){
            System.out.println("1. Zahl in i ist: " + i);
        }else if (i <= 1){
            System.out.println("2. Zahl in i ist: " + i);
        }else if (i >= 1){
            System.out.println("3. Zahl in i ist:" +i);
        }else{
            System.out.println("Zahl ist unbekannt!");
        }

        int score = 1001; //diesen Wert verändern
        int lebenPlayer = 4;

        if (score == 1000 && lebenPlayer < 3  || lebenPlayer > 3){
            System.out.println("Du hast 1 Stern von 3 Sternen erhalten! " + "Deine Leben betragen: " + lebenPlayer);
        }else if (score <= 5000 && lebenPlayer < 3 || lebenPlayer > 3){
            System.out.println("Du hast 2 Sterne von 3 erhalten! " + "Deine Leben betragen: " + lebenPlayer);
        }else if (score >= 5000 && lebenPlayer < 3 || lebenPlayer > 3){
            System.out.println("Du hast 3 von 3 Sternen erhalten! " + "Deine Leben betragen: " + lebenPlayer);
            lebenPlayer += 1;
            System.out.println("Deine Leben betragen: " + lebenPlayer);
        }

    }
}
