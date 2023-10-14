package PROG1.myprogrammsvorlesung;

/**
 * @author Paulina Pyczot
 **/

public class project8_Array {
    public static void main(String[] args) {
        testArray();
    }

    public static void testArray () {
    int[] numbers = new int[42];
    numbers[7] = 42;
    //double[] velocities = new double[8*4];
    // boolean[] flags = new boolean [getSizeForMyFlagArray()];
    //char[] name;
    //name = new char[7];

        System.out.println(numbers[7]);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

}
