package PROG1.klausurvorbereitung;

/**
 * @author Paulina Pyczot
 * @date 29.01.2023
 **/

public class ElementareDatentypen {
    public static void main(String[] args) {
        int mask = 4;
        int flags = 4;
        flags = flags & ~mask;
        System.out.println(flags);
    }
}
