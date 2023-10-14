package PROG1.myprogrammsvorlesung;

import PROG1.Terminal;

/**
 * @author Paulina Pyczot
 **/

public class project10_SwitchCase {
    public static void main(String[] args) {
        int i = Terminal.readInt("Provide number");

        if (i < 5) {
            System.out.println("Zahl ist kleiner 5");
        } else if (i >= 5 && i < 10) {
            System.out.println("Zahl liegt zwischen 5 und 9");
        }


        switch (i) {
            case 1:
                System.out.println("Zahl ist kleiner 5");
                break;
            case 2:
                System.out.println("Zahl ist kleiner 5");
                break;
            case 3:
                System.out.println("Zahl ist kleiner 5");
                break;
            case 4:
                System.out.println("Zahl ist kleiner 5");
                break;
            case 5:
                System.out.println("Zahl liegt zwischen 5 und 9");
                break;
            case 6:
                System.out.println("Zahl liegt zwischen 5 und 9");
                break;
            case 7:
                System.out.println("Zahl liegt zwischen 5 und 9");
                break;
            case 8:
                System.out.println("Zahl liegt zwischen 5 und 9");
                break;
            case 9:
                System.out.println("Zahl liegt zwischen 5 und 9");
                break;
        }

        int day = Terminal.readInt("Provide number of day");

        switch (day) {
            case 1:
                System.out.println("Mo");
                break;
            case 2:
                System.out.println("Di");
                break;
            case 3:
                System.out.println("Mi");
                break;
            case 4:
                System.out.println("Do");
                break;
            case 5:
                System.out.println("Fr");
                break;
            case 6:
                System.out.println("Sa");
                break;
            case 7:
                System.out.println("So");
                break;
            default:
                System.out.println("Geben Sie eine Zahl zwischen 1 und 7 ein!");
                break;
        }

        System.out.println("Testausgabe");

        /*
        **** 2: Grade calculator ****
        Provide amount of numbers to be analyzed: 5
        Provide grade: 1
        Provide grade: 4
        Provide grade: 3
        Provide grade: 2
        Provide grade: 7
        1.0 | 4.0 | 3.0 | 2.0 | 7.0 |
                MIN: 1.0
        MAX: 4.0
        SUM: 17.0
        AVERAGE: 3.4*/
    }
}
