package PROG1.abgaben.uebungsblatt7.pp.prog1.exercises.set07;

/**
 * @author Paulina Pyczot
 * @date 20.11.2022
 **/

public class PolygonTest {
    public static void main(String[] args) {

        Polygon polygon1 = new Polygon(0, 0, 9, 0, 9, 9, 0, 9);
        System.out.print("Polygon: ");
        polygon1.toString();
        System.out.println();
        System.out.println("Area1: " + polygon1.calculateArea1());
        System.out.println("Area2: " + polygon1.calculateArea2());
        System.out.print("Smooth: ");
        polygon1.smooth();
        System.out.println();
        polygon1 = new Polygon(-1, 0, 0, 0, 0, 1, -1, 1);
        System.out.print("Polygon: ");
        polygon1.toString();
        System.out.println();
        System.out.println("Area1: " + polygon1.calculateArea1());
        System.out.println("Area2: " + polygon1.calculateArea2());
        polygon1 = new Polygon(-6, 1, 6, 1, 0, 3);
        System.out.print("Polygon: ");
        polygon1.toString();
        System.out.println();
        System.out.println("Area1: " + polygon1.calculateArea1());
        System.out.println("Area2: " + polygon1.calculateArea2());
        polygon1 = new Polygon(-18,20,45,17,20,22,21,45,212,12,14,19);
        System.out.print("Polygon: ");
        polygon1.toString();
        System.out.println();
        System.out.println("Area1: " + polygon1.calculateArea1());
        System.out.println("Area2: " + polygon1.calculateArea2());
    }
}
