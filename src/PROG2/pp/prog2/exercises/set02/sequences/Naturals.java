package pp.prog2.exercises.set02.sequences;

/**
 * @author Paulina Pyczot
 * @date 27.03.2023
 **/

// Aufgabe 3:
// Gibt alle natürlichen Zahlen ohne Null bis 10 an:

public class Naturals implements Sequence { // Naturals vom Interfacetyp Sequence
    private int number = 0;
    private int end = 10;

    @Override
    public boolean hasNext() {
        return true;
    }
    @Override
    public Integer nextElement() {
        number++;
        return number;
    }
}
