package com.github.arnecdn.codewars;

import java.util.TreeMap;

public class Conversion {

    TreeMap<Integer, String> dec2roman = new TreeMap<>();

    {
        dec2roman.put(1, "I");
        dec2roman.put(4, "IV");
        dec2roman.put(5, "V");
        dec2roman.put(9, "IX");
        dec2roman.put(10, "X");
        dec2roman.put(40, "XL");
        dec2roman.put(50, "L");
        dec2roman.put(90, "XC");
        dec2roman.put(100, "C");
        dec2roman.put(400, "CD");
        dec2roman.put(500, "D");
        dec2roman.put(900, "CM");
        dec2roman.put(1_000, "M");

    }

    public String solution(final int sourceDecimal) {
        int i = sourceDecimal;
        StringBuilder roman = new StringBuilder();

        while (i > 0) {
            final String value = dec2roman.floorEntry(i).getValue();
            roman.append(value);
            i = i - dec2roman.floorKey(i);
        }

        return roman.toString();
    }
}
