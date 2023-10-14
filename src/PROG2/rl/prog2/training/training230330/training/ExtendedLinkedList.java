package rl.prog2.training.training230330.training;

import java.util.Iterator;

public class ExtendedLinkedList implements Cloneable, Iterable<Object> {
    private SimpleLinkedListNode first;
    private SimpleLinkedListNode last;
    private int size;

    public Object get(int idx) {
        SimpleLinkedListNode curr = first;
        if (idx == size - 1)
            curr = last;
        else
            for (int i = 0; i < idx; i++)
                curr = curr.getNext();
        return curr.getItem();
    }

    public boolean add(Object element) {
        add(size, element);
        return true;
    }

    public void add(int idx, Object element) {
        SimpleLinkedListNode node = new SimpleLinkedListNode(element);
        if (idx == 0) {
            node.setNext(first);
            first = node;
            if (size == 0)
                last = node;
        } else if (idx == size) {
            last.setNext(node);
            last = node;
        } else {
            SimpleLinkedListNode curr = first;
            for (int i = 1; i < idx; i++)
                curr = curr.getNext();
            node.setNext(curr.getNext());
            curr.setNext(node);
        }
        size++;
    }

    public int size() {
        return size;
    }

    public Object remove() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public Object remove(int idx) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public ExtendedLinkedList clone() {
        ExtendedLinkedList result = null;
        try {
            result = (ExtendedLinkedList) super.clone();
            // and now: create a copy of each node, connect them and store them in attribute fist
        } catch (CloneNotSupportedException ex) {
            throw new UnsupportedOperationException(ex);
        }
        return result;
    }

    @Override
    public Iterator<Object> iterator() {
        return new SimpleLinkedListIterator(first);
    }


    public static void main(String[] args) {
        ExtendedLinkedList list = new ExtendedLinkedList();
        System.out.println(list.size());
        list.add("A");
        list.add(0, "B");
        ExtendedLinkedList list2 = list.clone(); // vorsicht,flache Kopie
        list.add("C");
        System.out.println(list2.size());
        System.out.println(list.size());
        System.out.println(list.get(0));

        for (Object el : list)
            System.out.println(el);

    }


}
