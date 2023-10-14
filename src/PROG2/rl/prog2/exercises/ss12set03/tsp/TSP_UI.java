package rl.prog2.exercises.ss12set03.tsp;

import java.util.Scanner;

/**
 * Simple user interface for experiments with the traveling salesman problem.
 * @author Ruediger Lunde
 */
public class TSP_UI {
	
	public void startDialog() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Select a TSP 1-4 or 0 for exit: ");
			int choice = scanner.nextInt();
			if (choice == 0)
				break;
			TSP tsp = new TSP();
			switch (choice) {
			case 1: tsp.createTestMapHoles1(); break;
			case 2: tsp.createTestMapHoles2(); break;
			case 3: tsp.createTestMapHoles3(); break;
			case 4: tsp.createTestMapUlm(); break;
			}
			System.out.print("Select a solver 1-4: ");
			choice = scanner.nextInt();
			
			switch (choice) {
			case 1: tsp.computeGoodSolution(); break;
			case 2: tsp.computeBestSolutionOpt(true); break;
			case 3: tsp.computeBestSolutionOpt(false); break;
			case 4: tsp.computeBestSolution(); break;
			}
			tsp.printResults("");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new TSP_UI().startDialog();
	}
}
