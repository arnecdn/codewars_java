package com.github.arnecdn.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StockListTest {

    @Test
    public void test1() {
        String[] art = new String[] { "ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600" };
        String[] cd = new String[] { "A", "B", "G" };
        assertEquals("(A : 200) - (B : 1140)",
            StockList.stockSummary(art, cd));
    }

    @Test
    public void test2() {
        String[] art = new String[] { "ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600" };
        String[] cd = new String[] {};
        assertEquals("",
            StockList.stockSummary(art, cd));
    }
}