package aoc2021.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Advent of Code 2021
 * Day 06
 * <p>
 * Implementation of the solution for the task 01
 *
 * @author Szymon Rozmarynowski
 */
public class LanternfishPopulationCalculator {

    protected final int NEW_LANTERNFISH_TIMER = 8;
    protected final int LANTERNFISH_TIMER = 6;
    private final int DAYS = 80;

    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";

    protected List<Integer> lanternfishList = new ArrayList();

    public void calculate() {
        readInput();
        int listSize;
        for (int day = 0; day < DAYS; day++) {
            listSize = lanternfishList.size();
            for (int i = 0; i < listSize; i++) {
                if (lanternfishList.get(i) == 0) {
                    lanternfishList.set(i, LANTERNFISH_TIMER);
                    lanternfishList.add(NEW_LANTERNFISH_TIMER);
                } else {
                    lanternfishList.set(i, lanternfishList.get(i) - 1);
                }
            }
        }
        System.out.println(lanternfishList.size());
    }

    protected void readInput() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(line -> lanternfishList = Arrays.asList(line.split("\\s*,\\s*")).stream().map(Integer::parseInt).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
