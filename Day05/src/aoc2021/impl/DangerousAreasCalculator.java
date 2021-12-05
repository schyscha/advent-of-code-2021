package aoc2021.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Advent of Code 2021
 * Day 05
 * <p>
 * Implementation of the solution for the task 01
 *
 * @author Szymon Rozmarynowski
 */
public class DangerousAreasCalculator {

    private final int BOARD_SIZE = 1000;
    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";

    private ArrayList<Line> lines = new ArrayList();
    protected int[][] areaDiagram = new int[BOARD_SIZE][BOARD_SIZE];

    public void calculate() {

        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(input -> lines.add(new Line(input)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.forEach(this::saveLineToDiagram);

        int result = getDangerousAreasCount();
        System.out.println(result);
    }

    private int getDangerousAreasCount() {
        int result = 0;
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (areaDiagram[row][col] >= 2) {
                    result++;
                }
            }
        }
        return result;
    }

    protected void saveLineToDiagram(Line line) {
        if (line.getX1() == line.getX2()) {
            for (int i = Math.min(line.getY1(), line.getY2()); i <= Math.max(line.getY1(), line.getY2()); i++) {
                areaDiagram[line.getX1()][i]++;
            }
        } else if (line.getY1() == line.getY2()) {
            for (int i = Math.min(line.getX1(), line.getX2()); i <= Math.max(line.getX1(), line.getX2()); i++) {
                areaDiagram[i][line.getY1()]++;
            }
        }
    }
}
