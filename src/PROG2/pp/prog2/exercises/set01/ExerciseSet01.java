package pp.prog2.exercises.set01;

import java.util.Scanner;

/**
 * @author Paulina Pyczot
 * @date 19.03.2023
 **/

public class ExerciseSet01 {
    public char x = 'X';
    public char o = 'O';


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        generateRack(7,6 );
    }

    public static void generateRack (int column, int row) {
        int array[][] = new int[column][row];

        System.out.println("00 " + "01 " + "02 " + "03 " + "04 " + "05 " + "06 ");
        System.out.println("--------------------");
        for (int i = 0; column > i; i++) {
            System.out.print(" . ");
            /*for (int j = 0; row > j; j++) {
                System.out.println(".");
            }*/
        }
    }
}
