package rl.prog2.tutorium.tutorium230405.tutorium;

public class Train {
    private Locomotive locomotive;

    public Train(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public boolean hasCars() {
        return locomotive.getFirst() != null;
    }

    public void add(int index, Car car) {
        if(index == 0) {
            // Sonderfall: Wir müssen first von der Locomotive anpassen
            Car tmp = locomotive.getFirst(); // Referenz auf den (noch) ersten Wagon
            locomotive.setFirst(car);
            car.setNext(tmp);
        } else {
            // Mit einer Schleife an die richtige Position laufen (ähnlich wie bei
            // getPassengers)
            // Dann die Referenzen "umbiegen"
            // Aufpassen auf die Reihenfolge!
            // Wir müssen aber nur zwei Referenzen umbiegen:
            // 1. Nachfolger von car (also der Neue Wagon)
            // 2. Nachfolger von curr (also die Stelle, wo der Wagon hinzugefügt
            // werden soll)
        }

    }

    public void relink(Train other) {
        // Alle Wägen von other sollen in diesen Zug eingehängt werden
        // (Die Locomotive von other bleibt bestehen)
        // Idee: solange other.hasCars() -> other.removeFirst() und den
        // Wagen an die erste Stelle hinzufügen
    }

    public void revert() {
        // Reihenfolge der Wägen umdrehen
        // Alle Wägen "abhängen" -> Referenz zeigt noch auf den ersten Wagon,
        // aber locomotive.first ist null!
        // Solange es noch Wägen gibt: Den aktullen Wagon an die erste
        // Stelle einfügen
    }

    public int getPassengers() {
        // Idee: jeden Wagon besuchen und
        // die Kapazität auslesen und die Summe
        // bestimmen
        if(hasCars()) {
            int capacity = 0;
            Car current = locomotive.getFirst();
            while (current != null) {
                // Kapazität von current holen
                // und aufsummieren
                current = current.getNext();
            }
            // Version mit einer for-Schleife
            for(Car curr = locomotive.getFirst(); curr != null; curr = curr.getNext()) {
                //capacity += curr.getCapacity(); // getter fehlt noch
            }
            return capacity;

        } else {
            return 0;
        }
    }
}
