package pp.prog2.training.genericClass;

import java.util.*;

/**
 * @author Paulina Pyczot
 * @date 13.04.2023
 **/

public class GenericsTest {

    public static boolean hasEvenSize(Collection<?> collection) {
        return collection.size() % 2 == 0;
    }
    public static int countOccurences(/*List*/Iterable<?> container, Object element) {
        int result = 0;
        for (Object el : container)
            if (el == null ? element == null : el.equals(element))
                result++;
        return 0;
    }
    public static Person findByName(Iterable<? extends Person> persons, String name) { //? extens zum Lesen
        for (Person person : persons) {
            if (person.name.equals(name)) {
                return person;
            }
        }
        return null; //not found
    }

    public static void addPersonWithName (Collection<? super Person> persons, String name) { //? super zum Schreiben
        persons.add(new Person(name));
    }

    public static Object vote (Object x, Object y, Object z) {
        if (x.equals(y)) return y;
        if (y.equals(z)) return z;
        if (z.equals(x)) return x;
        return null;
    }

    public static <T> T chooseByRandom(T obj1, T obj2) {
        return new Random().nextBoolean() ? obj1 : obj2; //quick and dirty Lösung!
    }

    public static void main(String[] args) {
        System.out.println(hasEvenSize(new ArrayList<Integer>()));
        System.out.println(countOccurences(Arrays.asList("A","B","C","A"),"A"));
        List<Object> objects = Arrays.asList(new Object());
        List<Person> persons = Arrays.asList(new Studierender("Anna"));
        List<Studierender> studies = Arrays.asList(new Studierender("Anna",4711));
        System.out.println(findByName(persons,"Anna"));
        System.out.println(findByName(studies, "Anna"));
        addPersonWithName(objects,"Herbert");
        addPersonWithName(persons,"Herbert");
        //addPersonWithName(studies,"Herbert"); // error!
        String result = (String) vote("Grün", "Grün", "SPD");
        Object result1 = vote("Grün", "Grün", new Object());
        String result3 = chooseByRandom("Ja", "Nein");
    }
}
