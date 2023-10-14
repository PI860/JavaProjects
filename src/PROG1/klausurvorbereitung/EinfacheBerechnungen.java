package PROG1.klausurvorbereitung;

/**
 * @author Paulina Pyczot
 * @date 29.01.2023
 **/

public class EinfacheBerechnungen {
    public static void main(String[] args) {
            int num = 4;
            for (int i = 31; i >= 0; i--) {
                System.out.print((num & 1 << i) != 0 ? 1 : 0);
            }
            System.out.println();
    }



}

