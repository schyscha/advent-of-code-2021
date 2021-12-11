package aoc2021.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Advent of Code 2021
 * Day 10
 * <p>
 * Commons for other classes
 *
 * @author Szymon Rozmarynowski
 */
public abstract class AbstractErrorCalculator {

    protected final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    protected final String FILE_NAME = "input.txt";

    protected Map<Character, Integer> characterScoreMap = new HashMap();
    protected Map<Character, Character> characterPairMap = new HashMap<>();

    protected void fillMaps(int val1, int val2, int val3, int val4){
        characterScoreMap.put(')', val1);
        characterScoreMap.put(']', val2);
        characterScoreMap.put('}', val3);
        characterScoreMap.put('>', val4);

        characterPairMap.put(')', '(');
        characterPairMap.put(']', '[');
        characterPairMap.put('}', '{');
        characterPairMap.put('>', '<');
    }

    protected void readInputAndCalculateScore() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(this::calculateLineScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract void calculateLineScore(String line);
}
