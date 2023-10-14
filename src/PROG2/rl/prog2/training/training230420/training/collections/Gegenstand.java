package rl.prog2.training.training230420.training.collections;

public class Gegenstand implements Comparable<Gegenstand> {
    private String beschreibung;
    private double gewicht; // i kg

    public Gegenstand(String beschreibung, double gewicht) {
        this.beschreibung = beschreibung;
        this.gewicht = gewicht;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public double getGewicht() {
        return gewicht;
    }

    @Override
    public int compareTo(Gegenstand other) {
        return beschreibung.compareTo(other.getBeschreibung());
    }

    @Override
    public int hashCode() {
        return 3 * getBeschreibung().hashCode() + 7 * Double.hashCode(getGewicht());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        Gegenstand other = (Gegenstand) obj;
        return getBeschreibung().equals(other.getBeschreibung()) &&
                getGewicht() == other.getGewicht();
    }
}
