package com.github.arnecdn.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrdersSummaryTest {

    @Test
    public void test1() {

        String l = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B";
        assertEquals("Buy: 29499 Sell: 0",
            OrdersSummary.balanceStatements(l));
//"<Buy: [260 Sell: 11602; Badly formed 2: ]CLH16.NYM 50 56 S ;O...> but was:<Buy: [0 Sell: 11602; Badly formed 3: CAP 1300 .2 B ;]CLH16.NYM 50 56 S ;O...>"
        String l2 = " CLH16.NYM 50 56 S ,OWW 1000 11 S";

        assertEquals("Buy: 0 Sell: 0; Badly formed 2: CLH16.NYM 50 56 S ;OWW 1000 11 S ;",
            OrdersSummary.balanceStatements(l2));
    }
}