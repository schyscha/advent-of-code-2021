package aoc2021.impl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Advent of Code 2021
 * Day 10
 * <p>
 * Implementation of the solution for the task 02
 *
 * @author Szymon Rozmarynowski
 */
public class IncompleteErrorCalculator extends AbstractErrorCalculator {

    private Map<Character, Character> invertedCharacterPairMap = new HashMap<>();
    private List<Long> scores = new ArrayList<>();

    public void calculate() {
        fillMaps(1, 2, 3, 4);
        invertedCharacterPairMap =
                characterPairMap.entrySet()
                        .stream()
                        .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        readInputAndCalculateScore();
        Collections.sort(scores);

        System.out.println(scores.get(scores.size()/2));
    }

    @Override
    protected void calculateLineScore(String line) {
        Stack<Character> openingStack = new Stack<>();
        for (char c : line.toCharArray()) {
            if (characterPairMap.values().contains(c)) {
                openingStack.push(c);
            } else {
                if (characterPairMap.get(c) != openingStack.pop()) {
                    return;
                }
            }
        }
        long result = 0;
        while (!openingStack.isEmpty()){
            result*=5;
            result+=characterScoreMap.get(invertedCharacterPairMap.get(openingStack.pop()));
        }
        scores.add(result);
    }
}
