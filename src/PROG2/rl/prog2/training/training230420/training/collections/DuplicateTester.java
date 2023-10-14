package rl.prog2.training.training230420.training.collections;

import java.util.*;

public class DuplicateTester {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("A", "B", "C", "A"));
        System.out.println(containsDuplicate(list)); // true expected
        System.out.println(containsDuplicate(list.subList(0, 3))); // false expected
    }

    public static boolean containsDuplicate(List<String> list) {
        /*
        Set<String> set = new HashSet<>(list);
        return list.size() > set.size();
         */
        Set<String> set = new HashSet<>();
        for (String element : list) {
            if (set.contains(element))
                return true;
            set.add(element);
            /*
            if (!set.add(element))
                return true;
             */
        }
        return false;
    }
}
