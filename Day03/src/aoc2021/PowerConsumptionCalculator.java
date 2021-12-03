package aoc2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Advent of Code 2021
 * Day 03
 * <p>
 * Solution for task 01
 *
 * @author Szymon Rozmarynowski
 */
public class PowerConsumptionCalculator extends Calculator {

    public static void main(String[] args) {

        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(PowerConsumptionCalculator::checkBits);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String gammaBinary = buildFinalGammaBinary();
        String epsilonBinary = buildFinalEpsilonBinary(gammaBinary);

        int gammaDecimal = Integer.parseInt(gammaBinary, 2);
        int epsilonDecimal = Integer.parseInt(epsilonBinary, 2);

        int result = gammaDecimal * epsilonDecimal;
        System.out.println(result);
    }

    private static String buildFinalGammaBinary() {

        String result = "";

        for (int i = 0; i < LINE_LENGTH; i++) {
            result = result + (zeros[i] > ones[i] ? '0' : '1');
        }

        return result;
    }

    private static String buildFinalEpsilonBinary(String gammaBinary) {

        String result = "";

        for (int i = 0; i < LINE_LENGTH; i++) {
            result = result + (switchChar(gammaBinary.charAt(i)));
        }

        return result;
    }

}
