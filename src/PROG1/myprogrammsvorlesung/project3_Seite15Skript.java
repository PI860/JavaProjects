package PROG1.myprogrammsvorlesung;

public class project3_Seite15Skript {
    public static void main(String[] args) {
        System.out.println(0x1b % 2 << 0x4 / 0x2); //Ox1b=27 in Hex
        int i = 10;
        System.out.println(i+=i*=5);

        int j = 0x1b % 2; //=27 Modulo 2 = 1 (=Rest aus 27/2)
        System.out.println(j);

        int k = 0x4 / 0x2; //= 4/2 = 2
        System.out.println(k);
    }
}
