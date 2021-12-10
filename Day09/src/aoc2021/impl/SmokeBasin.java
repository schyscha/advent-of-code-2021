package aoc2021.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Advent of Code 2021
 * Day 09
 * <p>
 * Commons for other classes
 *
 * @author Szymon Rozmarynowski
 */
public class SmokeBasin {

    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";

    protected final int SIZE = 100;

    protected int[][] input = new int[SIZE][SIZE];

    protected void readInput() {
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

    protected boolean isCoordinateValid(int coord) {
        return coord >= 0 && coord < SIZE;
    }
}
