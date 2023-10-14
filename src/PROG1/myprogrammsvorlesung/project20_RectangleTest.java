package PROG1.myprogrammsvorlesung;

/**
 * @author Paulina Pyczot
 * @date 24.11.2022
 **/

public class project20_RectangleTest {
    public static void main(String[] args) {
        project19_Rectangle r1 = new project19_Rectangle(0,0,2,2);
        project19_Rectangle r2 = new project19_Rectangle(1,1,2,2);
        project19_Rectangle r3 = new project19_Rectangle(0,4,2,2);
        project19_Rectangle r4 = new project19_Rectangle(-2,0,2,2);
        project19_Rectangle r5 = new project19_Rectangle(-1,-1,4,4);
        System.out.println(r1.isDisjoint(r2) + " = false");
        System.out.println(r1.isDisjoint(r3) + " = true");
        System.out.println(r1.isDisjoint(r4) + " = true");
        System.out.println(r1.isDisjoint(r5) + " = false");
        System.out.println(r5.isDisjoint(r1) + " = false");
    }
}
