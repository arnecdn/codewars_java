package com.github.arnecdn.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChessTest {

    @Test
    public void sampleTests() {
        assertEquals("Test for (a3, b5)", 1, Chess.knight("a3", "b5"));
        assertEquals("Test for (a1, c1)", 2, Chess.knight("a1", "c1"));

        assertEquals("Test for (a1, f1)", 3, Chess.knight("a1", "f1"));
        assertEquals("Test for (a1, f3)", 3, Chess.knight("a1", "f3"));
        assertEquals("Test for (a1, f4)", 4, Chess.knight("a1", "f4"));
        assertEquals("Test for (a1, f7)", 5, Chess.knight("a1", "f7"));
        assertEquals("Test for (a1, f7)", 6, Chess.knight("a1", "h8"));
    }

}