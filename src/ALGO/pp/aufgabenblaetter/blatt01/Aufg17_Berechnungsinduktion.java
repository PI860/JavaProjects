package ALGO.pp.aufgabenblaetter.blatt01;

/**
 * @author Paulina Pyczot
 * @date 19.10.2023
 **/

public class Aufg17_Berechnungsinduktion {
    public static void main(String[] args) {
        System.out.println(funnyFun(10 ));
        System.out.println(funnyFun(13 ));
        System.out.println(funnyFun(16 ));
        System.out.println(funnyFun(19 ));
    }
    public static int funnyFun(int n) {
        if (n < 10) {
            return n - 6;
        } else if (n % 3 == 0) {
            return 4;
        } else if (n > 19) {
            return 10 * funnyFun(n-10) - 47;
        } else {
            return ( funnyFun(n+1) + funnyFun(n/3) ) / 2;
        }
    }

}
