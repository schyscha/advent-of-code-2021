package aoc2021.impl;

import java.util.*;

/**
 * Advent of Code 2021
 * Day 09
 * <p>
 * Implementation of the solution for the task 02
 *
 * @author Szymon Rozmarynowski
 */
public class BasinCalculator extends SmokeBasin {

    private List<Pair> lowPoints = new ArrayList<>();
    private List<Integer> basinSizes = new ArrayList<>();

    public void calculate() {
        readInput();
        LowPointsCounter lpc = new LowPointsCounter();
        lowPoints = lpc.calculate();
        calculateBasins();
        Collections.sort(basinSizes, Collections.reverseOrder());
        System.out.println(basinSizes.get(0) * basinSizes.get(1) * basinSizes.get(2));
    }

    private void calculateBasins() {
        for (Pair lowPoint : lowPoints) {
            Set<Pair> area = calculateBasin(lowPoint.getRow(), lowPoint.getCol());
            basinSizes.add(area.size());
        }
    }

    private Set<Pair> calculateBasin(int row, int col) {
        Set<Pair> area = new HashSet<>();
        area.add(new Pair(row, col));
        int value = input[row][col];

        if (isCoordinateValid(row - 1) && isValueValid(value, input[row - 1][col])) {
            area.addAll(calculateBasin(row - 1, col));
        }
        if (isCoordinateValid(row + 1) && isValueValid(value, input[row + 1][col])) {
            area.addAll(calculateBasin(row + 1, col));
        }
        if (isCoordinateValid(col - 1) && isValueValid(value, input[row][col - 1])) {
            area.addAll(calculateBasin(row, col - 1));
        }
        if (isCoordinateValid(col + 1) && isValueValid(value, input[row][col + 1])) {
            area.addAll(calculateBasin(row, col + 1));
        }

        return area;
    }

    private boolean isValueValid(int previousPointValue, int value) {
        return previousPointValue < value && value < 9;
    }

}
