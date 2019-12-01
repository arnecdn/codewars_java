package com.github.arnecdn.codewars;

import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isDigit(String s) {
        return s.matches("\\d");
    }
}
