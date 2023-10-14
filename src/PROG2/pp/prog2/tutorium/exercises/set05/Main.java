package pp.prog2.tutorium.exercises.set05;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Paulina Pyczot
 * @date 12.04.2023
 **/

public class Main {
    public static void main(String[] args) {
        // Für die einfachen Tanks brauchen wir einen Iterator, der bei hasNext() sofort false zurückliefert
        List<Tank> list = Collections.emptyList(); // so liefert der Iterator automatisch false, dazu ist die emptyList gut
        // return list.iterator(); // Dieser Iterator wird bei hasNext() sofort false zurückgeben (das wollen wir so haben)

        // Löschen aus Liste mit Hilfe eines Iterators:
        List<Integer> simpleList = new LinkedList<>();
        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);
        Iterator<Integer> iter = simpleList.iterator();
        iter.next(); // Um etwas löschen zu können, muss man erstmal zu dem ersten Element gehen, sonst gibt's ne IllegalStateException
        iter.remove(); // Jetzt kann das Element gelöscht werden
        System.out.println(simpleList);
    }
}
