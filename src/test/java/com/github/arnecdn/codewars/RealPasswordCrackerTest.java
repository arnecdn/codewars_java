package com.github.arnecdn.codewars;

import static org.junit.Assert.assertEquals;

import static com.github.arnecdn.codewars.RealPasswordCracker.passwordCracker;

import org.junit.Test;

public class RealPasswordCrackerTest {
    @Test
    public void test() {
        assertEquals("code", passwordCracker("e6fb06210fafc02fd7479ddbed2d042cc3a5155e"));
       assertEquals("test", passwordCracker("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3"));
    }

}