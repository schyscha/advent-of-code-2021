package aoc2021.impl;

/**
 * Advent of Code 2021
 * Day 07
 * <p>
 * Implementation of the solution for the task 02
 *
 * @author Szymon Rozmarynowski
 */
public class AccurateAlignFuelCalculator extends AlignFuelCalculator {

    @Override
    protected Integer getSingleCost(int position1, int position2) {
        int abs = Math.abs(position1 - position2);
        return abs * (abs + 1) / 2;
    }
}
