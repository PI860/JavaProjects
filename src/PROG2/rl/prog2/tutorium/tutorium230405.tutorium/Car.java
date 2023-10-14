package rl.prog2.tutorium.tutorium230405.tutorium;

public class Car {
    //  Länge (Meter), Passagierkapazität (Anzahl Personen)
    private Car next;

    public void setNext(Car next) {
        this.next = next;
    }

    public Car getNext() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }
}
