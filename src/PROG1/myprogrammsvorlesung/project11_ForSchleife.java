package PROG1.myprogrammsvorlesung;

/**
 * @author Paulina Pyczot
 **/

public class project11_ForSchleife {
    public static void main(String[] args) {

        int i, j;

        for (i = 0, j = 100; i < j; i++, j/=2) {
            System.out.println(i + ":" + j);
            if (j < 50) {
                System.out.println("j ist gerade kleiner 50");
                continue;
            }
            System.out.println("j ist noch nicht kleiner 50"); // wird nur solange ausgegeben, bis die if-Anweisung nicht mehr false ist!
        }
        System.out.println();

        for (i = 0, j = 100; i < j; i++, j/=2) {
            System.out.println(i + ":" + j);
            if (!(j < 50)) {
                System.out.println("j ist noch nicht kleiner 50");
            } else {
                System.out.println("j ist gerade kleiner 50");
            }
        }
    }


}
