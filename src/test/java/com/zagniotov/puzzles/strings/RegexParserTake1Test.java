package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegexParserTake1Test {

    @Test
    public void testIsMatch() throws Exception {
        final RegexParserTake1 regexParserTake1 = new RegexParserTake1();

        assertFalse(regexParserTake1.isMatch("aa", "a"));
        assertFalse(regexParserTake1.isMatch("aaa", "aa"));
        assertFalse(regexParserTake1.isMatch("abc", "a.*b"));
        assertFalse(regexParserTake1.isMatch("abc", ".a*c"));

        assertTrue(regexParserTake1.isMatch("aab", "c*a*b"));
        assertTrue(regexParserTake1.isMatch("aa", "aa"));
        assertTrue(regexParserTake1.isMatch("aa", "a*"));
        assertTrue(regexParserTake1.isMatch("aa", ".*"));
        assertTrue(regexParserTake1.isMatch("ab", ".*"));
        assertTrue(regexParserTake1.isMatch("aaabbbabc", "*abc"));
        assertTrue(regexParserTake1.isMatch("abca", ".b*c*a"));
        assertTrue(regexParserTake1.isMatch("abc", "*"));
        assertTrue(regexParserTake1.isMatch("abcdef", "a*"));
    }
}