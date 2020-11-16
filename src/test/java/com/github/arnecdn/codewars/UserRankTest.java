package com.github.arnecdn.codewars;

import static org.junit.Assert.*;

import org.junit.Test;


public class UserRankTest {

    @Test
    public void shouldIncrease(){
        User user = new User();
        user.incProgress(-7);
        assertEquals(10, user.progress);
        user.incProgress(-5);
        assertEquals(0, user.progress);
        assertEquals(-7, user.rank);
    }

    @Test
    public void userShouldCompleteActivity_minus6(){
        User user = new User();
        user.incProgress(-6);
        assertEquals(40, user.progress);
        assertEquals(-8, user.rank);
    }

    @Test
    public void userShouldCompleteActivity_minus5(){
        User user = new User();
        user.incProgress(-5);
        assertEquals(90, user.progress);
        assertEquals(-8, user.rank);
    }


    @Test
    public void userShouldCompleteActivity_minus4(){
        User user = new User();
        user.incProgress(-4);
        assertEquals(60, user.progress);
        assertEquals(-7, user.rank);
    }

    @Test
    public void userShouldCompleteActivity_minus8(){
        User user = new User(-8);
        user.incProgress(-8);
        assertEquals(3, user.progress);
        assertEquals(-8, user.rank);
    }

    @Test
    public void userRank_minus_7_ShouldCompleteActivity_minus8(){
        User user = new User(-7);
        user.incProgress(-8);
        assertEquals(1, user.progress);
        assertEquals(-7, user.rank);
    }

    @Test
    public void user_minus1ShouldCompleteActivity_1(){
        User user = new User(-1);

        user.incProgress(1);
        assertEquals(10, user.progress);
        assertEquals(-1, user.rank);
    }

    @Test
    public void shouldIncrementProgress(){
        User user = new User();
//        user.incProgress(1);
//        assertEquals(-2, user.rank);
        user.incProgress(8);
        assertEquals(0, user.progress);
    }



}