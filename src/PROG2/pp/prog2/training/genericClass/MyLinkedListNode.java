package pp.prog2.training.genericClass;

/**
 * @author Paulina Pyczot
 * @date 29.03.2023
 **/

public class MyLinkedListNode<E> { // E hinzugefügt
    private E item; //Object durch E ersetzt
    private MyLinkedListNode<E> next; // hinzugefügt, next ist nun vom Typ E

    //Konstruktoren:
    public MyLinkedListNode(E item) {
        this.item = item;
    } // Object durch E ersetzt

    // Getter und Setter über Code -> Generate:

    public MyLinkedListNode getNext() {
        return next;
    }

    public void setNext(MyLinkedListNode next) {
        this.next = next;
    }

    public E getItem() {
        return null;
    } // Object durch E ersetzt

    public void setItem (E item) { this.item = item; }
}
