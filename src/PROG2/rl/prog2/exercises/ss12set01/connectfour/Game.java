package rl.prog2.exercises.ss12set01.connectfour;

/**
 * Provides an API for the Connect Four game. Instances of this class maintain a
 * board an the player who will take the next turn. The most interesting method
 * is {@link #checkForWinner()}.
 * 
 * @author Ruediger Lunde
 * 
 */
public class Game {

	private String[] players;
	private String winner;

	protected Board board;
	private int moveCount;

	public Game() {
		players = new String[] { "red", "yellow" };
		board = new Board(6, 7);
	}

	/**
	 * Replaces the names for the disk colors. The default names are red and
	 * yellow.
	 */
	public void setPlayers(String colorPlayer1, String colorPlayer2) {
		players = new String[] { colorPlayer1, colorPlayer2 };
	}

	public String getNextPlayerColor() {
		return players[moveCount % 2];
	}

	public Board getBoard() {
		return board;
	}

	public boolean isGameOver() {
		return moveCount == board.getRows() * board.getCols() || winner != null;
	}
	
	public String getWinner() {
		return winner;
	}
	
	public void makeMove(int col) {
		if (board.drop(new Disk(getNextPlayerColor()), col))
			moveCount++;
		winner = checkForWinner();
	}

	private String checkForWinner() {
		EqualDiskCounter counter = new EqualDiskCounter();
		EqualDiskCounter dUpCounter = new EqualDiskCounter();
		EqualDiskCounter dDownCounter = new EqualDiskCounter();
		// check horizontal lines
		for (int row = 0; row < board.getRows(); row++) {
			counter.startLine();
			for (int col = 0; col < board.getCols(); col++) {
				if (counter.analyzeNext(board.getDiskAt(row, col)))
					return counter.getLastAnalyzedDisk().getColor();
			}
		}
		// check vertical lines
		for (int col = 0; col < board.getCols(); col++) {
			counter.startLine();
			for (int row = 0; row < board.getRows(); row++) {
				if (counter.analyzeNext(board.getDiskAt(row, col)))
					return counter.getLastAnalyzedDisk().getColor();
			}
		}
		// check diagonal lines
		for (int col = 0; col < board.getCols(); col++) {
			dUpCounter.startLine();
			dDownCounter.startLine();
			for (int row = 0; row < board.getRows(); row++) {
				int dCol = (col + row) % board.getCols();
				if (dCol == 0) {
					dDownCounter.startLine();
					dUpCounter.startLine();
				}
				if (dDownCounter.analyzeNext(board.getDiskAt(row, dCol)))
					return dDownCounter.getLastAnalyzedDisk().getColor();
				if (dUpCounter.analyzeNext(board.getDiskAt(board.getRows() - 1
						- row, dCol)))
					return dUpCounter.getLastAnalyzedDisk().getColor();
			}
		}
		return null;
	}
}
