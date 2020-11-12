package com.github.arnecdn.codewars;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Chess {

    public static int knight(String start, String finish) {
        final Knight knight = new Knight();
        final ChessBoard chessBoard = new ChessBoard();
        return chessBoard.findShortestPath(knight, start, finish);
    }

    static class Knight {

        int[][] legalMoves() {
            return legalMoves;
        }

        final int[][] legalMoves = {
            { -2, -1 },
            { -2, 1 },
            { -1, -2 },
            { -1, 2 },
            { 1, -2 },
            { 1, 2 },
            { 2, -1 },
            { 2, 1 }
        };
    }

    static class ChessBoard {
        final Integer ROWS = 8;
        final String[] COLUMNS = new String[8];
        final Map<String, CellNode> cells = new HashMap<>();

        ChessBoard() {
            COLUMNS[0] = "a";
            COLUMNS[1] = "b";
            COLUMNS[2] = "c";
            COLUMNS[3] = "d";
            COLUMNS[4] = "e";
            COLUMNS[5] = "f";
            COLUMNS[6] = "g";
            COLUMNS[7] = "h";

            for (int i = 0; i < COLUMNS.length; i++) {
                for (int j = 0; j < ROWS; j++) {
                    final CellNode n = createCellNode(i, j);
                    cells.put(n.cell, n);
                }
            }
        }

        public int findShortestPath(Knight knight, final String current, final String finish) {

            final CellNode startNode = createCellNode(current);
            Queue<CellNode> moveQueue = new ArrayDeque();
            moveQueue.add(startNode);

            while (!moveQueue.isEmpty()) {
                final CellNode moveNode = moveQueue.poll();
                computeMoves(moveNode, knight.legalMoves());

                if (moveNode.cell.equals(finish)) {
                    return moveNode.distance;
                }

                for (CellNode r : moveNode.reachable) {
                    r.distance = moveNode.distance + 1;
                    moveQueue.add(r);
                }
            }
            throw new IllegalStateException("Could not found shortest path.");
        }

        void computeMoves(CellNode source, int[][] legalMoves) {
            for (int i = 0; i < legalMoves.length; i++) {
                int curX = source.getColNo() + legalMoves[i][0];
                int curY = source.getRowNo() + legalMoves[i][1];

                if (isValidMove(curX, curY)) {
                    final CellNode target = createCellNode(curX, curY);
                    source.add(target);
                }
            }
        }

        CellNode createCellNode(String cell) {
            return cells.get(cell).clone();
        }

        CellNode createCellNode(final int i, final int j) {
            final String col = findColNameByNum(i);
            return new CellNode(col + (j + 1), i, j);
        }

        String findColNameByNum(int colNum) {
            return COLUMNS[colNum];
        }

        boolean isValidMove(int currCol, int currRow) {
            if (currCol >= COLUMNS.length) {
                return false;
            }

            if (currCol < 0) {
                return false;
            }

            if (currRow >= ROWS) {
                return false;
            }

            return currRow >= 0;
        }

    }

    static class CellNode {
        final String cell;
        final int colNo;
        final int rowNo;
        int distance = 0;
        final List<CellNode> reachable = new ArrayList();

        public CellNode(final String cell, final int colNo, final int rowNo) {
            this.cell = cell;
            this.colNo = colNo;
            this.rowNo = rowNo;
        }

        CellNode(CellNode n) {
            cell = n.cell;
            colNo = n.colNo;
            rowNo = n.rowNo;
            distance = n.distance;
            reachable.addAll(reachable.stream().map(CellNode::clone).collect(Collectors.toList()));
        }

        public CellNode clone() {
            return new CellNode(this);
        }

        public int getColNo() {
            return colNo;
        }

        public int getRowNo() {
            return rowNo;
        }

        void add(CellNode a) {
            this.reachable.add(a);
        }
    }
}
