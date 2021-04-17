package com.github.arnecdn.codewars;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class CrackerTest {
    @Test
    public void testExamples() {
       assertEquals("GoOutside", Cracker.crackSha256("b8c49d81cb795985c007d78379e98613a4dfc824381be472238dbd2f974e37ae", "deGioOstu"));
//        assertEquals(null, Cracker.crackSha256("f58262c8005bb64b8f99ec6083faf050c502d099d9929ae37ffed2fe1bb954fb", "abc"));
    }


}