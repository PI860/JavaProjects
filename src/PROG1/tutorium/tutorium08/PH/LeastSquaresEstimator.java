package programming1lunde.tutorium.tutorium08.PH;

import programming1lunde.tutorium.tutorium08.PH.Point;

public class LeastSquaresEstimator {

    private double m;
    private double b;

    public LeastSquaresEstimator(Point[] points) {
    }

    public void performLinearRegression(Point[] points) {
        // hier wird die Regressionsgerade bestimmt, also m und b
        // m => Steigung der Geraden; b => y-Achsenabschnitt
    }

    public double caluculateY(double x) {
        return m * x +b; // "x-Wert in die Gleichung einsetzen."
    }
}
