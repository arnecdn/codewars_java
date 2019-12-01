package com.github.arnecdn.codewars;

import static org.junit.Assert.assertArrayEquals;

import static com.github.arnecdn.codewars.SumOfParts.sumParts;

import static junit.framework.TestCase.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SumOfPartsTest {
    private static void dotest(int[] ls, int[] expect) {
        int[] actual = sumParts(ls);
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test() {
        dotest(new int[] {}, new int[] {0});
        dotest(new int[] {0, 1, 3, 6, 10}, new int[] {20, 20, 19, 16, 10, 0});
        final int[] ints = Stream.iterate(0, i -> i + 1).limit(500000).mapToInt(i -> i).toArray();
        final long start = System.currentTimeMillis();
        final int[] sumParts = sumParts(ints);
        final long stop = System.currentTimeMillis();
        System.out.println("Tid brukt: " + (stop - start));
        dotest(new int[] {1, 2, 3, 4, 5, 6}, new int[] {21, 20, 18, 15, 11, 6, 0});
        dotest(new int[] {744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358},
            new int[] {10037855, 9293730, 9292795, 9292388, 9291934, 9291504, 9291414, 9291270, 2581057, 2580168, 2579358, 0});

    }
}
