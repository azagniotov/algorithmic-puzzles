package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegexParserTake2Test {

    @Test
    public void testIsMatch() throws Exception {
        final RegexParserTake2 regexParserTake2 = new RegexParserTake2();


        assertTrue(regexParserTake2.isMatch("abc", "^abc"));
        assertTrue(regexParserTake2.isMatch("abc", "abc"));
        assertTrue(regexParserTake2.isMatch("", ""));
        assertTrue(regexParserTake2.isMatch("abc", "*abc"));
        assertTrue(regexParserTake2.isMatch("abc", "w*abc"));
        assertTrue(regexParserTake2.isMatch("abc", "w*.bc"));
        assertTrue(regexParserTake2.isMatch("abc", "*"));
        assertTrue(regexParserTake2.isMatch("abc", "abc*"));
        assertTrue(regexParserTake2.isMatch("a", "a"));
        assertTrue(regexParserTake2.isMatch("ab", "a*"));


        assertFalse(regexParserTake2.isMatch("ab", "*a"));
        assertFalse(regexParserTake2.isMatch("abc", ""));
        assertFalse(regexParserTake2.isMatch("", "abc"));
    }
}