package PROG1.myprogrammsvorlesung.project22_inheritance;

/**
 * @author Paulina Pyczot
 * @date 15.12.2022
 **/

public class ABTest {

    public static String using(A a) { return "using A";};
    public static String using(B b) { return "using B";};

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        // B b1 = a; ergibt Fehler, da B von A erbt, nicht andersrum
        A a1 = new B(); //vorne: statisch; hinten: dynamisch; bei der Ausführung wird bei "using" dann auf A zugegriffen, nicht auf B!
        System.out.println(a1.m()); // result of B
        System.out.println(using(a));
        System.out.println(using(b));
        System.out.println(using(a1)); // using A
        System.out.println(b.m2());
    }
}
