package com.github.arnecdn.codewars;

import java.util.Arrays;

public class SortAndStar {
    public static String twoSort(String[] s) {
        Arrays.sort(s);
        final String first = s[0];
        final char[] chars = first.toCharArray();
        String[] word = new String[first.length()];

        for (int i = 0; i < chars.length; i++) {
            word[i] = Character.toString(chars[i]);
        }

        return String.join("***", word);
    }
}
