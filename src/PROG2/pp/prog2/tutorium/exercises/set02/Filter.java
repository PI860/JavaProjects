package pp.prog2.tutorium.exercises.set02;

/**
 * @author Paulina Pyczot
 * @date 22.03.2023
 **/
/*
//Aufgabe 4:
public abstract class Filter implements Sequence{

    // Wir speichern in den beiden Attributen, ob es ein nächstes Element gibt und wie dieses aussieht:
    private boolean hasNext;
    private int next;
    private Sequence sequence;

    // Diese Implementierung kennen wir noch nicht -> abstract
    public abstract boolean testPassCondition (int element);

    // Über den Konstruktor erhalten wir die Zahlenreihe, die wir filtern sollen:
    public Filter (Sequence sequence) {
        this.sequence = sequence;
        // Wir müssen computeNext einmal aufrufen, damit hasNext udn next initialisiert sind
        // computeNext();
        // geht nicht, da abgeleitete Klasse eventuell noch gar nicht fertig initialisiert ist
        // Wir müssen also computeNext im Konstruktor der abgeleiteten Klasse aufrufen

    }

    @Override
    public boolean hasNext() {
        // return sequence.hasNext(); reicht nicht, da wir schauen müssen, ob es ein nächstes Element gibt, welches zur Filterbedingung passt
        return false;
    }

    @Override
    public int nextElement() {
        int tmp = next;
        computeNext();
        return tmp;
    }

    private void computeNext() {
        // Idee: Bei der sequence so lange mit einer Schleife durchgehen, bis ein Element gefunden wurde, welches zu testPassCondition() passt
        // Wenn es kein Element gibt, bleibt hasNext() bei false
    }
}
*/