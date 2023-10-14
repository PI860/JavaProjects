package pp.prog2.exercises.set05;

/**
 * @author Paulina Pyczot
 * @date 17.04.2023
 **/

//Aufgabe2:
public interface Tank extends Iterable<Tank>, Cloneable {
    double getSurface();
    double getVolume();
}
