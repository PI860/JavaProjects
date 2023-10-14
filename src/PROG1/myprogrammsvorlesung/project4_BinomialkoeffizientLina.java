package PROG1.myprogrammsvorlesung;

public class project4_BinomialkoeffizientLina {
    public static void main(String[] args) {
       binom(1,1,2);
        System.out.println(binom(5,4,2));

        //Test, was binom(a,b,n) genau macht: mathematisch gesehen ist binom(a,b,n) = (a+b)^n
        double a =5;
        double b =0;
        int n = 3;
        double newBinom = binom(a, b, n-1);
        System.out.println(newBinom);
    }


    public static double binom (double a, double b, int n) {
            if (n == 1)
                return a + b;
            else if (n > 1)
                return (a + b) * binom(a, b, n-1);
            else // Errormessage
                return 0;
    }
}
