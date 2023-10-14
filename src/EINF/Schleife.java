package EINF;

/**
 * @author Paulina Pyczot
 * @date 09.01.2023
 **/

public class Schleife {
    public static void main(String[] args) {
        int a;
        int b = 0;
        for (a = 0; a < 6; a++) {
            if (a == 3) {
                b += 3;
            }
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(a+b);
    }
}
