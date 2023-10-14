package pp.prog2.training.testprograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Paulina Pyczot
 * @date 22.03.2023
 **/

public class project01_NameSorterLunde {
    private ArrayList<String> names = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public void readNames() {
        System.out.println("Provide some names (empty line to exit):");
        while (true) {
            String name = scanner.nextLine();
            if (name.isEmpty())
                break;
            names.add(name); // fügt den Namen ins Array ein
        }
    }
    public void sortNames() {
        Collections.sort(names);
    }
    public void printNames() {
        for (String n : names) {
            System.out.println(n);
        }

    }

    public static void main(String[] args) {
        project01_NameSorterLunde sorter = new project01_NameSorterLunde();
        sorter.readNames();
        sorter.sortNames();
        sorter.printNames();

    }
}
