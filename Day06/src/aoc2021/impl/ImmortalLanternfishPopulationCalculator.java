package aoc2021.impl;

import java.util.Arrays;

/**
 * Advent of Code 2021
 * Day 06
 * <p>
 * Implementation of the solution for the task 02
 *
 * @author Szymon Rozmarynowski
 */
public class ImmortalLanternfishPopulationCalculator extends LanternfishPopulationCalculator {

    private final int DAYS = 256;

    @Override
    public void calculate() {
        readInput();
        long[] fishes = new long[10];
        lanternfishList.forEach(fish -> fishes[fish]++);
        for (int day = 0; day < DAYS; day++) {
            fishes[9] = fishes[0];
            fishes[7] += fishes[0];
            for (int i = 0; i < 9; i++) {
                fishes[i] = fishes[i + 1];
            }
            fishes[9] = 0;
        }
        System.out.println(Arrays.stream(fishes).sum());
    }
}
