package EINF;

/**
 * @author Paulina Pyczot
 * @date 09.01.2023
 **/

public class ggt {
    public static void main(String[] args) {

    }

    public int ggt (int i1, int i2) {
        int r;
        do {
            r = i1 % i2;
            i1 = i2;
            i2 = r;
        } while (i2 != 0);
        return i1;
    }
}
