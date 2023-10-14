package rl.prog2.training.training230330.training;

import java.util.Iterator;

public class SimpleLinkedListIterator implements Iterator<Object> {

    private SimpleLinkedListNode curr;

    public SimpleLinkedListIterator(SimpleLinkedListNode first) {
        curr = first;
    }

    @Override
    public boolean hasNext() {
        return curr != null;
    }

    @Override
    public Object next() {
        Object result = curr.getItem();
        curr = curr.getNext();
        return result;
    }
}
