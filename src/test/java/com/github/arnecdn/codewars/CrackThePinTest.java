package com.github.arnecdn.codewars;

import static org.junit.Assert.*;

import org.junit.Test;

public class CrackThePinTest {
    CrackThePin objTF = new CrackThePin();

    @Test
    public void simple_test() {
        assertEquals("Should work with simple PIN", "12345", objTF.crack("827ccb0eea8a706c4c34a16891f84e7b"));
    }
    @Test
    public void harder_test() {
        assertEquals("Should work with harder PIN", "00078", objTF.crack("86aa400b65433b608a9db30070ec60cd"));
    }
    @Test
    public void harder_test2() {
        assertEquals("Should work with harder PIN", "99999", objTF.crack("96aa400b65433b608a9db30070ec60cd"));
    }

}