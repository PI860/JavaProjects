package pp.prog2.exercises.set04;

/**
 * @author Paulina Pyczot
 * @date 10.04.2023
 **/

// Aufgabe 1:

public class Locomotive {
    private int length;
    private int type;
    private String name;
    private Car first;

    public Locomotive(int length, int type, String name) {
        this.length = length;
        this.type = type;
        this.name =name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getFirst() {
        return first;
    }

    public void setFirst(Car first) {
        this.first = first;
    }


}
