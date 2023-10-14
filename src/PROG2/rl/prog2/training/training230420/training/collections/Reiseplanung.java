package rl.prog2.training.training230420.training.collections;

import java.util.*;

public class Reiseplanung {

    public static int binarySearch(List<Gegenstand> list, Gegenstand el) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int compResult = el.compareTo(list.get(mid));
            if (compResult < 0)
                right = mid - 1;
            else if (compResult > 0)
                left = mid + 1;
            else if (!el.equals(list.get(mid)))
                throw new IllegalStateException("Order not total!");
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Gegenstand> ausruestung = new ArrayList<>();
        ausruestung.add(new Gegenstand("Zahnbürste", 0.2));
        ausruestung.add(new Gegenstand("Fahrad", 9.99));
        ausruestung.add(new Gegenstand("fahrad", 9.99));
        ausruestung.add(new Gegenstand("Sonnencreme", 0.5));

        Collections.sort(ausruestung);
        //Collections.sort(ausruestung, new WeightComparator());

        for (Gegenstand g : ausruestung)
            System.out.println(g.getBeschreibung());
        System.out.println();

        int pos = binarySearch(ausruestung, new Gegenstand("Zahnbürste", 0.2));
        System.out.println(pos); // 2


        //Set<Gegenstand> set = new TreeSet<>(new WeightComparator());
        Set<Gegenstand> set = new TreeSet<>(ausruestung);
        set.addAll(ausruestung);
        for (Gegenstand g : set)
            System.out.println(g.getBeschreibung());
    }

    static class WeightComparator implements Comparator<Gegenstand> {
        @Override
        public int compare(Gegenstand g1, Gegenstand g2) {
            return -Double.compare(g1.getGewicht(), g2.getGewicht());
        }
    }
}
