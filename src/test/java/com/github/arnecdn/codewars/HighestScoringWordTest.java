package com.github.arnecdn.codewars;

import static org.junit.Assert.*;

import static com.github.arnecdn.codewars.HighestScoringWord.high;

import org.junit.Test;

public class HighestScoringWordTest {
    @Test
    public void sampleTests() {
        assertEquals("taxi", high("man i need a taxi up to ubud"));
        assertEquals("volcano", high("what time are we climbing up to the volcano"));
        assertEquals("semynak", high("take me to semynak"));
    }

    @Test
    public void edgeCaseTests() {
        assertEquals("aa", high("aa b"));
        assertEquals("b", high("b aa"));
        assertEquals("bb", high("bb d"));
        assertEquals("d", high("d bb"));
        assertEquals("aaa", high("aaa b"));
    }
}