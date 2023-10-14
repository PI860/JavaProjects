package pp.prog2.training.testprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Paulina Pyczot
 * @date 22.03.2023
 **/

public class project00_NameSorter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide names:");
        scanner.hasNextLine();
        String names = scanner.nextLine();
        ArrayList<String> namesList;
        namesList = new ArrayList<String>();
        namesList.addAll(Arrays.asList(names));
        System.out.println(namesList.indexOf(names));





    }
}
