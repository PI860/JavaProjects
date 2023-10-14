package PROG1.tutorium.tutorium02;

import PROG1.Terminal;

public class ExerciseSet02Copy {
    public static void main(String[] args) {
        int num = Terminal.readInt("Provide a number");
        System.out.println(computeSum(num));

        //3. Schritt: Methode muss in der main Methode aufgerufen werden:
        printSequence1(num);
    }

    public static int computeSum(int number) {
        int result = 0;
        int i= 1;
        while(i<= number) {
            result = result + i;
            i = i + 1;
        }
        return result;
    }
        //1. Schritt: Neue Methode printSequence1:
        public static void printSequence1 (int num) {

        int i = 0;

        //2. Schritt: Ausgabe von i quadratischen Zahlen:
        while (i < num) {
            int result = i * i;
            System.out.print(result + " ");
            i++;
        }


    }
}
