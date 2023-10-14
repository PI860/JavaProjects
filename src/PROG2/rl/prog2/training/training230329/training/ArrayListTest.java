package rl.prog2.training.training230329.training;

import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> lList = new LinkedList<>();
        lList.addAll(Arrays.asList("A", "B", "C"));
        System.out.println("Hallo");
        List<String> sList;
        sList = new ArrayList<>();
        sList.add("Alpha");
        sList.add("Bravo");
        sList.addAll(Arrays.asList("Charly", "Delta"));
        sList.remove("Alpha");
        System.out.println(sList.indexOf("Bravo"));

        List<Object> oList = new ArrayList<>();
        //oList = sList; //error (!!) Lists with elements of different type are incompatible
        // sList = oList; error
        oList.clear();
        oList.addAll(sList);
        System.out.println(oList);

        // Arrays behave differently
        String[] sArr = {"A", "B"};
        Object[] oArr = {new Object(), "ABC"};

        oArr = sArr; // elements of sArray and oArr have different class but here ok.
        // sArr = oArr; error
        // oArr[0] = new Object(); // ArrayStoreException!!

        // ArrayList<int> iList; // error! Integer needed.
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(null);
        Integer i = list.get(1);
        // int j = list.get(1); // error!

        list.clear();
        list.add(10);
        list.add(11);
        list.add(12);

        Iterator<Integer> it = list.iterator();
        // list.remove(1); // error (later)!
        while (it.hasNext()) {
            int value = it.next();
            System.out.println(value);
            //list.remove(value);
        }
        //it.remove();
        // it.remove(); // error!
        System.out.println(list);

        for (int value : list)
            System.out.println(value);
    }
}
