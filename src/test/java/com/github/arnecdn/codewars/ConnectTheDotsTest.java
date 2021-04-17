package com.github.arnecdn.codewars;

import static org.junit.Assert.assertEquals;

import static com.github.arnecdn.codewars.ConnectTheDots.connectTheDots;

import org.junit.Test;

public class ConnectTheDotsTest {

    @Test
    public void example1() {
        String in =
                "           \n" +
                " a       b \n" +
                " e         \n" +
                "           \n" +
                " d       c \n" +
                "           \n";
        String out =
            "           \n" +
                " ********* \n" +
                " *       * \n" +
                " *       * \n" +
                " ********* \n" +
                "           \n";
        String actual = connectTheDots(in);
        System.out.println(actual);
        assertEquals(out, actual);
    }

    @Test
    public void example2() {
        String in =
            "           \n" +
                "     a     \n" +
                "    e      \n" +
                "           \n" +
                "  d     b  \n" +
                "           \n" +
                "           \n" +
                "     c     \n" +
                "           \n";
        String out =
            "           \n" +
                "     *     \n" +
                "    * *    \n" +
                "   *   *   \n" +
                "  *     *  \n" +
                "   *   *   \n" +
                "    * *    \n" +
                "     *     \n" +
                "           \n";
        String actual = connectTheDots(in);
        System.out.println(actual);
        assertEquals(out, actual );
    }

}