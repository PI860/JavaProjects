package pp.prog2.exercises.set05;

/**
 * @author Paulina Pyczot
 * @date 17.04.2023
 **/

public class CylindricalTank extends SimpleTank{
    private double radius;
    private double height;

    public CylindricalTank(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getSurface() {
        double result = 0;
        result = Math.PI * radius * radius;
        return result;
    }

    @Override
    public double getVolume() {
        double result = 0;
        result = Math.round(2 * Math.PI * radius * (radius+height));
        return result;
    }

    //Aufgabe 1:
    @Override
    public String toString() {
        return "CylindricalTank {" +
                "Radius: " + radius +
                ", Height: " + height +
                ", Area: " + Math.round(getSurface()) +
                ", Volume: " + Math.round(getVolume()) +
                '}';
    }
}
