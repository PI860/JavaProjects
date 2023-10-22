package ALGO.pp.aufgabenblaetter.blatt01;

/**
 * @author Paulina Pyczot
 * @date 19.10.2023
 **/

public class Aufg12_GeschachtelteSchleifen {
    public static void main(String[] args) {
        countLoops(4);
    }

    public static void countLoops (int n) {
        int count = 1;
        for (int j = 2 * n; j >= 1; j--) {
            for (int v = 0; v < j; v++) {
                System.out.println("Schleifendurchläufe: " + count);
                count ++;
            }
        }
    }

}
