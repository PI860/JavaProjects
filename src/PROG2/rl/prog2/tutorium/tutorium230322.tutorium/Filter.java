package rl.prog2.tutorium.tutorium230322.tutorium;

public abstract class Filter implements Sequence {

    // Wir speichern in den beiden Attributen ab,
    // ob es ein nächstes Element gibt und wie dieses aussieht
    private boolean hasNext;
    private int next;
    private Sequence sequence;

    // Diese Implementierung kennen wir noch nicht -> abstract
    public abstract boolean testPassCondition(int element);

    // Über den Konstruktor erhalten wir die Zahlenreihe,
    // die wir filtern sollen
    public Filter(Sequence sequence) {
        this.sequence = sequence;
        // Wir müssen computeNext einmal aufrufen, damit
        // hasNext und next initialisiert sind.
        // computeNext();
        // geht nicht, da die abgeleitete Klasse eventuell
        // noch gar nicht "fertig" initialisiert ist.
        // Wir müssen also computeNext im Konstruktor
        // von der abgeleitete Klasse aufrufen!
    }

    @Override
    public boolean hasNext() {
        // reicht das: return sequence.hasNext(); ??????
        // NEIN, wir müssen schauen, ob es ein nächstes Element
        // gibt, welches zur Filterbedingung passt!
        return hasNext;
    }

    @Override
    public int nextElement() {
        int tmp = next;
        computeNext();
        return tmp;
    }

    private void computeNext() {
        /**
         * Idee: Bei der sequence solange mit einer Schleife
         * durchgehen, bis ein Element gefunden wurde,
         * was zu testPassCondition() passt.
         * Wenn es kein Element gibt, bleibt hasNext() bei
         * false.
         */
    }
}
