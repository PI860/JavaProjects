package PROG1.tutorium.tutorium06;

/**
 * @author Paulina Pyczot
 **/

public class Tutorium6 {
    public static void main(String[] args) {

        // For-each-Schleife:
        double[] array = {1,2,3,4,5} ;

        for (double element : array) { // for-each-Schleife: gebe jedes Element aus "array" aus
            System.out.println(element);
        }

        double[][] bigArray = new double[10][];

        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = array.clone();
        }

        for (double[] element : bigArray) {

        }



    }
}
