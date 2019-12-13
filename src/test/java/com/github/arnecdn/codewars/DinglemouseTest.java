package com.github.arnecdn.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DinglemouseTest {
    @Test
    public void ex0() {
        assertEquals(0, Dinglemouse.countDeafRats(null));
    }

    @Test
    public void ex1() {
        assertEquals(0, Dinglemouse.countDeafRats("~O~O~O~O P"));
    }

    @Test
    public void ex2() {
        assertEquals(1, Dinglemouse.countDeafRats("P O~ O~ ~O O~"));
    }

    @Test
    public void ex3() {
        assertEquals(2, Dinglemouse.countDeafRats("~O~O~O~OP~O~OO~"));
    }

    @Test
    public void ex7() {
        assertEquals(7, Dinglemouse.countDeafRats("PO~O~O~O~~OO~  O~O~~OO~  O~O~O~O~O~O~O~O~O~O~O~O~~OO~O~~OO~~OO~O~O~  O~O~O~~OO~  ~O"));
    }

    //
}