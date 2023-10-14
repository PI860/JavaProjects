package pp.prog2.exercises.set01;

/**
 * @author Paulina Pyczot
 * @date 19.03.2023
 **/

import java.util.Scanner;

public class ConnectFour {

    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final int WINNING_LENGTH = 4;
    private char[][] rack;
    private char currentPlayer;
    private boolean gameOver;

    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        game.play();
    }

    public ConnectFour() {
        rack = new char[ROWS][COLUMNS];
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                rack[row][column] = EMPTY;
            }
        }
        currentPlayer = PLAYER_X;
        gameOver = false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            displayRack();
            int column = getColumn(scanner);
            dropToken(column);
            if (hasWon()) {
                gameOver = true;
                System.out.println(currentPlayer + " won!");
            } else if (isRackFull()) {
                gameOver = true;
                System.out.println("End of the game!");
            } else {
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }
        scanner.close();
    }

    private void displayRack() {
        System.out.println("00 " + "01 " + "02 " + "03 " + "04 " + "05 " + "06 ");
        System.out.println("--------------------");
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                System.out.print(rack[row][column] + "  ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
        System.out.println();
    }

    private int getColumn(Scanner scanner) {
        int column = -1;
        do {
            System.out.print(currentPlayer + ", choose a column from 0 to 6: ");
            column = scanner.nextInt();
        } while (!isValidColumn(column));
        return column;
    }

    private boolean isValidColumn(int column) {
        if (column < 0 || column >= COLUMNS) {
            return false;
        }
        return rack[0][column] == EMPTY;
    }

    private void dropToken(int column) {
        int row = ROWS - 1;
        while (rack[row][column] != EMPTY) {
            row--;
        }
        rack[row][column] = currentPlayer;
    }

    private boolean hasWon() {
        int count = 0;

        // Check rows
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                if (rack[row][column] == currentPlayer) {
                    count++;
                    if (count == WINNING_LENGTH) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
        }

        // Check columns
        for (int column = 0; column < COLUMNS; column++) {
            for (int row = 0; row < ROWS; row++) {
                if (rack[row][column] == currentPlayer) {
                    count++;
                    if (count == WINNING_LENGTH) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
        }

        // Check diagonal (top left to bottom right)
        for (int row = 0; row <= ROWS - WINNING_LENGTH; row++) {
            for (int column = 0; column <= COLUMNS - WINNING_LENGTH; column++) {
                count = 0;
                for (int i = 0; i < WINNING_LENGTH; i++) {
                    if (rack[row+i][column+i] == currentPlayer) {
                        count++;
                        if (count == WINNING_LENGTH) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }

        // Check diagonal (top right to bottom left)
        for (int row = 0; row <= ROWS - WINNING_LENGTH; row++) {
            for (int column = WINNING_LENGTH - 1; column < COLUMNS; column++) {
                count = 0;
                for (int i = 0; i < WINNING_LENGTH; i++) {
                    if (rack[row+i][column-i] == currentPlayer) {
                        count++;
                        if (count == WINNING_LENGTH) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }
        return false;
    }

    private boolean isRackFull() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                if (rack[row][column] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}