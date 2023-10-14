package pp.prog2.training.linkedList;

/**
 * @author Paulina Pyczot
 * @date 29.03.2023
 * Dokumentation siehe https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 **/

/*
public class ExtendedLinkedList implements Cloneable {
    private SimpleLinkedListNode first;
    private SimpleLinkedListNode last;
    private int size;

    public Object get(int idx) {
        SimpleLinkedListNode curr = first;
        if (idx == size -1)
            curr = last;
        else
            for (int i = 0; i < idx; i++)
                curr = curr.getNext();

        return curr.getItem();
    }

    public boolean add(Object element) {
        add(size,element);
        return true;
    }
    public void add(int idx, Object element) {
        SimpleLinkedListNode node = new SimpleLinkedListNode(element);
        if (idx == 0) {
            node.setNext(first);
            first = node;
            if (last == null)
        } else if (idx == size) {

        } else {
            SimpleLinkedListNode curr = first;
            for (int i = 1;i < idx; i++)
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
        return null;
    }
    public Object remove(int idx) {
        return null;
    }

    @Override
    public ExtendedLinkedList clone() {
        ExtendedLinkedList result = null;
        try {
            result = (ExtendedLinkedList) super.clone();
            // and now: create a copy of each node
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
        list.add("B");
        System.out.println(list.size());
        System.out.println(list.get(1));

        for (Object el : list) {
            System.out.println(el);
        }
    }
}
*/