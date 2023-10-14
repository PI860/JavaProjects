package udemyjavakurs.abschnitt12_oopModifikatoren;

/**
 * @author Paulina Pyczot
 * @date 30.01.2023
 **/

public class Held {
    // Attribute:
    public String name;
    private int lebenspunkte;

     //Konstruktoren:

    public Held(String name, int lebenspunkte) {
        this.name = name;
        this.lebenspunkte = lebenspunkte;
    }

    // Methoden:

    public int getLebenspunkte() {
        return lebenspunkte;
    }

    public void setLebenspunkte(int schaden) {
        this.lebenspunkte -= schaden;
        System.out.println(lebenspunkte);
    }
}
