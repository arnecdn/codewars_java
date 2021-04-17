package com.github.arnecdn.codewars;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Predicate;
import java.awt.Point;
import org.junit.runners.JUnit4;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class MazeTest {

    @Test
    public void tesSinglet() {
                assertEquals(true, Maze.hasExit(new String[] {
                    "#######",
                    "#k#   #",
                    "# # # #",
                    "#   # #",
                    "#######"
                        }));
    }

    public static Collection<Object[]> config() {
        return Arrays.asList(
            new Object[] {
                new String[] {"k"}, true, "Simple tests - simplest case", false},
            new Object[] {
                new String[] {  "###",
                                "#k#",
                                "###"}, false, "Simple tests - no exit case", false},
            new Object[] {
                new String[] {  "###",
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