package com.github.arnecdn.codewars;

public class SeparateWheatFromChaf {

    public static long[] wheatFromChaff(long[] values) {
        long[] result = new long[values.length];
        int currentLastIndex = values.length;

        for (int i = 0; i < values.length; i++) {
            if (result[i] == 0) {
                result[i] = values[i];
            }

            while (values[i] >= 0 && currentLastIndex-- > i) {
                if ((values[currentLastIndex] < 0)) {
                    result[currentLastIndex] = values[i];
                    result[i] = values[currentLastIndex];
                    break;
                }
            }
        }

        return result;
    }
}
