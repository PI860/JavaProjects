package PROG1.tutorium.tutorium04;

import PROG1.Terminal;

/**
 * @author Paulina Pyczot
 **/

public class TestZahlUmdrehen {
    public static void main(String[] args) {
        // TODO zahl umdrehen: 123 -> 321
        int number = Terminal.readInt("Provide number");
        int numberReverted = 0;
        while (number > 0) {
            numberReverted = numberReverted * 10 + (number % 10);
            number = number / 10;
        }
        System.out.println(numberReverted);
    }
}
