package com.github.arnecdn.codewars;

public class WhoLikesThis {
    static String noneLikesThis = "no one likes this";
    static String oneLikeThis = "%s likes this";
    static String twoLikeThis = "%s and %s like this";
    static String threeLikeThis = "%s, %s and %s like this";
    static String manyLikeThis = "%s, %s and %d others like this";

    public static String whoLikesIt(String... names) {
        switch (names.length) {
        case 0:
            return noneLikesThis;
        case 1:
            return String.format(oneLikeThis, names);
        case 2:
            return String.format(twoLikeThis, names[0], names[1]);
        case 3:
            return String.format(threeLikeThis, names[0], names[1], names[2]);
        default:
            return String.format(manyLikeThis, names[0], names[1], names.length - 2);
        }
    }
}
