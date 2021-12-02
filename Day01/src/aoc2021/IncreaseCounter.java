package aoc2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Advent of Code 2021
 * Day 01
 * <p>
 * Solution for task 01
 *
 * @author Szymon Rozmarynowski
 */
public class IncreaseCounter extends Counter {

    private static int oldValue = Integer.MIN_VALUE;

    public static void main(String[] args) {

        try (Stream<String> stream = Files.lines(Paths.get( PATH + FILE_NAME))) {
            stream.forEach(IncreaseCounter::compare);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }

    private static void compare(String line) {
        int value = Integer.parseInt(line);
        if (value > oldValue) {
            counter++;
        }
        oldValue = value;
    }

}
