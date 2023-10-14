package PROG1.tutorium.tutorium02;

import PROG1.Terminal;

public class Rectangle {
    public static void main(String[] args) {
        int i = Terminal.readInt("Provide a number");
        printRectangle(i);

    }

    /*

            ####
            #  #
            #  #
            ####
     */

    public static void printRectangle (int size) {

        int row = 0;
        // 2. Schleife:
        while (row < size) {
            int col = 0;
            // 1. Schleife:
            while (col < size) {
                if (row == 0 || row == (size-1) || col == 0 || col == (size-1)) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
                col++;
            }
            System.out.println();
            row++;

            /**
             * Damit das Rechteck nicht ausgefüllt wird, muss gelten:
             * row (Zeile) = 0 oder max -> # wird ausgefüllt
             * col (Spalte) = 0 oder max -> # wird ausgefüllt
             * sonst: Leerzeichen benötigt
             */
        }
    }
}
