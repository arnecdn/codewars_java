package com.github.arnecdn.codewars;

import java.util.Arrays;

public class EncryptThis {
    public static String encryptThis(String text) {
        if (text.isEmpty()) {
            return "";
        }

        return parseWords(text.split(" "), new StringBuilder());
    }

    static String parseWords(String[] original, StringBuilder reversed) {
        if (original.length == 0) {
            return reversed.toString();
        }

        char[] charsOrig = original[0].toCharArray();
        reversed.append(header(charsOrig));
        reversed.append(body(charsOrig));
        reversed.append(tail(original));

        return parseWords(Arrays.copyOfRange(original, 1, original.length), reversed);
    }

    private static int header(final char[] c) {
        return c[0];
    }

    private static String body(final char[] charsOrig) {
        return (charsOrig.length > 1) ? swapFirstAndLast(charsOrig) : "";
    }

    private static String tail(final String[] splitString) {
        return (splitString.length > 1) ? " " : "";
    }

    private static String swapFirstAndLast(char[] chars) {
        char[] body = Arrays.copyOfRange(chars, 1, chars.length);
        body[body.length - 1] = chars[1];
        body[0] = chars[chars.length - 1];
        return String.valueOf(body);
    }

}
