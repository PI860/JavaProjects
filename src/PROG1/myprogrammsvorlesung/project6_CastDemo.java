package PROG1.myprogrammsvorlesung;

/**
 * @author Paulina Pyczot
 **/

public class project6_CastDemo {
    public static void main(String[] args) {
        int i = 222;

        // Umwandlung von Dez nach Hex:
        String hex = Integer.toHexString(i);
        System.out.println("Dez: " + i);

        System.out.println("Hex: 0x" + hex);
        char c = (char) i; // Ausgabe von Char wird in UTF-8
        System.out.println("UTF-8 Char: " + c);

        System.out.println();

        String hex2 = "de"; //unbedingt in " und nicht in '
        System.out.println("Hex: " + hex2);

        // Umwandlung von Hex nach Dez:
        Integer in = Integer.parseInt(hex2, 16); // parse = analysieren; parseInt (String s, int radix) mit String s = Ziffernfolge in einem bestimmten Quellsystem und int radix Vorgabe für den Compiler, welches Quellsystem es ist; Ausgabe immer in Dez
        System.out.println("Dez: " + in);
        int newIn = in; // wenn man in nicht explizit als int definiert, kommt Fehlermeldung, dass man den String nicht als Integer (großes I) darstellen kann
        char d = (char) newIn;
        System.out.println("UTF-8 Char: " + d);
    }
}
