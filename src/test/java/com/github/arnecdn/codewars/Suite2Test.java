package com.github.arnecdn.codewars;

import static org.junit.Assert.assertEquals;

import static com.github.arnecdn.codewars.Suite2.game;

import org.junit.Test;

public class Suite2Test {

    @Test
    public void test1() {
        assertEquals("[0]", game(0));
    }

    @Test
    public void test2() {
        assertEquals("[1, 2]", game(1));
    }

    @Test
    public void test3() {
        assertEquals("[32]", game(8));
    }
}