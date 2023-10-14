package rl.prog2.tutorium.tutorium230405.tutorium;

import java.util.*;

public class Listen {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        List list3 = new ArrayList();
        list3.add(10);
        list3.add("Test");
        list3.add(new Car());

        Object s = list3.get(1);

        long start = System.currentTimeMillis();
        for(int i = 0; i < 50000; i++) {
            list1.add(0,i);
        }
        // Dauer in ms
        long duration = System.currentTimeMillis() - start;

        // Aufgabe: Alle Elemente von list1 mit dem Iterator
        // besuchen:
        for (int i : list1 ) {

        }
        // oder
        Iterator<Integer> iter = list1.iterator();
        while (iter.hasNext()) {
            iter.next();
        }

        Integer integerObject = 10;
        int zahl = integerObject;
    }
}
