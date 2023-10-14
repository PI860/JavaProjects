package PROG1.myprogrammsvorlesung;

import PROG1.Terminal;

/**
 * @author Paulina Pyczot
 **/

public class project16_PascalschesDreieckKapitel06S20 {
    public static void main(String[] args) {
        int x = Terminal.readInt("Provide a number");
        createTriangle(x);
        System.out.println(createTriangle(x));

    }

    public static int[][] createTriangle (int hight) {
        int[][] result = new int[hight][];
        for (int i = 0; i < hight; i++) {
            result[i] = new int[i+1];
            result[i][0] = 1;
            result[i][i] = 1;
            for (int j = 1; j < i; j++) {
                result[i][j] = result[i-1][j-1] + result[i-1][j];
            }
        }
        return result;
    }
}
