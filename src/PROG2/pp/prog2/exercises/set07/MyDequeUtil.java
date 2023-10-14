package pp.prog2.exercises.set07;

/**
 * @author Paulina Pyczot
 * @date 01.05.2023
 **/

// Aufgabe 2:
public class MyDequeUtil {

    public static <T> MyDeque<T> merge(MyDeque<T> o1, MyDeque<T> o2){
        int resultCapacity = o1.capacity() + o2.capacity();
        MyDeque<T> result = new MyDeque(resultCapacity);
        for (int i = 0; i< o1.size();i++){
            result.addLast(o1.get(i));
        }
        for (int i = 0; i< o2.size();i++){
            result.addLast(o2.get(i));
        }
        return result;
    }
    public static <T extends Comparable<? super T>> MyDeque<T> selectLess(MyDeque<T> deque, T compareElement){
        MyDeque<T> result = new MyDeque(deque.capacity());
        for (int i = 0; i< deque.size();i++){
            if(deque.get(i).compareTo(compareElement) < 0){
                result.addLast(deque.get(i));
            }
        }
        return result;
    }

    private MyDequeUtil() {
    }
}
