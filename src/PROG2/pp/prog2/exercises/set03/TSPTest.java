package pp.prog2.exercises.set03;

import java.util.Scanner;

/**
 * @author Paulina Pyczot
 * @date 04.04.2023
 **/


// Aufgabe 6:
public class TSPTest {
    public static void main(String[] args) {
        TSP tsp = new TSP();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide a Circuit Board (from 1-3):");
        int selectedCircuitBoard = scanner.nextInt();
        Trip circuitBoard;
        switch (selectedCircuitBoard){
            case 1:
                circuitBoard= tsp.generateCircuitBoard1();
                break;
            case 2:
                circuitBoard = tsp.generateCircuitBoard2();
                break;
            case 3:
                circuitBoard = tsp.generateCircuitBoard3();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + selectedCircuitBoard);
        }
        System.out.println("Length of the road: " + tsp.greedy(circuitBoard));
    }
}
