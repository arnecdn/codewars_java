package com.github.arnecdn.codewars;

public class Dinglemouse {

    public static final String PIED_PIPER = "P";
    public static final String RAT_GOING_RIGHT = "~O";
    public static final String RAT_GOING_LEFT = "O~";

    public static int countDeafRats(final String s) {

        final String wholeQueue = s.replaceAll("(\\s)|(\\n)|(\\r)", "");
        int countDef = 0;

        final String[] split = wholeQueue.split(PIED_PIPER);

        if (split.length == 0) {
            return 0;
        }

        String left = split[0];
        String right = (split.length == 2) ? split[1] : "";

        countDef = countRatsRunningWrongWay(left, RAT_GOING_LEFT);
        countDef += countRatsRunningWrongWay(right, RAT_GOING_RIGHT);

        return countDef;
    }

    private static int countRatsRunningWrongWay(final String runningRats, String ratRunningWrongWaySymbol) {
        int countDef = 0;
        for (int i = 0; i < runningRats.length(); i += 2) {
            final String currentRat = runningRats.substring(i, i + ratRunningWrongWaySymbol.length());
            if (currentRat.equals(ratRunningWrongWaySymbol)) {
                countDef++;
            }
        }
        return countDef;
    }
}
