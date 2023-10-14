package pp.prog2.training.linkedList;

import java.util.Iterator;

/**
 * @author Paulina Pyczot
 * @date 30.03.2023
 **/

public class SimpleLinkedListIterator implements Iterator<Object>{

    MyLinkedListNode curr; // wo Curser gerade steht

    public SimpleLinkedListIterator(MyLinkedListNode first) {
        curr = first;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        //Object
        
        return null;
    }
}
