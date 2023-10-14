package pp.prog2.training.genericClass;

/**
 * @author Paulina Pyczot
 * @date 29.03.2023
 * Dokumentation siehe https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 **/
// MyLinkedList und MyLinkedListNode sind Kopien aus Paket linkedList

public class MyLinkedList<T> implements Cloneable{ // T hinzugefügt
    private MyLinkedListNode<T> first; // T hinzugefügt

    public Object get(int idx) {
        MyLinkedListNode<T> curr = first;
        for (int i = 0; i < idx; i++)
            curr = curr.getNext();
        return curr.getItem();
    }

    public boolean add(T element) { // Object durch T ersetzt
        MyLinkedListNode<T> node = new MyLinkedListNode<>(element); // T hinzugefügt
        if (first == null)
            first = node;
        else {
            MyLinkedListNode<T> curr = first;
            while (curr.getNext() != null)
                curr = curr.getNext();
            curr.setNext(node);
        }
        return true;
    }
    public void add(int idx, T element) { // Object durch T ersetzt
        MyLinkedListNode<T> node = new MyLinkedListNode<>(element);
        if (idx == 0) {
            node.setNext(first);
            first = node;
        }
        else {
            MyLinkedListNode<T> curr = first;
            for (int i = 1;i < idx; i++)
                curr = curr.getNext();
            node.setNext(curr.getNext());
            curr.setNext(node);
        }
    }
    public int size() {
        int result = 0;
        for (MyLinkedListNode<T> curr = first; curr != null; curr =  curr.getNext())
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
    public MyLinkedList<T> clone() {
        MyLinkedList<T> result = null;
        try {
            result = (MyLinkedList) super.clone();
            // and now: create a copy of each node
        } catch (CloneNotSupportedException ex) {
            throw new UnsupportedOperationException(ex);
        }
        return result;
    }
    public static void main(String[] args) {
        MyLinkedList<String/*T*/> list = new MyLinkedList<>(); // T ist nur in nicht-statischen Methoden (also nicht in psvm) zu sehen, deshalb gibt's hier eine Fehlermeldung
        System.out.println(list.size());
        list.add("A");
        list.add("B");
        MyLinkedList<String> list2 = list.clone();
        list.add("C");
        System.out.println(list2.size());
        System.out.println(list2.get(1));
    }
}
