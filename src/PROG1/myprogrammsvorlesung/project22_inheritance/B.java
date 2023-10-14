package PROG1.myprogrammsvorlesung.project22_inheritance;

/**
 * @author Paulina Pyczot
 * @date 15.12.2022
 **/

public class B extends A { // extends würde nicht funktionieren, wenn A als public final definiert wäre
    public B () {
        //super(1);
    }
    @Override
    public String m() { return "Result of B"; }

    public String m2() {
        //return this.m(); // Aufruf von m aus B
        return super.m(); // Aufruf von m aus A
    }

}
