package pp.prog2.exercises.list;

/**
 * @author Paulina Pyczot
 * @date 22.06.2023
 **/

public class Main {
    public static void main(String[] args) {

        BasicList<String> stringBasicList = new BasicList<>();
        stringBasicList.add("a");
        stringBasicList.add("b");
        stringBasicList.add("c");
        System.out.println(stringBasicList.get(1));
    }
}
