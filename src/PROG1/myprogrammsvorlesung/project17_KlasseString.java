package PROG1.myprogrammsvorlesung;

/**
 * @author Paulina Pyczot pauli
 * @date 13.11.2022
 * @time 17:07
 **/

public class project17_KlasseString {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = s1;
        System.out.println(s1 + ' ' + s2); //Java Java
        System.out.println(s1 == s2); // true
        System.out.println(s1.toUpperCase() == s2.toUpperCase()); // false
        System.out.println(s1 + ' ' + s2); // Java Java
        System.out.println(s1.toUpperCase().equals(s2.toUpperCase())); // true
    }
}
