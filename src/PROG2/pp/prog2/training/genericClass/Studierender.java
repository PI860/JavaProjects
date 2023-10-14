package pp.prog2.training.genericClass;

/**
 * @author Paulina Pyczot
 * @date 19.04.2023
 **/

public class Studierender extends Person{

    //Konstruktor muss rein, weil in der Klasse Person ein Konstruktor namens "name" erstellt worden ist!
    public Studierender(String name) {
        super(name);
    }

    public Studierender(String name, int matrikelnummer) {
        super(name);
    }
}
