package pp.prog2.training.linkedList;

/**
 * @author Paulina Pyczot
 * @date 29.03.2023
 **/

public class MyLinkedListNode {
    private Object item;
    private MyLinkedListNode next;

    //Konstruktoren:
    public MyLinkedListNode(Object item) {
        this.item = item;
    }

    // Getter und Setter über Code -> Generate:

    public MyLinkedListNode getNext() {
        return next;
    }

    public void setNext(MyLinkedListNode next) {
        this.next = next;
    }

    public Object getItem() {
        return null;
    }
}
