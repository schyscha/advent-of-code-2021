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
 * Day 07
 * <p>
 * Implementation of the solution for the task 01
 *
 * @author Szymon Rozmarynowski
 */
public class AlignFuelCalculator {

    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";

    private List<Integer> positions = new ArrayList();

    public void calculate() {
        readInput();
        int cost;
        int minimal = Integer.MAX_VALUE;
        for (int i = positions.get(0); i <= positions.get(positions.size() - 1); i++) {
            cost = 0;
            for (Integer position : positions) {
                cost += getSingleCost(i, position);
            }
            if (cost < minimal) {
                minimal = cost;
            }
        }

        System.out.println(minimal);
    }

    private void readInput() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(line -> positions = Arrays.asList(line.split("\\s*,\\s*")).stream().map(Integer::parseInt).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(positions);
    }

    protected Integer getSingleCost(int position1, int position2) {
        return Math.abs(position1 - position2);
    }

}
