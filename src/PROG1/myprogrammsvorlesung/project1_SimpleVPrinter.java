package PROG1.myprogrammsvorlesung;

public class project1_SimpleVPrinter {
    public static void main(String[] args) {
    printV(3);
    printV (5);
    }
    public static void printV (int size) { //der Code als Methode
        int row = 0;

        // print leading blanks
        while (row < size) {
            int i = 0;
            while (i < row) {//wenn i vorher nicht initialisiert wurde, erscheint hier eine Glühbirne "initialize variable i"
                System.out.print(" ");
                i = i + 1;
            }
            // print first x
            System.out.print("x");

            if (row < size-1) {
                //print blanks
                i = 0;
                int numOfBlanks = 2*size - 2*row -3;
                while (i < numOfBlanks) {
                    System.out.print(" ");
                    i = i+1;
                }
                //print final x
                System.out.println("x");
            }
            row = row +1; // muss außerhalb der if-Schleife stehen, sonst geht die unendlich
        }
        System.out.println();// Zeilenumbruch

    }
}
