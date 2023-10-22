package ALGO.pp;

/**
 * @author Paulina Pyczot
 * @date 14.10.2023
 **/

public class lektion03_frage04 {
    public static String buildString(int n) {
        if (n <= 3) {
            return "bb";
        } else if (n % 2 == 0) {
            return buildString(n - 1) + buildString(n + 1);
        } else {
            return "ba" + buildString(n / 3) + "ba";
        }
    }

    public static void main(String[] args) {

        System.out.println(buildString(4));
    }
}
