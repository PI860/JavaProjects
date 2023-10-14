package rl.prog2.training.training230420.training.generics;

import java.util.*;

public class GenericsTest {

    public static boolean hasEvenSize(Collection<? extends Number> collection) {
        return collection.size() % 2 == 0;
    }

    public static int countOccurrences(Iterable<?> container, Object element) {
        int result = 0;
        for (Object el : container)
            if (Objects.equals(el, element))
                result++;
        return result;
    }

    public static Person findByName(Iterable<? extends Person> persons, String name) {
        for (Person person : persons)
            if (person.name.equals(name))
                return person;
        return null; // not found
    }

    public static void addPersonWithName(Collection<? super Person> persons, String name) {
        persons.add(new Person(name));
    }


    public static Object vote1(Object x, Object y, Object z) {
        if (x.equals(y)) return x;
        if (y.equals(z)) return z;
        if (z.equals(x)) return x;
        return null;
    }

    public static <T> T vote(T x, T y, T z) {
        if (x.equals(y)) return x;
        if (y.equals(z)) return z;
        if (z.equals(x)) return x;
        return null;
    }

    public static <T> T chooseByRandom(T obj1, T obj2) {
        return new Random().nextBoolean() ? obj1 : obj2; // quick and dirty!
    }


    static class SortedList<T extends Comparable<? super T>> extends ArrayList<T> {

    }




    public static void main(String[] args) {
        System.out.println(hasEvenSize(new ArrayList<Integer>()));
        System.out.println(countOccurrences
                (Arrays.asList("A", "B", "C", "A"), "A"));
        List<Object> objects = new ArrayList<>(List.of(new Object()));
        List<Person> persons = new ArrayList<>(List.of(new Person("Anna")));
        List<Studierender> studies = new ArrayList<>(List.of(new Studierender("Anna", 4711)));
        // findByName(objects, "Anna"); // error!
        System.out.println(findByName(persons, "Anna"));
        System.out.println(findByName(studies, "Anna"));
        addPersonWithName(objects, "Herbert");
        addPersonWithName(persons, "Herbert");
        // addPersonWithName(studies, "Herbert"); // error!
        String result = vote("Grün", "Grün", "SPD");
        Object result1 = vote("Grün", "Grün", new Object());
        String result2 = (String) vote1("Grün", "Grün", "SPD");
        String result3 = chooseByRandom("Ja", "Nein");
        SortedList<Person> p1;
        SortedList<Studierender> s1;
    }
}
