package aoc2021.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Advent of Code 2021
 * Day 04
 * <p>
 * Implementation of the solution for the task 01
 *
 * @author Szymon Rozmarynowski
 */
public class BingoWinner extends Bingo {

    protected List<Integer> numbers;
    protected List<BingoBoard> boards;

    public void play() throws IOException {
        ArrayList<String> lines;
        try {
            lines = readLines();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        numbers = Arrays.asList(lines.remove(0).split("\\s*,\\s*")).stream().map(Integer::parseInt).collect(Collectors.toList());
        createBoards(lines);

        game();
    }

    protected void game() {
        for (Integer number : numbers) {
            for (BingoBoard board : boards) {
                board.markNumber(number);
                if (board.isWinner()) {
                    System.out.println(board.getScore(number));
                    return;
                }
            }
        }
    }

    private void createBoards(ArrayList<String> textLines) {
        List<BingoBoard> boardsList = new ArrayList();
        List<List<Integer>> lines = new ArrayList();
        int id = 0;

        while (!textLines.isEmpty()) {
            int[][] numberMatrix = new int[BOARD_SIZE][BOARD_SIZE];
            for (int i = 0; i < BOARD_SIZE; i++) {
                lines.add(Arrays.asList(textLines.remove(0).split("\\s")).stream().map(Integer::parseInt).collect(Collectors.toList()));
            }
            for (int row = 0; row < BOARD_SIZE; row++) {
                for (int col = 0; col < BOARD_SIZE; col++) {
                    numberMatrix[row][col] = lines.get(row).get(col);
                }
            }
            boardsList.add(new BingoBoard(id++, numberMatrix));
            lines.clear();
        }
        boards = boardsList;
    }

    private ArrayList<String> readLines() throws IOException {

        ArrayList<String> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(PATH + FILE_NAME));

        while (br.ready()) {
            try {
                String line = br.readLine();
                if (!line.isEmpty()) {
                    result.add(line.trim().replaceAll("\\s+", " "));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
