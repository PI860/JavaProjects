package PROG1.myprogrammsvorlesung;

import PROG1.Terminal;

/**
 * @author Paulina Pyczot
 **/

public class project12_TestDifferentReturns {
    public static void main(String[] args) {
        int i = Terminal.readInt("Provide number");
        System.out.println(computeSum(i));
    }

    public static int computeSum (int number) {
        int result = 0;
        int i= 1;
        while(i<= number) {
            result = result + i;
            i= i+ 1;
        }
        return result; //       Input 12 -> Output 78 (hier das Richtige zum Ausgeben!)
        // return 0; //         Input 12 -> Output 0
        // return 1; //         Input 12 -> Output 1
        // return number; //    Input 12 -> Output 12 = i
    }
}
