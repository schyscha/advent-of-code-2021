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

import static java.util.Arrays.asList;

/**
 * Advent of Code 2021
 * Day 08
 * <p>
 * Implementation of the solution for the task 01
 *
 * @author Szymon Rozmarynowski
 */
public class EasyDigitsReader {

    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";

    private List<List<String>> outputValues = new ArrayList();

    public void occurencesCounter() {
        readInput();
        int result = 0;
        List<Integer> acceptableLengths = List.of(2, 3, 4, 7);
        for (List<String> outputValueList : outputValues) {
            for (String outputValue : outputValueList) {
                if (acceptableLengths.contains(outputValue.length())) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private void readInput() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(this::readOutputValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readOutputValue(String line) {
        outputValues.add(Arrays.asList((line.split(" \\| ")[1]).split("\\s+")));
    }

}
