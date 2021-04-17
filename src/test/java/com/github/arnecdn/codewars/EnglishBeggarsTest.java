package com.github.arnecdn.codewars;

import static org.junit.Assert.*;

import static com.github.arnecdn.codewars.EnglishBeggars.beggars;

import org.junit.Test;

public class EnglishBeggarsTest {

    @Test
    public void tester() throws Exception {
        // not my fault, but grouping tests in Java using `describe` is completely messed up
        // https://www.codewars.com/docs/java-test-reference
        // if can group, then do group these into basic and random tests

        // Basic tests
        int[] test = {1, 2, 3, 4, 5};
        int[] a1 = {15}, a2 = {9, 6}, a3 = {5, 7, 3}, a4 = {1, 2, 3, 4, 5, 0}, a5 = {};
        assertArrayEquals(a1, beggars(test, 1));
        assertArrayEquals(a2, beggars(test, 2));
        assertArrayEquals(a3, beggars(test, 3));
        assertArrayEquals(a4, beggars(test, 6));
        assertArrayEquals(a5, beggars(test, 0));
    }
}