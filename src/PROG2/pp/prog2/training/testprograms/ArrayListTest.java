package pp.prog2.training.testprograms;

import java.util.*;

/**
 * @author Paulina Pyczot
 * @date 22.03.2023
 **/

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> sList;
        //List<String> sList; // ist besser, da man daraus auch ne LinkedList ODER eine ArrayList erstellen kann
        //Collection<String> sList;
        sList = new ArrayList<String>(); //default-Arraylänge: 10, wird dann automatisch vergrößert, wenn mehr Platz benötigt wird
        sList.add("Alpha"); // Index 0
        sList.add("Bravo"); // Index 1
        sList.addAll(Arrays.asList("Charlie","Delta")); //mit addAll mehrere Elemente in Arrayliste einfügen
        System.out.println(sList.indexOf("Bravo")); // 1
        System.out.println(sList.indexOf("Furz")); //falls die Eingabe nicht in der Liste auftaucht, kommt ne -1
        sList.remove("Alpha");
        System.out.println(sList.indexOf("Bravo"));; // 0

        ArrayList<Object> oList = new ArrayList<>();
        // oList = sList;
        //sList = oList;
        oList.clear();
        oList.addAll(sList);
        System.out.println(oList.indexOf("Bravo"));

        String[] sArr = {"A", "B"};
        Object[] oArr = {new Object(), "ABC"};

        oArr = sArr;
        //sArr = oArr; // error
        //oArr[0] = new Object(); //Exception java.lang.Object, ArrayStoreException

        //ArrayList<Integer> iList; // error! Integer needed.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(null);
        //Integer i = list.get(0);
        int i = list.get(0);

        /*
        Iterator<Integer> it = list.iterator();
        // list.remove(1); //Concurrent Modification Exception!
        while (it.hasNext()) {
            int value = it.next();
            System.out.println(value);
            //list.remove(value);
        }

         */
        System.out.println(list);

        /*
        for (int value : list) {
            System.out.println(value);
        }

         */


    }
}
