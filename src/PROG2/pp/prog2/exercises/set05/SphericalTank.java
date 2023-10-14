package pp.prog2.exercises.set05;

/**
 * @author Paulina Pyczot
 * @date 17.04.2023
 **/

public class SphericalTank extends SimpleTank{
    public double radius;

    public SphericalTank(double radius) {
        this.radius = radius;
    }

    @Override
    public double getSurface() {
        double result = 0;
        result = 4 * Math.PI * radius * radius;
        return result;
    }

    @Override
    public double getVolume() {
        double result = 0;
        result = 4.0 / 3.0 * Math.PI * radius * radius * radius;
        return result;
    }

    //Aufgabe 1:
    @Override
    public String toString() {
        return "SphericalTank {" +
                "Radius: " + radius +
                ", Area: " + Math.round(getSurface()) +
                ", Volume: " + Math.round(getVolume()) +
                '}';
    }
}
