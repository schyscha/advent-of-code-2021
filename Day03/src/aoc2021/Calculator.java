package aoc2021;

/**
 * Advent of Code 2021
 * Day 03
 * <p>
 * Commons for both tasks
 *
 * @author Szymon Rozmarynowski
 */
public class Calculator {

    protected static final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    protected static final String FILE_NAME = "input.txt";
    protected static final int LINE_LENGTH = 12;

    protected static int[] zeros = new int[LINE_LENGTH];
    protected static int[] ones = new int[LINE_LENGTH];

    protected static void checkBits(String line) {

        for (int i = 0; i < LINE_LENGTH; i++) {
            if (line.charAt(i) == '0') {
                zeros[i]++;
            } else {
                ones[i]++;
            }
        }
    }

    protected static char switchChar(char c) {

        if (c == '0') {
            return '1';
        }
        return '0';
    }
}
