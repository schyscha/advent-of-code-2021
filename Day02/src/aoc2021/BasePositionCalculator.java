package aoc2021;

/**
 * Advent of Code 2021
 * Day 02
 * <p>
 * Commons for both tasks
 *
 * @author Szymon Rozmarynowski
 */
public class BasePositionCalculator {

    protected static final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    protected static final String FILE_NAME = "input.txt";

    protected static final String MOVE_FORWARD = "forward";
    protected static final String MOVE_DOWN = "down";
    protected static final String MOVE_UP = "up";

    protected static int horizontalPosition = 0;
    protected static int depth = 0;
    protected static int aim = 0;
}
