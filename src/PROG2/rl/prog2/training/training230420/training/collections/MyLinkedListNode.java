package rl.prog2.training.training230420.training.collections;

public class MyLinkedListNode<E> {
    private E item;
    private MyLinkedListNode<E> next;

    public MyLinkedListNode(E item) {
        this.item = item;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public MyLinkedListNode<E> getNext() {
        return next;
    }

    public void setNext(MyLinkedListNode<E> next) {
        this.next = next;
    }
}
