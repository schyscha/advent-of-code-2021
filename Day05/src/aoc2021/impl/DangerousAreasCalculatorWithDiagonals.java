package aoc2021.impl;

/**
 * Advent of Code 2021
 * Day 05
 * <p>
 * Implementation of the solution for the task 02
 *
 * @author Szymon Rozmarynowski
 */
public class DangerousAreasCalculatorWithDiagonals extends DangerousAreasCalculator {

    @Override
    protected void saveLineToDiagram(Line line) {
        super.saveLineToDiagram(line);
        if (line.getX1() != line.getX2() && line.getY1() != line.getY2()) {
            int x = line.getX1();
            int y = line.getY1();
            areaDiagram[x][y]++;
            while (x != line.getX2() && y != line.getY2()) {
                x = x < line.getX2() ? ++x : --x;
                y = y < line.getY2() ? ++y : --y;
                areaDiagram[x][y]++;
            }
        }
    }
}
