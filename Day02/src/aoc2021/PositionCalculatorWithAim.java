package aoc2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Advent of Code 2021
 * Day 02
 * <p>
 * Solution for task 02
 *
 * @author Szymon Rozmarynowski
 */
public class PositionCalculatorWithAim extends BasePositionCalculator {

    public static void main(String[] args) {

        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(PositionCalculatorWithAim::getAndHandleMove);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int result = horizontalPosition * depth;
        System.out.println(result);
    }

    private static void getAndHandleMove(String line) {
        String[] splited = line.split("\\s+");
        int value = Integer.parseInt(splited[1]);
        switch (splited[0]) {
            case MOVE_DOWN:
                aim += value;
                break;
            case MOVE_UP:
                aim -= value;
                break;
            case MOVE_FORWARD:
                horizontalPosition += value;
                depth += value * aim;
                break;
            default:
                System.out.println("parsing error");
        }
    }
}
