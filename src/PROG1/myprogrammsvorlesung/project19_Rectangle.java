package PROG1.myprogrammsvorlesung;

import PROG1.*;

/**
 * @author Paulina Pyczot
 * @date 24.11.2022
 **/

public class project19_Rectangle {

    // Attribute:
    private double left;
    private double bottom;
    private double width; // private final = falls die Rechtecke später nicht geändert werden sollen, kann man final setzen
    private double height;

    // Konstruktoren:
    // automatisches Erzeugen von Konstruktoren: Code->Generate->Construktor (oder Getter-/Setter-Methode)
    public project19_Rectangle(double left, double bottom, double width, double height) {
        this.left = left;
        this.bottom = bottom;
        this.width = width;
        this.height = height;
    }

    // Methoden:
    // automatisches Erzeugen von Konstruktoren: Code->Generate->Construktor (oder Getter-/Setter-Methode)

    // Getter:
    public double getLeft() {
        return left;
    }

    public double getBottom() {
        return bottom;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // Setter:
    public void setLeft(double left) {
        this.left = left;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isDisjoint(project19_Rectangle r) {
        boolean rAbove = r.getBottom() >= /*this.*/getTop(); // wenn die untere y-Koordinate vom 2. Rechteck größer gleich der größeren y-Koordinate des 1. Rechtecks ist
        boolean ronTheLeft = r.getRight() <= getLeft();
        boolean rBelow = r.getTop() <= getBottom();
        boolean rOnTheRight = r.getLeft() >= getRight();
        return rAbove || ronTheLeft || rBelow || rOnTheRight;
    }

    public double getTop() {
        return bottom + height; // y-Koordinate von Rectangle + die Höhe des Rectangle = neuer y-Wert
    }

    public double getRight() {
        return left + width;
    }

    public String toString() {
        return "Rectangle(" + left + ", " + bottom + ", " + width + ", " + height + ")";
    }
}
