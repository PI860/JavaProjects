package pp.prog2.training.innerClass;

/**
 * @author Paulina Pyczot
 * @date 05.07.2023
 **/

public class Main {
    public static void main(String[] args) {
        // WICHTIG:
        MyClass obj1 = new MyClass();
        MyClass.InnerClass obj2 = obj1.new InnerClass(); // auf die innere Klasse kann nur über die Instanz der äußeren Klasse "obj1" zugegriffen werden
        //

        obj1.test(); // man kann die Methode "test" hier aufrufen, obwohl PrivInnerClass private ist; aber man kan nden Ausgabetypen dann nicht entgegennehmen -> also gar nicht sinnvoll

        StringBuffer sb = new StringBuffer();
        StringBuilder sBuild = new StringBuilder();
        /*
        Unterschied StringBuffer und StringBuilder:
        Buffer ist Thread-safe, wenn mehrere Threads auf den Buffer zugreifen, ist es sicher
        beim Builder ist es nicht so
         */

    }
}
