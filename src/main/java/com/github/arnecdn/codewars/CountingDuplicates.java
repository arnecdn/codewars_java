package com.github.arnecdn.codewars;

import java.util.HashSet;
import java.util.Set;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Set<Character> found = new HashSet<>();
        final String lowerCase = text.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            final int indexOf = lowerCase.indexOf(c, i + 1);

            if (indexOf > -1) {
                found.add(c);
                continue;
            }
        }
        return found.size();
    }
}
