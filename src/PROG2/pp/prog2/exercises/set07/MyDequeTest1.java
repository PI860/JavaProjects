package pp.prog2.exercises.set07;

import java.util.Iterator;

/**
 * @author Paulina Pyczot
 * @date 01.05.2023
 **/

// Aufgabe 4:
public class MyDequeTest1 {
    public static void main(String[] args) {
        MyDeque<Integer> deque = new MyDeque<Integer>(10);
        for (int i = 0; i <3; i++){
            deque.addFirst(i);
        }
        System.out.printf("%-30s", "Add 3. first:");
        System.out.println(deque.toString());
        for (int i = 3; i <6; i++){
            deque.addLast(i);
        }
        System.out.printf("%-30s", "Add 3. last:");
        System.out.println(deque.toString());
        for (int i = 0; i <2; i++){
            deque.removeFirst();
        }
        System.out.printf("%-30s", "Remove 2. first:");
        System.out.println(deque.toString());
        while (!deque.isEmpty()){
            deque.removeFirst();
        }
        System.out.printf("%-30s", "Remove until empty:");
        System.out.println(deque.toString());
        for (int i = 0; i <8; i++){
            deque.addLast(i);
        }
        System.out.printf("%-30s", "Add 8. last:");
        System.out.println(deque.toString());
        System.out.printf("%-30s", "Merge deques:");
        System.out.println(MyDequeUtil.merge(deque,deque));
        System.out.printf("%-30s", "Split deque:");
        System.out.println(MyDequeUtil.selectLess(deque,5));
        System.out.printf("%-30s", "Iterate deque:");
        Iterator<Integer> iterator = deque.iterator();
        for (int elem : deque)
            System.out.print(elem + ", ");
    }
}
