package com.github.arnecdn.codewars;

import java.util.Objects;
import java.util.Stack;

public class Boggle {
    private final char[][] currentBoard;
    private final String guessedWord;

    public Boggle(final char[][] board, final String word) {
        currentBoard = board;
        guessedWord = word;
    }

    public boolean check() {
        return searchBoard(currentBoard, guessedWord, new Stack<>());
    }

    private boolean searchBoard(final char[][] board, final String word, Stack<BoardItem> found) {

        if (word.isEmpty()) {
            return true;
        }

        char current = word.charAt(0);

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (current == board[y][x]) {
                    BoardItem newItem = new BoardItem(current, y, x);

                    if (isBoggable(newItem, found)) {
                        found.push(newItem);
                        boolean searchComplete = searchBoard(board, word.substring(1), found);

                        if (searchComplete) {
                            return true;
                        }

                        found.pop();
                    }
                }
            }
        }

        return false;
    }

    private boolean isBoggable(BoardItem item, Stack<BoardItem> found) {
        BoardItem previous = found.isEmpty() ? null : found.peek();

        if (previous == null) {
            return true;
        }

        if (!((Math.abs(previous.xPos - item.xPos) <= 1) && (Math.abs(previous.yPos - item.yPos) <= 1))) {
            return false;
        }

        return (!found.contains(item));
    }

    static class BoardItem {
        char value;
        int yPos;
        int xPos;

        public BoardItem(final char value, final int y, final int x) {
            this.value = value;
            this.yPos = y;
            this.xPos = x;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            BoardItem foundItem = (BoardItem) o;
            return value == foundItem.value && xPos == foundItem.xPos && yPos == foundItem.yPos;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, xPos, yPos);
        }
    }
}
