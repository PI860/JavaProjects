package pp.prog2.training.comparable;

/**
 * @author Paulina Pyczot
 * @date 06.04.2023
 **/

public class Gegenstand implements Comparable<Gegenstand> {
    private String beschreibung;
    private double gewicht;

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

    //Code -> Override Methods:
    @Override
    public int hashCode() {
        return 3 * getBeschreibung().hashCode() + 7 * Double.hashCode(getGewicht()); //wrapper Klasse groß Double besser als den int zu casten, da man hier nicht die Nachkommazahlen verliert
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        Gegenstand other = (Gegenstand) obj;
        return getBeschreibung().equals(other.getBeschreibung()) &&
                getGewicht() == other.getGewicht();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
