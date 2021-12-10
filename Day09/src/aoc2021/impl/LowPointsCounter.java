package aoc2021.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Advent of Code 2021
 * Day 09
 * <p>
 * Implementation of the solution for the task 01
 *
 * @author Szymon Rozmarynowski
 */
public class LowPointsCounter {

    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";

    private final int SIZE = 100;

    protected int[][] input = new int[SIZE][SIZE];

    public void calculate() {
        readInput();
        int result = 0;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (isLowPoint(row, col)) {
                    result+=(input[row][col]+1);
                }
            }
        }
        System.out.println(result);
    }

    private boolean isLowPoint(int row, int col) {
        int value = input[row][col];
        if (isCoordinateValid(row - 1) && value >= input[row - 1][col]) {
            return false;
        }
        if (isCoordinateValid(row + 1) && value >= input[row + 1][col]) {
            return false;
        }
        if (isCoordinateValid(col - 1) && value >= input[row][col - 1]) {
            return false;
        }
        if (isCoordinateValid(col + 1) && value >= input[row][col + 1]) {
            return false;
        }
        return true;
    }

    private boolean isCoordinateValid(int coord) {
        return coord >= 0 && coord < SIZE;
    }

    private void readInput() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            ArrayList<String> inputLines = new ArrayList();
            stream.forEach(line -> inputLines.add(line));
            for (int row = 0; row < inputLines.size(); row++) {
                char[] inputArr = inputLines.get(row).toCharArray();
                for (int col = 0; col < inputLines.get(row).toCharArray().length; col++) {
                    input[row][col] = Integer.parseInt(String.valueOf(inputArr[col]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
