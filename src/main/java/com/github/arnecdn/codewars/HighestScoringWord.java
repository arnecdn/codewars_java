package com.github.arnecdn.codewars;

import java.util.Arrays;

public class HighestScoringWord {
    final private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String high(String s) {
        return findHigestScore(s.split(" "), "");
    }

    private static String findHigestScore(final String[] words, final String currentHighestScoringWord) {
        if (words.length == 0) {
            return currentHighestScoringWord;
        }

        String newCurrentHighestScoringWord = (score(currentHighestScoringWord) >= score(words[0])) ? currentHighestScoringWord : words[0];
        return findHigestScore(Arrays.copyOfRange(words, 1, words.length), newCurrentHighestScoringWord);
    }

    private static int score(final String word) {
        return (word.isEmpty()) ? 0 : (alphabet.indexOf(word.charAt(0)) + 1) + score(word.substring(1));
    }
}
