package aoc2021.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Advent of Code 2021
 * Day 08
 * <p>
 * Implementation of the solution for the task 02
 *
 * @author Szymon Rozmarynowski
 */
public class DigitsReader {

    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";

    private List<List<String>> inputValues = new ArrayList();
    private List<List<String>> outputValues = new ArrayList();
    private Map<Integer, Map<String, Integer>> decodingMap = new HashMap();

    public DigitsReader() {
        readInput();
        decode();
    }

    public void sumOutputValues() {
        int result = 0;
        for (int i = 0; i < outputValues.size(); i++) {
            int factor = 1000;
            int subResult = 0;
            for (String value : outputValues.get(i)) {
                subResult += factor * decodingMap.get(i).get(sortString(value));
                factor/=10;
            }
            result+=subResult;
        }
        System.out.println(result);
    }

    private void decode() {

        String[] numbers = new String[10];
        int loopController = 0;
        Set<String> checked5 = new HashSet<>();
        Set<String> checked6 = new HashSet<>();
        String[] checked5Arr, checked6Arr;

        for (int i = 0; i < inputValues.size(); i++) {

            // get 1, 4, 7, 8
            for (String value : inputValues.get(i)) {
                if (loopController == 4) {
                    break;
                }
                int length = value.length();
                switch (length) {
                    case 2:
                        if (numbers[1] == null) {
                            numbers[1] = value;
                            loopController++;
                            break;
                        }
                    case 3:
                        if (numbers[7] == null) {
                            numbers[7] = value;
                            loopController++;
                            break;
                        }
                    case 4:
                        if (numbers[4] == null) {
                            numbers[4] = value;
                            loopController++;
                            break;
                        }
                    case 7:
                        if (numbers[8] == null) {
                            numbers[8] = value;
                            loopController++;
                            break;
                        }
                }
            }

            // get 3 and 9
            for (String value : inputValues.get(i)) {
                if (value.length() == 5 && !checked5.contains(value)) {
                    if (toCharList(value).containsAll(toCharList(numbers[7]))) {
                        numbers[3] = value;
                    } else {
                        checked5.add(value);
                    }
                } else if (value.length() == 6 && !checked6.contains(value)) {
                    if (toCharList(value).containsAll(toCharList(numbers[4]))) {
                        numbers[9] = value;
                    } else {
                        checked6.add(value);
                    }
                }
            }

            // get 2 and 5
            checked5Arr = checked5.toArray(new String[2]);
            loopController = 0;
            for (char character : numbers[4].toCharArray()) {
                if (!checked5Arr[0].contains(String.valueOf(character))) {
                    loopController++;
                }
            }
            numbers[2] = loopController == 2 ? checked5Arr[0] : checked5Arr[1];
            numbers[5] = loopController == 1 ? checked5Arr[0] : checked5Arr[1];

            // get 0 and 6
            checked6Arr = checked6.toArray(new String[2]);
            if (toCharList(checked6Arr[0]).containsAll(toCharList(numbers[1]))) {
                numbers[0] = checked6Arr[0];
                numbers[6] = checked6Arr[1];
            } else {
                numbers[0] = checked6Arr[1];
                numbers[6] = checked6Arr[0];
            }

            // save decoding and clear variables
            Map<String, Integer> lineDecodingMap = new HashMap();
            for (int index = 0; index < numbers.length; index++) {
                lineDecodingMap.put(sortString(numbers[index]), index);
            }
            decodingMap.put(i, lineDecodingMap);
            numbers = new String[10];
            loopController = 0;
            checked5.clear();
            checked6.clear();
        }
    }

    private void readInput() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(this::readInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Character> toCharList(String string) {
        List<Character> list = new ArrayList<Character>();
        for (char c : string.toCharArray()) {
            list.add(c);
        }
        return list;
    }

    private String sortString(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private void readInput(String line) {
        String[] parts = line.split(" \\| ");
        inputValues.add(Arrays.asList((parts[0]).split("\\s+")));
        outputValues.add(Arrays.asList((parts[1]).split("\\s+")));
    }
}
