package com.github.arnecdn.codewars;

public class UserSolution {
    public static long[] oddRow(final int depth) {
        long depthAsLong = depth;
        long accumulatedRowValue = (depthAsLong * depthAsLong + 1) - (depthAsLong);
        long[] result = new long[depth];
        result[0] = accumulatedRowValue;

        if (depthAsLong == 1) {
            return result;
        }

        for (int i = 1; i < depth; i++) {
            accumulatedRowValue += 2;
            result[i] = accumulatedRowValue;
        }

        return result;
    }
}
