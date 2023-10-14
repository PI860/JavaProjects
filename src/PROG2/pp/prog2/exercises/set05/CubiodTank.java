package pp.prog2.exercises.set05;

/**
 * @author Paulina Pyczot
 * @date 17.04.2023
 **/

public class CubiodTank extends SimpleTank{
    private double lenght;
    private double width;
    private double height;

    public CubiodTank(double lenght, double width, double height) {
        this.lenght = lenght;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getSurface() {
        double result = 0;
        result = 2 * (height*width)+ 2 * (height*lenght) + 2 * (width*lenght);
        return result;
    }

    @Override
    public double getVolume() {
        double result = 0;
        result = height * width * lenght;
        return result;
    }

    //Aufgabe 1:
    @Override
    public String toString() {
        return "CubiodTank {" +
                "Lenght: " + lenght +
                ", Width: " + width +
                ", Height: " + height +
                ", Area: " + Math.round(getSurface()) +
                ", Volume: " + Math.round(getVolume()) +
                '}';
    }
}
