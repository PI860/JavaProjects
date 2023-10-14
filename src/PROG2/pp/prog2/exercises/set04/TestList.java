package pp.prog2.exercises.set04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Paulina Pyczot
 * @date 10.04.2023
 **/

// Aufgabe 2:
public class TestList {
    public static void main(String[] args) {
        int n = 50000;

        ArrayList<Integer> arrayList= new ArrayList<>();

        System.out.println("Array List: Anfügen von N Elementen an das Ende");
        long startTime = System.nanoTime();
        for(int i = 0; i<n;i++){
            arrayList.add(1);
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        System.out.println("Array List: Einschieben von N Elementen am Anfang");
        startTime = System.nanoTime();
        arrayList= new ArrayList<>();
        for(int i = 0; i<n;i++){
            arrayList.add(0,i);
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        System.out.println("Array List: sequentieller Zugriff auf jedes der n Elemente über den Index");
        startTime = System.nanoTime();
        for(int i = 0; i<n;i++){
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        System.out.println("Array List: sequenzieller Zugriff auf jedes der n Elemente über einen Iterator");
        Iterator<Integer> arrayListIterator = arrayList.iterator();
        startTime = System.nanoTime();
        while(arrayListIterator.hasNext()){
            arrayListIterator.next();
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Linked List: Einschieben von n Elementen am Anfang");
        startTime = System.nanoTime();
        linkedList = new LinkedList<>();
        for(int i = 0; i<n;i++){
            linkedList.add(0,i);
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        System.out.println("Linked List: Einfügen von n Elementen an das Ende");
        startTime = System.nanoTime();
        for(int i = 0; i<n;i++){
            linkedList.add(1);
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        System.out.println("Linked List: sequentieller Zugriff auf jedes der n Elemente über den Index");
        startTime = System.nanoTime();
        for(int i = 0; i<n;i++){
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        System.out.println("Linked List: sequenzieller Zugriff auf jedes der n Elemente über einen Iterator");
        Iterator<Integer> linkedListIterator = linkedList.iterator();
        startTime = System.nanoTime();
        while(linkedListIterator.hasNext()){
            linkedListIterator.next();
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
