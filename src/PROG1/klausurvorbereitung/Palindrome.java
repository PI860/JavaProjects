package PROG1.klausurvorbereitung;

/**
 * @author Paulina Pyczot
 * @date 31.01.2023
 **/

public class Palindrome {

    public static boolean testPalindrome (String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) != word.charAt(word.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(testPalindrome("AbrsjlirbA"));

        byte b1 = -1;
        System.out.println(b1 );
    }

}
