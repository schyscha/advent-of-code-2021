package aoc2021.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Advent of Code 2021
 * Day 09
 * <p>
 * Implementation of the solution for the task 01
 *
 * @author Szymon Rozmarynowski
 */
public class LowPointsCounter extends SmokeBasin {

    public List<Pair> calculate() {
        readInput();
        List<Pair> lowPoints = new ArrayList<>();
        int result = 0;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (isLowPoint(row, col)) {
                    result += (input[row][col] + 1);
                    lowPoints.add(new Pair(row, col));
                }
            }
        }
        System.out.println(result);
        return lowPoints;
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

}
