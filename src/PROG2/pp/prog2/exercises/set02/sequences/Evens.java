package pp.prog2.exercises.set02.sequences;

/**
 * @author Paulina Pyczot
 * @date 27.03.2023
 **/

// Aufgabe 5:
// Gibt alle geraden Zahlen aus bestimmter Zahlenfolge an:

public class Evens extends Filter {


    public Evens(Sequence sequence) {
        super(sequence);
    }

    @Override
    public boolean testPassCondition(int element) {
        if (element%2 ==0){
            return true;
        }else {
            return false;
        }
    }
}
