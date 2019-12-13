package com.github.arnecdn.codewars;

public class RowSumOddNumbers {
    public static int rowSumOddNumbers(final int depth) {
        int accumulator = 1;
        if (depth == 1) {
            return accumulator;
        }

        int[] oddNumberRow = new int[depth];

        for (int i = 2; i <= depth; i++) {
            for (int j = 0; j < i; j++) {
                accumulator += 2;
                if (i == depth) {
                    oddNumberRow[j] = accumulator;
                }
            }
        }

        int sumDepth = 0;

        for (int i = 0; i < oddNumberRow.length; i++) {
            sumDepth += oddNumberRow[i];
        }
        return sumDepth;
    }
}
