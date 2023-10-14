package rl.prog2.training.training230420.training.collections;

public class MyLinkedList<T> implements Cloneable {
    private MyLinkedListNode<T> first;

    public T get(int idx) {
        MyLinkedListNode<T> curr = first;
        for (int i = 0; i < idx; i++)
            curr = curr.getNext();
        return curr.getItem();
    }

    public boolean add(T element) {
        MyLinkedListNode<T> node = new MyLinkedListNode<>(element);
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

    public void add(int idx, T element) {
        MyLinkedListNode<T> node = new MyLinkedListNode<>(element);
        if (idx == 0) {
            node.setNext(first);
            first = node;
        } else {
            MyLinkedListNode<T> curr = first;
            for (int i = 1; i < idx; i++)
                curr = curr.getNext();
            node.setNext(curr.getNext());
            curr.setNext(node);
        }
    }

    public int size() {
        int result = 0;
        for (MyLinkedListNode<T> curr = first; curr != null; curr = curr.getNext())
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
    public MyLinkedList<T> clone() {
        MyLinkedList<T> result = null;
        try {
            result = (MyLinkedList<T>) super.clone();
            // and now: create a copy of each node, connect them and store them in attribute fist
        } catch (CloneNotSupportedException ex) {
            throw new UnsupportedOperationException(ex);
        }
        return result;
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        System.out.println(list.size());
        list.add("A");
        list.add(0, "B");
        MyLinkedList<String> list2 = list.clone();
        list.add("C");
        System.out.println(list2.size());
        System.out.println(list.size());
        System.out.println(list.get(0));
    }
}
