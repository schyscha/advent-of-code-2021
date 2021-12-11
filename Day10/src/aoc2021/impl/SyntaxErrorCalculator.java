package aoc2021.impl;

import java.util.*;

/**
 * Advent of Code 2021
 * Day 10
 * <p>
 * Implementation of the solution for the task 01
 *
 * @author Szymon Rozmarynowski
 */
public class SyntaxErrorCalculator extends AbstractErrorCalculator {

    private int result = 0;

    public void calculate() {
        fillMaps(3, 57, 1197, 25137);
        readInputAndCalculateScore();
        System.out.println(result);
    }

    @Override
    protected void calculateLineScore(String line) {
        Stack<Character> openingStack = new Stack<>();
        for (char c : line.toCharArray()) {
            if (characterPairMap.values().contains(c)) {
                openingStack.push(c);
            } else {
                if (characterPairMap.get(c) != openingStack.pop()) {
                    result+=characterScoreMap.get(c);
                    return;
                }
            }
        }
    }

}
