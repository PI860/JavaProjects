package thujavavorkurs.abschnitt4_arrays;

public class aufgabe3EinGuterTausch {
    public static void main(String[] args) {
        int[] myNumbers = {1, 2, 3, 4, 5}; //Soll: 23451
        int tausch;

        for (int a = 0; a < myNumbers.length; a++){
            System.out.print(myNumbers[a]); //Zur Ausgabe eines Arrays wird eine Schleife benötigt, sonst wird nur Blödsinn ausgegeben
        }
        System.out.println();

        for (int i = 0; i < myNumbers.length; i++){
            tausch = myNumbers[i+1];
            myNumbers[i+1] = myNumbers [i];
            //System.out.print("\n" + myNumbers[i]);
            myNumbers[i] = tausch;
            //System.out.print("\n" + tausch);
            for (int a = 0; a < myNumbers.length; a++){
                System.out.print(myNumbers[a]);
            }
            System.out.println();

        }


    }
}
