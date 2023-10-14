package pp.prog2.exercises.list;

/**
 * @author Paulina Pyczot
 * @date 22.06.2023
 **/

public class BasicList<TYPE> {

    private Node first;
    public void add(TYPE e) {
        if (first == null)
            first = new Node(e);
        Node n = first;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new Node(e);
    }


    public TYPE get(int i) {
        if (first == null) return null;
        Node n = first;
        for (int j = 0; j <= i; j++) {
            if (n.next != null) {
                n = n.next;
            } else {
                return null;
            }
        }

        return n.element;
    }


    private class Node {
        TYPE element;
        Node next;


        public Node(TYPE element) {
            this.element = element;
        }
    }
}
