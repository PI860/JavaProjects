package rl.prog2.exercises.ss12set01.connectfour;

import java.text.DecimalFormat;

/**
 * Represents the board of the Connect Four game. Disks can be dropped into
 * columns and fall down to their final position in the grid.
 * @author Ruediger Lunde
 */
public class Board {
	/**
	 * Container for disks. The top left position has indices (0, 0),
	 * the bottom right position (6, 7) for a 6x7 grid.
	 */
	private Disk[][] grid;
	
	/** For a standard board choose rows=6 and cols=7. */
	public Board(int rows, int cols) {
		grid = new Disk[rows][cols];
	}
	
	/**
	 * Adds the disk to the specified column in the first free position.
	 * @return success (false if the column is full).
	 */
	public boolean drop(Disk disk, int col) {
		boolean success = false;
		if (col >= 0 && col < getCols()) {
			int i = 0;
			if (grid[i][col] == null) {
				while (i+1 < grid.length && grid[i+1][col] == null)
					i++;
				grid[i][col] = disk;
				success = true;
			}
		}
		return success;
	}
	
	public int getRows() {
		return grid.length;
	}
	
	public int getCols() {
		return grid[0].length;
	}
	
	public Disk getDiskAt(int row, int col) {
		return grid[row][col];
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		DecimalFormat f = new DecimalFormat("00 ");
		for (int i = 0; i < getCols(); i++)
			result.append(f.format(i));
		result.append("\n");
		for (int i = 0; i < getCols(); i++)
			result.append("---");
		for (int row = 0; row < getRows(); row++) {
			result.append("\n");
			for (int col = 0; col < getCols(); col++) {
				Disk disk = getDiskAt(row, col);
				if (disk == null) {
					result.append(" . ");
				} else {
					String txt = disk.getColor();
					while (txt.length() < 2)
						txt = " " + txt;
					result.append(txt.substring(0, 2) + " ");
				}
			}
		}
		result.append("\n");
		for (int i = 0; i < getCols(); i++)
			result.append("---");
		return result.toString();
	}
	
	/** For testing... */
	public static void main(String[] args) {
		Board board = new Board(6, 7);
		board.drop(new Disk("red"), 2);
		board.drop(new Disk("yellow"), 2);
		System.out.println(board);
	}
}
