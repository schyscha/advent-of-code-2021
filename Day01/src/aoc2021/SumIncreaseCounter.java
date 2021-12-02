package aoc2021;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Advent of Code 2021
 * Day 01
 * <p>
 * Solution for task 02
 *
 * @author Szymon Rozmarynowski
 */
public class SumIncreaseCounter extends Counter {

    private static int previousSum = 0;

    private static ArrayList<Integer> lines = null;

    public static void main(String[] args) {

        try {
            lines = getLines();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        counter++;
        compareSums();
        System.out.println(counter);

    }

    private static ArrayList<Integer> getLines() throws IOException {

        ArrayList<Integer> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader( PATH + FILE_NAME));

        while (br.ready()) {
            try {
                result.add(Integer.parseInt(br.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static void compareSums() {

        previousSum = lines.subList(0, 2).stream().mapToInt(Integer::intValue).sum();

        for (int i = 1; i < lines.size() - 2; i++) {
            int sum = lines.subList(i, i + 3).stream().mapToInt(Integer::intValue).sum();
            if (previousSum < sum) {
                counter++;
            }
            previousSum = sum;
        }
    }
}
