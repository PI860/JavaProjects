package rl.prog2.exercises.ss12set01.connectfour;

import java.util.Scanner;

// Overview: Classes and responsibilities
//
// Disk:
// - knows color
// Board:
// - knows grid including the dimensions of the grid
// - knows disk positions in the grid
// - can drop disks
// Game:
// - knows Board
// - knows disk colors
// - knows disk color for next player
// - can make move
// - can check for win situation
// SimpleUI:
// - knows Game
// - can communicate with the user via console in- and output

/**
 * Simple command line interface for the Connect Four game.
 * 
 * @author Ruediger Lunde
 */
public class SimpleUI {

	private Game game;

	public void startGame() {
		game = new Game();
		Scanner scanner = new Scanner(System.in);
		game.setPlayers("X", "O");
		System.out.println(game.getBoard());
		while (!game.isGameOver()) {
			System.out.println("Next move: " + game.getNextPlayerColor());
			System.out.print("Specify column > ");
			int col = scanner.nextInt();
			game.makeMove(col);
			System.out.println(game.getBoard());
		}
		if (game.getWinner() != null)
			System.out.println("Color " + game.getWinner()
					+ " has won. Congratulations!");
	}

	public static void main(String[] args) {
		new SimpleUI().startGame();
	}
}
