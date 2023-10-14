package udemyjavakurs.abschnitt11_oopAssoziation;

/**
 * @author Paulina Pyczot
 * @date 30.01.2023
 **/

public class Auto {
    // Attribute:

    String autoMarke;
    Reifen reifen;

    // Konstruktoren:
    public Auto () {

    }

    public Auto(String autoMarke, String reifenMarke, String reifenTyp) {
        this.autoMarke = autoMarke;
        reifen = new Reifen(reifenMarke, reifenTyp);
    }

    // Methoden:
    public void ausgabeDaten() {
        System.out.println("Automarke: " + this.autoMarke + ", Reifentyp: " + this.reifen.reifenTyp); //immer this dazu!
    }
}
