package com.github.arnecdn.codewars;

import static org.junit.Assert.*;

import static com.github.arnecdn.codewars.MaxContigousSum.maxContiguousSum;

import org.junit.Test;

public class MaxContigousSumTest {
    @Test
    public void fixedTests() {
        doTest(new int[]{3, -4, 8, 7, -10, 19, -3}, 24);
        doTest(new int[]{2, -3, -3, 9, -29, 8, -9}, 9);
    }
    private void doTest(final int[] numbers, final int expected) {
        assertEquals(expected, maxContiguousSum(numbers));
    }
}