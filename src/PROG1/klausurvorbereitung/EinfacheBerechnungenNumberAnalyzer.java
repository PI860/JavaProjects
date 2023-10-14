package PROG1.klausurvorbereitung;

/**
 * @author Paulina Pyczot
 * @date 29.01.2023
 **/

public class EinfacheBerechnungenNumberAnalyzer {
    private int a;
    private double b;
    public double computeSomething(double num) {
        a++;
        b+=num;
        return b / a;
    }
    public static void main(String[] args) {
        EinfacheBerechnungenNumberAnalyzer analyzer = new EinfacheBerechnungenNumberAnalyzer();
        System.out.println(analyzer.computeSomething(2));
        System.out.println(analyzer.computeSomething(4));
        System.out.println(analyzer.computeSomething(6)); }
}
