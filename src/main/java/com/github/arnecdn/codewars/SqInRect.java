package com.github.arnecdn.codewars;

import java.util.ArrayList;
import java.util.List;

public class SqInRect {
    public static List<Integer> sqInRect(final int length, final int width) {
        if (length == width) {
            return null;
        }

        return calculateSquares(length, width);
    }


    private static List<Integer> calculateSquares(final int length, final int width) {
        int longest = (length > width) ? length : width;
        int shortest = (length < width) ? length : width;

        List<Integer> result = new ArrayList<>();
        int square = shortest;
        result.add(square);

        if (longest > shortest) {
            List<Integer> sq = calculateSquares(longest - shortest, shortest);
            result.addAll(sq);
        }

        return result;
    }
}
