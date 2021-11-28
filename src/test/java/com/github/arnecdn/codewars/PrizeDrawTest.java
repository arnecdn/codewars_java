package com.github.arnecdn.codewars;

import static org.junit.Assert.*;

import static com.github.arnecdn.codewars.PrizeDraw.nthRank;

import org.junit.Test;

public class PrizeDrawTest {

    @Test
    public void test() {
        System.out.println("Fixed Tests");
        String st = "";
        Integer[] we = new Integer[] {4, 2, 1, 4, 3, 1, 2};
//        assertEquals("No participants", nthRank(st, we, 4));
//        st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
//        we = new Integer[] {4, 2, 1, 4, 3, 1, 2};
//        assertEquals("Not enough participants", nthRank(st, we, 8));
//        st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
//        we = new Integer[] {4, 2, 1, 4, 3, 1, 2};
//        assertEquals("Benjamin", nthRank(st, we, 4));
//        st = "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden";
//        we = new Integer[] {1, 3, 5, 5, 3, 6};
//        assertEquals("Matthew", nthRank(st, we, 2));
//
//        st = "Aubrey,Olivai,Abigail,Chloe,Andrew,Elizabeth";
//        we = new Integer[] {3, 1, 4, 4, 3, 2};
//        assertEquals("Abigail", nthRank(st, we, 4));


        st = "William,Willaim,Olivia,Olivai,Lily,Lyli";
        we = new Integer[] {1, 1, 1, 1, 1, 1};
        assertEquals("Willaim", nthRank(st, we, 1));
    }
}