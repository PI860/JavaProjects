package pp.prog2.training.linkedList;

/**
 * @author Paulina Pyczot
 * @date 29.03.2023
 * Dokumentation siehe https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 **/


public class SimpleLinkedList implements Cloneable{
    private MyLinkedListNode first;

    public Object get(int idx) {
        MyLinkedListNode curr = first;
        for (int i = 0; i < idx; i++)
            curr = curr.getNext();
        return curr.getItem();
    }

    public boolean add(Object element) {
        MyLinkedListNode node = new MyLinkedListNode(element);
        if (first == null)
            first = node;
        else {
            MyLinkedListNode curr = first;
            while (curr.getNext() != null)
                curr = curr.getNext();
            curr.setNext(node);
        }
        return true;
    }
    public void add(int idx, Object element) {
        MyLinkedListNode node = new MyLinkedListNode(element);
        if (idx == 0) {
            node.setNext(first);
            first = node;
        }
        else {
            MyLinkedListNode curr = first;
            for (int i = 1;i < idx; i++)
                curr = curr.getNext();
            node.setNext(curr.getNext());
            curr.setNext(node);
        }
    }
    public int size() {
        int result = 0;
        for (MyLinkedListNode curr = first; curr != null; curr =  curr.getNext())
            result++;

        return result;
    }
    public Object remove() {
        return null;
    }
    public Object remove(int idx) {
        return null;
    }

    @Override
    public SimpleLinkedList clone() {
        SimpleLinkedList result = null;
        try {
            result = (SimpleLinkedList) super.clone();
            // and now: create a copy of each node
        } catch (CloneNotSupportedException ex) {
            throw new UnsupportedOperationException(ex);
        }
        return result;
    }
    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();
        System.out.println(list.size());
        list.add("A");
        list.add("B");
        System.out.println(list.size());
        System.out.println(list.get(1));
    }
}
