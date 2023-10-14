package pp.prog2.exercises.set02.sequences;

/**
 * @author Paulina Pyczot
 * @date 27.03.2023
 **/

// Aufgabe 4:

public abstract class Filter implements Sequence {
    protected Sequence sequence;
    Integer element;
    public abstract boolean testPassCondition(int element);
    public Filter(Sequence sequence){
        this.sequence = sequence;
    }

    @Override
    public boolean hasNext() {
        return sequence.hasNext();
    }

    @Override
    public Integer nextElement() {
        if (sequence.hasNext()) {
            element = sequence.nextElement();
            if (element != null) {
                if (testPassCondition(element)) {
                    return element;
                }else {
                    return null;
                }
            }else {
                return null;
            }

        } else {
            return null;
        }
    }

}
