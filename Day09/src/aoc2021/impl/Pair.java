package aoc2021.impl;

import java.util.Objects;

/**
 * Advent of Code 2021
 * Day 09
 * <p>
 * Implementation of pair of coordinates of the 'low point'
 *
 * @author Szymon Rozmarynowski
 */
public class Pair {

    private int row;
    private int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return row == pair.row &&
                col == pair.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
