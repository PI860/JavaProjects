package PROG2.rl.prog2.training.training230324.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NameSorter {

    private ArrayList<String> names = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void readNames() {
        System.out.println("Provide some names (empty line to exit):");
        names.clear();
        while (true) {
            String name = scanner.nextLine();
            if (name.isEmpty())
                break;
            names.add(name);
        }
    }

    public void sortNames() {
        Collections.sort(names);
    }

    public void printNames() {
        for (String name : names)
            System.out.println(name);
    }

    public static void main(String[] args) {
        NameSorter sorter = new NameSorter();
        sorter.readNames();
        sorter.sortNames();
        sorter.printNames();
    }
}
