package aoc2021.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Advent of Code 2021
 * Day 04
 * <p>
 * Implementation of the solution for the task 02
 *
 * @author Szymon Rozmarynowski
 */
public class BingoSquidWinner extends BingoWinner {

    @Override
    protected void game() {
        List<BingoBoard> boardsCopy = new ArrayList();
        boards.forEach(board -> boardsCopy.add(new BingoBoard(board)));
        for (Integer number : numbers) {
            for (BingoBoard board : boards) {
                if (!boardsCopy.stream().filter(copy -> copy.getId() == board.getId()).findFirst().isPresent()) {
                    continue;
                }
                board.markNumber(number);
                if (board.isWinner()) {
                    if (boardsCopy.size() == 1) {
                        System.out.println(board.getScore(number));
                        return;
                    } else {
                        boardsCopy.removeIf(boardCopy -> boardCopy.getId() == board.getId());
                    }
                }
            }
        }
    }
}
