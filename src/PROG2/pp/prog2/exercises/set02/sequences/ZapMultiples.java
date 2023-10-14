package pp.prog2.exercises.set02.sequences;

/**
 * @author Paulina Pyczot
 * @date 27.03.2023
 **/

// Aufgabe 5:
// Gibt alle Zahlen einer Zahlenfolge aus, die kein Vielfaches von zapNumber sind:

public class ZapMultiples extends Filter {
    public int zapNumber;

    public ZapMultiples(Sequence sequence, int zapNumber) {
        super(sequence);
        this.zapNumber = zapNumber;

    }

    @Override
    public boolean testPassCondition(int element) {
        if (element % zapNumber != 0){
            return true;
        }
        else{
            return false;
        }
    }
}
