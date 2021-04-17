package com.github.arnecdn.codewars;

import static org.junit.Assert.*;

import static com.github.arnecdn.codewars.WhoLikesThis.whoLikesIt;

import org.junit.Test;

public class WhoLikesThisTest {
    @Test
    public void staticTests() {
//        assertEquals("no one likes this", whoLikesIt());
//        assertEquals("Peter likes this", whoLikesIt("Peter"));
//        assertEquals("Jacob and Alex like this", whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}