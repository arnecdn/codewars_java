package com.github.arnecdn.codewars;

public class MakeWindow {
    static String horizontalFrame = "-";
    static String horizontalSplit = "+";
    static String verticalFrame = "|";
    static String glass = ".";
    static String end = "\n";

    public static String makeAWindow(int num) {
        StringBuilder window = new StringBuilder();
        String windowPart = horizontalComplex(num, verticalFrame, verticalFrame, glass, end);

        window.append(horizontalSplit(windowPart.length(), horizontalFrame, end));
        window.append(repeat(windowPart, num));
        window.append(horizontalComplex(num, verticalFrame, horizontalSplit, horizontalFrame, end));
        window.append(repeat(windowPart, num));
        window.append(horizontalSplit(windowPart.length(), horizontalFrame, ""));

        return window.toString();
    }

    static String horizontalSplit(int num, final String body, final String newline) {
        return new StringBuilder()
            .append(repeat(body, num - 1))
            .append(newline).toString();
    }

    static String horizontalComplex(int num, final String side, String center, final String body, final String newline) {
        return new StringBuilder()
            .append(side)
            .append(repeat(body, num))
            .append(center)
            .append(repeat(body, num))
            .append(side)
            .append(newline).toString();
    }

    static String repeat(String source, int num) {
        StringBuilder target = new StringBuilder();
        for (int i = 0; i < num; i++) {
            target.append(source);
        }
        return target.toString();
    }
}
