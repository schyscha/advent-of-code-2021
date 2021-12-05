package aoc2021.impl;

/**
 * Advent of Code 2021
 * Day 05
 * <p>
 * Implementation of the line
 *
 * @author Szymon Rozmarynowski
 */
public class Line {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(String input) {
        String[] points = input.split(" -> ");
        String[] point1 = points[0].split(",");
        String[] point2 = points[1].split(",");

        x1 = Integer.parseInt(point1[0]);
        y1 = Integer.parseInt(point1[1]);
        x2 = Integer.parseInt(point2[0]);
        y2 = Integer.parseInt(point2[1]);
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}
