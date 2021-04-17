package com.github.arnecdn.codewars;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SqInRectTest {

    @Test
    public void test2() {
        assertEquals(null, SqInRect.sqInRect(900, 901));
    }


    @Test
    public void test1() {
        List<Integer> res = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 1));
        for (int r : res)
            assertEquals(res, SqInRect.sqInRect(5, 3));
    }
    @Test
    public void test3() {
        List<Integer> res = new ArrayList<Integer>(Arrays.asList(3, 1,1,1));
        for (int r : res)
            assertEquals(res, SqInRect.sqInRect(4, 3));
    }

    @Test
    public void test4() {
        List<Integer> res = new ArrayList<Integer>(Arrays.asList(2, 2));
        for (int r : res)
            assertEquals(res, SqInRect.sqInRect(4, 2));
    }
}