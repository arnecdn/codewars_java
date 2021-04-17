package com.github.arnecdn.codewars;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MazeTest2 {
    protected String name;
    protected String[] maze;
    protected boolean exp, error;

    public MazeTest2(String[] mze, boolean ex, String nme, boolean err) { name = nme; maze=mze; exp=ex; error=err; }

    @Test
    public void test() {
        if (error) {
            try {
                Maze.hasExit(Arrays.copyOf(maze,maze.length));
                fail("Your code should throw a RuntimeException when there isn't exactly one Kate");
            } catch (Exception e) {
                assertTrue(true);
            }
        } else {
            assertEquals(exp, Maze.hasExit(Arrays.copyOf(maze,maze.length)) );
        }
    }

    @Parameters(name="{2}")
    public static Collection<Object[]> config() {
        return Arrays.asList(
            new Object[] {
                new String[] {"k"}, true, "Simple tests - simplest case", false},
            new Object[] {
                new String[] {"###",
                    "#k#",
                    "###"}, false, "Simple tests - no exit case", false},
            new Object[] {
                new String[] {"###",
                    "#k ",
                    "###"}, true, "Simple tests - single exit case", false},
            new Object[] {
                new String[] {"k ",
                    "kk"}, false, "Simple tests - There should be no multiple Kates", true},
            new Object[] {
                new String[] {"########",
                    "# # ####",
                    "# #k#   ",
                    "# # # ##",
                    "# # # ##",
                    "#      #",
                    "########"}, true, "More difficult cases - single exit big maze", false},
            new Object[] {
                new String[] {"########",
                    "# # ## #",
                    "# #k#  #",
                    "# # # ##",
                    "# # #  #",
                    "#     ##",
                    "########"}, false, "no exit big maze", false}
        );
    }
}