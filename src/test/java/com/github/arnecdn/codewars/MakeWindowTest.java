package com.github.arnecdn.codewars;

import static org.junit.Assert.*;

import static com.github.arnecdn.codewars.MakeWindow.makeAWindow;

import org.junit.Test;

public class MakeWindowTest {
    /*
-----
|.|.|
|-+-|
|.|.|
-----
     */
    @Test
    public void fixedTest1() {
        //n =1
        String window = makeAWindow(1);
        System.out.println(window);
        assertEquals("-----\n|.|.|\n|-+-|\n|.|.|\n-----", window);
    }

    @Test
    public void fixedTest2() {
        //n =1
        String window = makeAWindow(2);
        System.out.println(window);
        assertEquals("-------\n"
            + "|..|..|\n"
            + "|..|..|\n"
            + "|--+--|\n"
            + "|..|..|\n"
            + "|..|..|\n"
            + "-------", window);
    }

/*
---------
|...|...|
|...|...|
|...|...|
|---+---|
|...|...|
|...|...|
|...|...|
---------
    */
    @Test
    public void fixedTest3() {
        //n =3
        String window = makeAWindow(3);
        System.out.println(window);
        assertEquals("---------\n|...|...|\n|...|...|\n|...|...|\n|---+---|\n|...|...|\n|...|...|\n|...|...|\n---------",window);
    }
}