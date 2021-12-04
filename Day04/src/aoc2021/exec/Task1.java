package aoc2021.exec;

import aoc2021.impl.BingoWinner;

import java.io.IOException;

/**
 * Advent of Code 2021
 * Day 04
 * <p>
 * Execution of the solution for the task 01
 *
 * @author Szymon Rozmarynowski
 */
public class Task1 {

    public static void main(String[] args) throws IOException {
        BingoWinner bingoWinner = new BingoWinner();
        bingoWinner.play();
    }
}
