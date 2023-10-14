package rl.prog2.training.training230406.training;

public class SimpleLinkedList implements Cloneable {
    private SimpleLinkedListNode first;

    public Object get(int idx) {
        SimpleLinkedListNode curr = first;
        for (int i = 0; i < idx; i++)
            curr = curr.getNext();
        return curr.getItem();
    }

    public boolean add(Object element) {
        SimpleLinkedListNode node = new SimpleLinkedListNode(element);
        if (first == null)
            first = node;
        else {
            SimpleLinkedListNode curr = first;
            while (curr.getNext() != null)
                curr = curr.getNext();
            curr.setNext(node);
        }
        return true;
    }

    public void add(int idx, Object element) {
        SimpleLinkedListNode node = new SimpleLinkedListNode(element);
        if (idx == 0) {
            node.setNext(first);
            first = node;
        } else {
            SimpleLinkedListNode curr = first;
            for (int i = 1; i < idx; i++)
                curr = curr.getNext();
            node.setNext(curr.getNext());
            curr.setNext(node);
        }
    }

    public int size() {
        int result = 0;
        for (SimpleLinkedListNode curr = first; curr != null; curr = curr.getNext())
            result++;
        return result;
    }

    public Object remove() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public Object remove(int idx) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public SimpleLinkedList clone() {
        SimpleLinkedList result = null;
        try {
            result = (SimpleLinkedList) super.clone();
            // and now: create a copy of each node, connect them and store them in attribute fist
        } catch (CloneNotSupportedException ex) {
            throw new UnsupportedOperationException(ex);
        }
        return result;
    }

    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();
        System.out.println(list.size());
        list.add("A");
        list.add(0, "B");
        SimpleLinkedList list2 = list.clone();
        list.add("C");
        System.out.println(list2.size());
        System.out.println(list.size());
        System.out.println(list.get(0));
    }
}
