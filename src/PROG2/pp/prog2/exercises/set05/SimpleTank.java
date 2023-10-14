package pp.prog2.exercises.set05;

import java.util.Collections;
import java.util.Iterator;

/**
 * @author Paulina Pyczot
 * @date 17.04.2023
 **/

public abstract class SimpleTank implements Tank {
    @Override
    public Iterator<Tank> iterator() {
        return Collections.emptyIterator();
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
