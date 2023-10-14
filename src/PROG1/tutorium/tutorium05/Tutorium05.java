package PROG1.tutorium.tutorium05;

/**
 * @author Paulina Pyczot
 **/

public class Tutorium05 {
    public static void main(String[] args) {

        // Aufgabe 1:
        System.out.println(7 % 3);
        System.out.println(7 / -3);
        System.out.println(-7 / 3);

        double a = 1.4322432;
        double b = 1.333;

        System.out.println();
        System.out.printf("Das ist der Wert von a: %.2f Das ist der" + "Wert von b: %.3f", a, b); // es gibt %s %d %f %t %B %b, mal anschauen... printf ist ein formatierter Wert .2 steht für Anzahl der Nachkommastellen
        // Linksbündigkeit mit Minus und Rechtsbündigkeit nachschauen

        // Aufgabe 2:
        // Man braucht nur deshalb ein Array, da man die Zahlen alle nochmal ausgeben muss

        // Aufgabe 3:

    }

    // Aufgabe 3:
    /**
     * Vektoren können gut mit Hilfe von Arrays dargestellt werden
     */

    public static double[] mult (double[] vec, double factor) {
        double[] result = new double[vec.length]; // neuer Vektor mit derselben Länge wie vec wird angelegt, damit wir die Werte von vec in der for-Schleife nicht überschreiben

        for (int i = 0; i < vec.length; i++) {
            result[i] = vec[i] * factor;
        }
        return result; // Rückgabe ist für Aufgabe 4 wichtig, Ausgabe bringt nicht so viel

    }
    // pro Operation immer eine neue Methode
    // bei Minus und Plus Fehlermeldung ausgeben, wenn die Arrays = Vektoren nicht dieselbe Länge/Größe haben

    public static double[] rotate2d (double[] vec4, int deg) {
    // bei Drehvektor aufpassen mit Winkel, der muss ins Bogenmaß umgerechnet werden
    // Zahl Pi = Math.PI;
        return null;
    }

    public static void molehilSimulation () {
        double[] nextPos = {1,0}; // Aktuelle Haufenposition laut Aufgabenstellung
        double[] prevPos = {0,0}; // Startposition laut Aufgabenstellung

        // Neue Position vorhersagen:
    }


    public static double computeNextmolehil (double[] nextPos, double[] prevPos) {
        /*
            Pseudocode:
            -> Pseudocode = nicht in einer bestimmten Programmiersprache geschrieben, sondern so, dass es jeder versteht (ohne Syntax, Semantik), um zu verstehen, wie der Algorithmus funktioniert
            movement = nextPos - prevPos
            result = rotate2d (movement, 5) -> Richtung bestimmen, dann um 5° drehen
            result = mult (result, 0.99) -> nach dem Gang und der Drehung verringert sich die Geschwindigkeit des Maulwurfs um 0.01 (1%), deshalb 0.99
            result = movement + posCurr
            return result
         */
        return 0;
        // Ausgabe am Ende: ganz viele Werte nacheinander 2,0 0,1; 3,0 0,3; 3,9 0,5; 4,8 0,8; (Werte für nextPos {0,1}, nicht {1,0})
    }
}
