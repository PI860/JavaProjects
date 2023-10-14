package pp.prog2.exercises.set08;

import java.util.Iterator;

/**
 * @author Paulina Pyczot
 * @date 08.05.2023
 **/

// Aufgabe 1:
public class MyDequeSet08<T>implements Iterable<T>{
    private int first = 0;
    private int last;
    private int size= 0;
    private int capacity;
    private T[] elements;


    public MyDequeSet08(int capacity){
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
        last = capacity-1;
    }

    public void addFirst(T element){
        first = (first-1 + capacity)%capacity;
        elements[first] = element;
        size++;
    }

    public void addLast(T element){
        last = (last+1)%capacity;
        elements[last] = element;
        size++;
    }

    public T get(int index){
        return elements[(first +index) %capacity];
    }

    public T getFirst(){
        return elements[first];
    }

    public T getLast(){
        return elements[last];
    }

    public T removeFirst(){
        T result = elements[first];
        elements[first] = null;
        first = ((first +1) %capacity);
        size--;
        return result;
    }

    public T removeLast(){
        T result = elements[last];
        elements[last] = null;
        last = (last-1+capacity) %capacity;
        size--;
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == capacity-1;
    }

    public int size(){
        return size;
    }

    public int capacity(){
        return capacity;
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for(int i = 0; i< size;i++){
            result.append(get(i) + " ");
        }
        result.append("]");
        return result.toString();
    }
    public Iterator<T> iterator(){
        return  new MyDequeIterator<T>();
    }

    class MyDequeIterator<T> implements Iterator<T> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            if(position >= size){
                return false;
            }
            else{
                return true;
            }
        }

        @Override
        public T next() {
            T result = (T) get(position);
            position++;
            return result;
        }
    }
}
