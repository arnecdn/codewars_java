package com.github.arnecdn.codewars;

import java.util.Arrays;

public class ReverseWords {

    public static final String DELIMETER = " ";

    public static String reverseWords(final String original) {
        return parseWords(original.split(DELIMETER, -1), new StringBuilder());
    }

    static String parseWords(String[] original, StringBuilder reversed) {
        if (original.length == 0) {
            return reversed.toString();
        }
        String paddedReversedWord = reverseWord(original[0], "") + withPadding(original);
        return parseWords(Arrays.copyOfRange(original, 1, original.length), reversed.append(paddedReversedWord));
    }

    private static String withPadding(final String[] splitString) {
        return (splitString.length > 1) ? DELIMETER : "";
    }

    private static String reverseWord(final String word, String reversed) {
        if (word.isEmpty()) {
            return reversed;
        }
        return reverseWord(word.substring(0, word.length() - 1), reversed + word.charAt(word.length() - 1));
    }

}
