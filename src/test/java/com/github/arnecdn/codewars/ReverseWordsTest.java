package com.github.arnecdn.codewars;

import static org.junit.Assert.*;

import static com.github.arnecdn.codewars.ReverseWords.reverseWords;

import org.junit.Test;

public class ReverseWordsTest {
    @Test
    public void exampleCases() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", reverseWords("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", reverseWords("apple"));
        assertEquals("a b c d", reverseWords("a b c d"));
        assertEquals("elbuod  decaps  sdrow", reverseWords("double  spaced  words"));
        assertEquals("    ", reverseWords("    "));
    }

}