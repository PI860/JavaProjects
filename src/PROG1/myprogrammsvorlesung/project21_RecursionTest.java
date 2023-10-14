package PROG1.myprogrammsvorlesung;

/**
 * @author Paulina Pyczot
 * @date 01.12.2022
 **/

public class project21_RecursionTest {
    public static void main(String[] args) {
        int[] data = {1, 4, 10, 3,555,3};
        System.out.println(max(data));

        // iterative Variante:
        int dataNew = 0;
        for (int i = 1; i < data.length; i++) {
            if (data[i]>=data[i-1]) {
                dataNew = data [i];
            }
        }
        System.out.println(dataNew);

        // iterative Ausgabe vom Palindrom:
        System.out.println(testPalindrome("Otto"));
    }

    // iterative Variante 2:
    public static int max(int[] data) {
        int result = Integer.MIN_VALUE;
        for (int num : data) {
            if (num > result) {
                result = num;
            }
        }
        return result;
    }

    // rekursive Variante:
    public static int maxRec (int[] data) {
        return maxRec(data, 0);
    }

    public static int maxRec (int[] data, int left) {
        if (left == data.length) {
            return Integer.MIN_VALUE;
        }
        int maxRest = maxRec(data,left + 1);
        return Math.max(data[left], maxRec(data, left + 1));
    }

    // iterative Ausgabe von Palindromen:
    public static boolean testPalindrome (String text) {
        text = text.toLowerCase().replace(" ", "");
        for (int i = 0; i < text.length()/2; i++) {
            if (text.charAt(i) != text.charAt(text.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
