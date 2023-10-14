package PROG1.abgaben.uebungsblatt8.pp.prog1.exercises.set08;

/**
 * @author Paulina Pyczot
 * @date 29.11.2022
 **/

public class LeastSquaresEstimator {

    // Attribute:
    Point[] edges;

    // Constructors:

    /**
     * To activate the manual input of coordinates, please comment this constructor back in and also all the lines written in @LeastSquaresEstimatorDemo and turn off constructor @points
     * //@param coordinates
     */
//    public LeastSquaresEstimator (double... coordinates) {
//        edges = new Point[coordinates.length / 2]; // alle Feldplätze sind danach null
//        for (int i = 0; i < edges.length; i++) {
//            edges[i] = new Point(coordinates[2 * i], coordinates[2 * i + 1]); // Passende Werte von coords nehmen, Objekt erstellen und einfügen
//        }
//    }

    public LeastSquaresEstimator (Point[] points) {
        this.edges = points;
    }

    // Methoden:
    public String toString() {
        for (int i = 0; i < edges.length; i++) {
            Point pointi1 = edges[i];
            //System.out.println("Sales in month " + (int)pointi1.getX() + ": (" + pointi1.getX() + ", " + pointi1.getY() + ")");
            System.out.println("Coordinates: (" + pointi1.getX() + ", " + pointi1.getY() + ")");
        }

        return null;
    }

    // Calculate 𝑥𝑥:
    public double calculateArithmeticMeanX () {
        double sumX = 0;
        for (int i = 0; i < edges.length; i++) {
            Point pointi1 = edges[i];
            sumX += pointi1.getX();
        }
        return sumX / edges.length;
    }

    // Calculate 𝑦𝑦:
    public double calculateArithmeticMeanY () {
        double sumY = 0;
        for (int i = 0; i < edges.length; i++) {
            Point pointi1 = edges[i];
            sumY += pointi1.getY();
        }
        return sumY / edges.length;
    }

    // Calculate gradient m:
    public double calculateGradientM () {
        double sumUp = 0;
        double sumDown = 0;
        for (int i = 0; i < edges.length; i++) {
            Point pointi1 = edges[i];
            sumUp += ((pointi1.getX() - calculateArithmeticMeanX()) * (pointi1.getY() - calculateArithmeticMeanY()));
            sumDown += Math.pow (pointi1.getX() - calculateArithmeticMeanX(),2);
        }
        return sumUp / sumDown;
    }

    // Calculate intercept b:
    public double calculateInterceptB () {
        return calculateArithmeticMeanY() - (calculateGradientM() * calculateArithmeticMeanX());
    }

    public int calculateRegressionLine () {
        int sum1 = 0;
        int[] sum1Array = new int[edges.length];

        for (int i = 0; i < edges.length; i++) {
            Point pointi1 = edges[i];
            sum1 = (int) Math.round (calculateGradientM()*pointi1.getX() + calculateInterceptB());
            System.out.println("Estimated sales in month " + (int) pointi1.getX() + ": " + sum1);
            sum1Array[i] += sum1;
        }

        int j = edges.length+1;
        // Estimation for month x-12:
        for (int i = j; i <= 12; i++) {
            sum1 = (int) Math.round (calculateGradientM()*i + calculateInterceptB());
            System.out.println("Estimated sales in month " + i + ": " + sum1);
        }

//        int sum1 = 0;
//
//        for (int i = 0; i <= 12; i++) {
//            Point pointi1 = edges[i];
//            //pointi1.getX() = i;
//            sum1 = (int) Math.round (calculateGradientM()*i + calculateInterceptB());
//            System.out.println("Estimated sales in month " + i + ": " + sum1);
//        }
//
//        return sum1;
        return sum1Array[1];
    }

    public int calculateFirstPointOnRegressionLine () {
        int sum1 = 0;
        int[] sum1Array = new int[edges.length];

        for (int i = 0; i < edges.length; i++) {
            Point pointi1 = edges[i];
            sum1 = (int) Math.round (calculateGradientM()*pointi1.getX() + calculateInterceptB());
            System.out.println("Estimated sales in month " + (int) pointi1.getX() + ": " + sum1);
            sum1Array[i] += sum1;
        }

        int j = edges.length+1;
        // Estimation for month x-12:
        for (int i = j; i <= 12; i++) {
            sum1 = (int) Math.round (calculateGradientM()*i + calculateInterceptB());
            System.out.println("Estimated sales in month " + i + ": " + sum1);
        }

//        int sum1 = 0;
//
//        for (int i = 0; i <= 12; i++) {
//            Point pointi1 = edges[i];
//            //pointi1.getX() = i;
//            sum1 = (int) Math.round (calculateGradientM()*i + calculateInterceptB());
//            System.out.println("Estimated sales in month " + i + ": " + sum1);
//        }
//
//        return sum1;
        return sum1;
    }

}
