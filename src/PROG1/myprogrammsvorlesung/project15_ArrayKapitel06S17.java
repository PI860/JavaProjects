package PROG1.myprogrammsvorlesung;

/**
 * @author Paulina Pyczot
 **/

public class project15_ArrayKapitel06S17 {
    public static void main(String[] args) {
        // declares a 2d array variable
        char[][] chars;
        // creates a new 3x4 array
        chars = new char[3][4];
        // init values
        char ch= 'a';
        for(int i= 0; i< 3; i++)
            for(int j = 0; j < 4; j++)
                chars[i][j] = ch++;
        // print it
        for(int i= 0; i< 3; i++) {
            for(int j = 0; j < 4; j++)
                System.out.print(chars[i][j]+" ");
            System.out.println();
        }
    }
}
