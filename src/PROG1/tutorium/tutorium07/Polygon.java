package PROG1.tutorium.tutorium07;

import java.awt.*;

public class Polygon {

    private Point[] vertices;

    // Für Profis: Konstruktor nimmt einen String entgegen, der abwechselnd x- und y-Werte enthält (getrennt durch ;)
    // Beispiel: "0;0;0;2;2;2;2;0"
    // !!! Wird natürlich zur Lösung des Aufgabenblatts nicht benötigt !!!
    public Polygon(String inputString) {
        String[] parts = inputString.split(";");
        vertices = new Point[parts.length/2];
        for(int i = 0; i < vertices.length; i++) {
            vertices[i] = new Point(Integer.parseInt(parts[2*i]), Integer.parseInt(parts[2*i+1]));
        }
    }

    // Koordinaten mit varargs übergeben (Das mit den drei Punkten ...)
    public Polygon(int... coords) {
        vertices = new Point[coords.length/2]; // alle Feldplätze sind danach null
        for(int i = 0; i<vertices.length; i++) {
            vertices[i] = new Point(coords[2*i], coords[2*i+1]); // Passende Werte von coords nehmen, Objekt erstellen und einfügen
        }
    }

    public double calculateArea1() {
        double result = 0;
        for(int i = 0; i < vertices.length; i++) {

            // Wenn i der Index vom letzten Feldplatz ist, ist i plus 1 der erste Index vom Array (also 0)
            // Diese Korrektur findet nachfolgend statt:
            int ip1 = i+1;
            if(ip1 == vertices.length) {
                ip1 = 0;
            }

            Point pointi = vertices[i];         // Point an der Stelle i
            Point pointip1 = vertices[ip1];     // Point an der Stelle i+1
            result += (pointi.getY() + pointip1.getY())*(pointi.getX() - pointip1.getX()); // Formel vom Aufgabenblatt
        }
        return Math.abs(result/2); // Durch 2 teilen und Absolutwert nehmen, da das Ergebnis negativ sein kann...
    }

    /*
    calculateArea1 kann auch viel kompakter implementiert werden:
    Was ist besser lesbar?
     */
    public double calculateArea1Compact() {
        double result = 0;
        for(int i = 0; i < vertices.length; i++) {
            result += (vertices[i].getY() + vertices[i+1 == vertices.length ? 0 : i+1].getY())*
                    (vertices[i].getX() - vertices[i+1 == vertices.length ? 0 : i+1].getX());
        }
        return Math.abs(result/2); // Durch 2 teilen und Absolutwert nehmen, da das Ergebnis negativ sein kann...
    }

    public void smooth() {
        Point[] pointsSmooth = new Point[vertices.length*2]; // vertices darf nicht überschrieben werden!

        //...
        vertices = pointsSmooth;
    }

    public static void main(String[] args) {
        Polygon polygon1 = new Polygon("0;0;0;2;2;2;2;0");
        System.out.println(polygon1.calculateArea1Compact());
    }
}
