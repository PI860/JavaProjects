package rl.prog2.training.training230330.training;

public class SimpleLinkedListNode {
    private Object item;
    private SimpleLinkedListNode next;

    public SimpleLinkedListNode(Object item) {
        this.item = item;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public SimpleLinkedListNode getNext() {
        return next;
    }

    public void setNext(SimpleLinkedListNode next) {
        this.next = next;
    }
}
