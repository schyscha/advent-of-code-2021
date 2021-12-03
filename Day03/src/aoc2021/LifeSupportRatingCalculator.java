package aoc2021;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Advent of Code 2021
 * Day 03
 * <p>
 * Solution for task 02
 *
 * @author Szymon Rozmarynowski
 */
public class LifeSupportRatingCalculator extends Calculator {

    private static ArrayList<String> lines = null;

    public static void main(String[] args) {

        try {
            lines = getLines();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        int oxygenGeneratorRatingDecimal = Integer.parseInt(getBinaryRating(true), 2);
        int co2ScrubberRatingDecimal = Integer.parseInt(getBinaryRating(false), 2);

        int result = oxygenGeneratorRatingDecimal * co2ScrubberRatingDecimal;
        System.out.println(result);
    }

    private static ArrayList<String> getLines() throws IOException {

        ArrayList<String> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(PATH + FILE_NAME));

        while (br.ready()) {
            try {
                String line = br.readLine();
                result.add(line);
                checkBits(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static String getBinaryRating(boolean isOxygenGeneratorRating) {
        List<String> list = cloneList();

        for (int i = 0; i < LINE_LENGTH; i++) {
            if (list.size() == 1) {
                break;
            }
            int index = i;
            int countZeros = 0;
            int countOnes = 0;

            if (index == 0) {
                countZeros = zeros[0];
                countOnes = ones[1];
            } else {
                for (String line : list) {
                    if (line.charAt(index) == '0') {
                        countZeros++;
                    } else {
                        countOnes++;
                    }
                }
                ;
            }
            char charForFilter = getCharForFilter(index, isOxygenGeneratorRating, countZeros, countOnes);
            list = list.stream().filter(line -> line.charAt(index) == charForFilter).collect(Collectors.toList());
        }
        return list.get(0);
    }

    private static char getCharForFilter(int index, boolean isOxygenGeneratorRating, int countZeros, int countOnes) {
        char result;
        if (countZeros > countOnes) {
            result = '1';
        } else {
            result = '0';
        }
        if (isOxygenGeneratorRating) {
            result = switchChar(result);
        }
        return result;
    }

    private static List<String> cloneList() {
        List<String> clone = new ArrayList(lines.size());
        for (String line : lines) {
            clone.add(line);
        }
        return clone;
    }
}
