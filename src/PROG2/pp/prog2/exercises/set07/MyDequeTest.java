package pp.prog2.exercises.set07;

import java.util.Iterator;

/**
 * @author Paulina Pyczot
 * @date 01.05.2023
 **/

// Aufgabe 4:
public class MyDequeTest {
    public static void main(String[] args) {
        MyDeque<Integer> deque = new MyDeque<Integer>(10);
        for (int i = 0; i <3; i++){
            deque.addFirst(i);
        }

        System.out.println(deque.toString());
        for (int i = 3; i <6; i++){
            deque.addLast(i);
        }
        System.out.println(deque.toString());
        for (int i = 0; i <2; i++){
            deque.removeFirst();
        }
        System.out.println(deque.toString());
        while (!deque.isEmpty()){
            deque.removeFirst();
        }
        System.out.println(deque.toString());
        for (int i = 0; i <8; i++){
            deque.addLast(i);
        }
        System.out.println(deque.toString());
        System.out.println(MyDequeUtil.merge(deque,deque));
        System.out.println(MyDequeUtil.selectLess(deque,5));
        Iterator<Integer> iterator = deque.iterator();
        for (int elem : deque)
            System.out.print(elem + ", ");
    }
}
