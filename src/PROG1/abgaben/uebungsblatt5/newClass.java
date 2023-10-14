package PROG1.abgaben.uebungsblatt5;

/**
 * @author Paulina Pyczot
 **/

public class newClass {
    public static void main(String[] args) {

        /*else if (notenArray[j] > notenArray[i]) {
            max = notenArray[j];
        }

        Provide amount of numbers to be analyzed: 8
        Provide grade: 5
        Provide grade: 7
        Provide grade: 6
        Provide grade: 2
        Provide grade: 80
        Provide grade: -5
        Provide grade: 2
        Provide grade: 9
        5.0 | 7.0 | 6.0 | 2.0 | 80.0 | -5.0 | 2.0 | 9.0 |
                2.0
        9.0*/
        double timeData = 1.5464;
        int hoursData = 1;
        double minutesData = (timeData % 1) * 60;

        System.out.printf(hoursData + ":%.0f", minutesData);

    }
}
