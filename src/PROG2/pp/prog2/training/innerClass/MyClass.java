package pp.prog2.training.innerClass;

/**
 * @author Paulina Pyczot
 * @date 05.07.2023
 **/

public class MyClass {
    public class InnerClass {

    }

    private class PrivInnerClass { //man kann nur von MyClass aus drauf zugreifen, weil private

    }

    public PrivInnerClass test() {
        return new PrivInnerClass();
    }
}
