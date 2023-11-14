package ALGO.pp.aufgabenblaetter.blatt03;

/**
 * @author Paulina Pyczot
 * @date 06.11.2023
 **/

public class Aufg3_7_Laufzeitkomplexitätsanalyse {
    public static void main(String[] args) {
        double[] arr = {1,2,3,7,89,5,6,5,2,1,4,3,6,11,3,9};
        System.out.println(methWS23(arr));
    }

    public static double methWS23(double[] data) {
        int n = data.length;
        double sum = 0;

        for (int j = 1; j <= n; j *= 2) {

            for (int m = n-1; m >= 0; m--) {
                data[m] = data[m] + data[j];
                }

            int k = n;
            while (k > 0) {
                sum += 3 * data[k - 1];
                k = k / 2;
                }
            }

        return sum;
        }
}
