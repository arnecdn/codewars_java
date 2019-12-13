package com.github.arnecdn.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConversionTest {

    private Conversion conversion = new Conversion();

    @Test
    public void shouldConvertToRoman() {
        assertEquals("solution(1) should equal to I", "I", conversion.solution(1));
        assertEquals("solution(4) should equal to IV", "IV", conversion.solution(4));
        assertEquals("solution(6) should equal to VI", "VI", conversion.solution(6));
        assertEquals("solution(6) should equal to MMMXC", "MMMXC", conversion.solution(3090));
    }

}