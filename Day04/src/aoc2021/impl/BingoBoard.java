package aoc2021.impl;

/**
 * Advent of Code 2021
 * Day 04
 * <p>
 * Implementation of the bingo board
 *
 * @author Szymon Rozmarynowski
 */
public class BingoBoard extends Bingo {

    private int id;
    private int[][] numberMatrix;
    private boolean[][] markMatrix;

    public BingoBoard(int id, int[][] numberMatrix) {
        this.id = id;
        this.numberMatrix = numberMatrix;
        this.markMatrix = new boolean[BOARD_SIZE][BOARD_SIZE];
    }

    public BingoBoard(BingoBoard other) {
        this.id = other.getId();
        this.numberMatrix = other.getNumberMatrix();
        this.markMatrix = new boolean[BOARD_SIZE][BOARD_SIZE];
    }

    public void markNumber(int number) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (number == numberMatrix[row][col]) {
                    markMatrix[row][col] = true;
                }
            }
        }
    }

    public int getScore(int lastCalledNumber) {
        int score = 0;
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (!markMatrix[row][col]) {
                    score += numberMatrix[row][col];
                }
            }
        }
        return score * lastCalledNumber;
    }

    public boolean isWinner() {
        boolean isWinner;
        for (int row = 0; row < BOARD_SIZE; row++) {
            isWinner = true;
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (!markMatrix[row][col]) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                return true;
            }
        }
        for (int col = 0; col < BOARD_SIZE; col++) {
            isWinner = true;
            for (int row = 0; row < BOARD_SIZE; row++) {
                if (!markMatrix[row][col]) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                return true;
            }
        }
        return false;
    }

    public int[][] getNumberMatrix() {
        return numberMatrix;
    }

    public int getId() {
        return id;
    }

}
