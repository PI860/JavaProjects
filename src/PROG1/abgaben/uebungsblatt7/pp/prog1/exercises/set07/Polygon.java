package PROG1.abgaben.uebungsblatt7.pp.prog1.exercises.set07;

/**
 * @author Paulina Pyczot
 * @date 20.11.2022
 **/

public class Polygon {

    // Attribute:

    // Array aus dem neuen Datentyp Point erstellen:
    private Point[] edges;

    // Konstruktoren:


    // Methoden:
    public Polygon(double... coordinates) {
        edges = new Point[coordinates.length / 2]; // alle Feldplätze sind danach null
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Point(coordinates[2 * i], coordinates[2 * i + 1]); // Passende Werte von coords nehmen, Objekt erstellen und einfügen
        }
    }

    public Polygon(Point[] points) {
        this.edges = points;
    }

    public String toString() {
        System.out.print("{");
        for (int i = 0; i < edges.length; i++) {
            Point pointi1 = edges[i];
            System.out.print("(" + pointi1.getX() + ", " + pointi1.getY() + ")");
        }
        System.out.print("}");
        return null;
    }

    public double calculateArea1() {
        double result = 0;
        for(int i = 0; i < edges.length; i++) {

            // Wenn i der Index vom letzten Feldplatz ist, ist i plus 1 der erste Index vom Array (also 0)
            // Diese Korrektur findet nachfolgend statt:
            int ip1 = i+1;
            if(ip1 == edges.length) {
                ip1 = 0;
            }

            Point pointi = edges[i];         // Point an der Stelle i
            Point pointip1 = edges[ip1];     // Point an der Stelle i+1
            result += (pointi.getY() + pointip1.getY()) * (pointi.getX() - pointip1.getX()); // Formel vom Aufgabenblatt
        }
        return Math.abs(result/2); // Durch 2 teilen und Absolutwert nehmen, da das Ergebnis negativ sein kann...
    }

    public double calculateArea2 () {
        double result = 0;
        for(int i = 0; i < edges.length; i++) {

            // Wenn i der Index vom letzten Feldplatz ist, ist i plus 1 der erste Index vom Array (also 0)
            // Diese Korrektur findet nachfolgend statt:
            int ip1 = i+1; // x(i+1) oder y(i+1)
            int ipMinus1 = i-1;
            if(ip1 == edges.length) {
                ip1 = 0;
            }
            if (ipMinus1 == -1) {
                ipMinus1 = edges.length-1;
            }

            Point pointi = edges[i];         // Point an der Stelle i
            Point pointip1 = edges[ip1];     // Point an der Stelle i+1
            Point pointipMinus1 = edges[ipMinus1];
            result += (pointi.getX() * (pointip1.getY() - pointipMinus1.getY())); // Formel vom Aufgabenblatt
        }
        return Math.abs(result/2); // Durch 2 teilen und Absolutwert nehmen, da das Ergebnis negativ sein kann...
    }

    public void smooth () {
        Point[] pointsSmooth = new Point[edges.length*2];
        System.out.print("{");
        for (int i = 0; i < edges.length; i++) {
            int ip1 = i+1;

            if(ip1 == edges.length) {
                ip1 = 0;
            }

            Point pointi = edges[i];
            Point pointip1 = edges[ip1];

            // Geradengleichung aufstellen:
//            double t = 0; // Unbekannte in Geradengleichung
//            double s = 0;
//            double geradeXKoord = pointi.getX() + t * (pointip1.getX() - pointi.getX()); // x-Koord von g: Punkt1 + t * (Punkt2 - Punkt1)
//            double geradeYKoord = pointi.getY() + t * (pointip1.getY() - pointi.getY());
            double variableX = (pointip1.getX() - pointi.getX()) + (pointip1.getY() - pointi.getY());

            // Bestimmung der Länge der Seite zwischen Punkt 1 und Punkt 2:
            double abstand = Math.sqrt((Math.pow((pointip1.getX() - pointi.getX()),2)) + (Math.pow((pointip1.getY() - pointi.getY()),2)));
            double segmentgrenze1 = abstand / 3;
            double segmentgrenze2 = 2 * abstand / 3;

            double neuerPunktX = Math.sqrt(Math.pow(variableX,2));
            double t = (segmentgrenze1 / abstand);
            double s = (segmentgrenze2 / abstand);

            double neuerPunkt1X;
            double neuerPunkt2X;
            double neuerPunkt1Y;
            double neuerPunkt2Y;

            // t und s in Gerade:
            if (pointi.getX() > pointip1.getX()) {
                neuerPunkt1X = Math.abs(pointi.getX() + t * (pointip1.getX() - pointi.getX()));
                neuerPunkt2X = Math.abs(pointi.getX() + s * (pointip1.getX() - pointi.getX()));
            } else {
                neuerPunkt1X = Math.abs(pointi.getX() - t * (pointip1.getX() - pointi.getX()));
                neuerPunkt2X = Math.abs(pointi.getX() - s * (pointip1.getX() - pointi.getX()));
            }

            if (pointi.getY() > pointip1.getY()) {
                neuerPunkt1Y = Math.abs(pointi.getY() + t * (pointip1.getY() - pointi.getY()));
                neuerPunkt2Y = Math.abs(pointi.getY() + s * (pointip1.getY() - pointi.getY()));
            } else {
                neuerPunkt1Y = Math.abs(pointi.getY() - t * (pointip1.getY() - pointi.getY()));
                neuerPunkt2Y = Math.abs(pointi.getY() - s * (pointip1.getY() - pointi.getY()));
            }


            System.out.print("(" + neuerPunkt1X + ", " + neuerPunkt1Y + ")" + "(" + neuerPunkt2X + ", " + neuerPunkt2Y + ")");
        }
        edges = pointsSmooth;
        System.out.print("}");
    }


    public Point[] getEdges() {
        return edges;
    }
}

