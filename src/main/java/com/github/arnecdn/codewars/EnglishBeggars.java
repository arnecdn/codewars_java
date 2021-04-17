package com.github.arnecdn.codewars;

import java.util.Arrays;

public class EnglishBeggars {
    public static int[] beggars(int[] values, int n) {
        return (n == 0) ? new int[0] : beggars(values, 0, n);
    }

    private static int[] beggars(final int[] values, final int currIndex, final int interval) {
        if (currIndex >= interval) {
            return new int[interval];
        }

        int[] beggars = beggars(values, currIndex + 1, interval);
        beggars[currIndex] = sum(values, currIndex, interval);
        return beggars;
    }

    private static int sum(int[] values, int currIndex, int interval) {
        if (currIndex >= values.length) {
            return 0;
        }
        return values[currIndex] + sum(values, currIndex + interval, interval);
    }
}
