package PROG1.myprogrammsvorlesung;

/**
 * @author Paulina Pyczot
 **/

public class project7_Seite26Bitoperatoren {
    public static void main(String[] args) {
        int n = 4;
        int num  = 1;
        num = num  | (1<<n);

        System.out.println(num);
    }
}
