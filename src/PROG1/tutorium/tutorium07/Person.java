package PROG1.tutorium.tutorium07;

public class Person {
    private String name;
    private String geburtsdatum;

    private int plz;

    public Person(String name, String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
        this.name = name;
    }

    @Override  //  String-Repräsentation des aktuellen Objekts erstellen.
    public String toString() {
        return "Name=" + name + ", Geburtsdatum="+geburtsdatum;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public String getName() {
        return name;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public int getPlz() {
        return plz;
    }
}
