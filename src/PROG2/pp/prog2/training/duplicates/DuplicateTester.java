package pp.prog2.training.duplicates;


import java.util.*;

/**
 * @author Paulina Pyczot
 * @date 05.04.2023
 **/

public class DuplicateTester {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("A","B","C","A"));
        System.out.println(containsDuplicate(list));
        System.out.println(containsDuplicate(list.subList(0,3)));
    }

    public static boolean containsDuplicate(List<String> list) {
        /*
        // Variante 1:
        Set<String> set = new HashSet<>(list);
        return list.size() > set.size();
        */

        //List<String> duplicates = new HashSet<>();
        Set<String> set = new HashSet<>(list);

        for (String element : list) {
            //Variante 2:
            /*
            if (set.contains(element))
                 return true;
            set.add(element);
             */
            // Variante 3 (kürzeste:)
            if (!set.add(element))
                return true;
        }
        return false;
    }
}
