package pp.prog2.exercises.set02.sequences;

/**
 * @author Paulina Pyczot
 * @date 27.03.2023
 **/

// Aufgabe 3:
// Gibt natürliche Zahlen innerhalb eines bestimmten Intervalls an:

public class Range implements Sequence {
    private int number;
    private int end;

    public Range(int start,int end){
        this.number = start-1;
        this.end = end-1;
    }

    @Override
    public boolean hasNext() {
        if(number<=end){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Integer nextElement() {
        number++;
        return number;
    }
}
