package PROG1.prog1demos;

/**
 * Sagt allen als programmparameter uebergebenen Personen guten Tag.
 */
public class Begruessomat {
    public static void main(String[] args) {
        String[] grusswoerter = {"Hallo", "Moin", "Guten Tag", "Halloechen"};
        int i = 0;
        for (String name : args)
            System.out.println(grusswoerter[i++ % 4] + " " + name + "!");
    }
}
