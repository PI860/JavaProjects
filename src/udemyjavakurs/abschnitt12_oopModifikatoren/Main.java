package udemyjavakurs.abschnitt12_oopModifikatoren;

/**
 * @author Paulina Pyczot
 * @date 30.01.2023
 **/

public class Main {
    public static void main(String[] args) {
        Held player1 = new Held("Otto", 4);

        Held player2 = new Held("Paula", 5);

        player1.getLebenspunkte();

        player1.setLebenspunkte(45);
        byte b = 0b1111111;
        b++;
        System.out.println(b);

        String s = 123 + " €" + 1.2f + '-';
        System.out.println(s);

        float f = (float) (4.0 / 6.0 * 2);
        System.out.println(f);
    }
}
