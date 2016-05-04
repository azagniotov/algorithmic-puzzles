package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegexParserTake1Test {

    @Test
    public void testIsMatch() throws Exception {
        final RegexParserTake1 regexParser = new RegexParserTake1();

        assertFalse(regexParser.isMatch("aa", "a"));
        assertFalse(regexParser.isMatch("aaa", "aa"));
        assertFalse(regexParser.isMatch("abc", "a.*b"));
        assertFalse(regexParser.isMatch("abc", ".a*c"));
        assertFalse(regexParser.isMatch("abbc", "ab*bbc"));

        assertTrue(regexParser.isMatch("abbbc", "ab*c"));
        assertTrue(regexParser.isMatch("ac", "ab*c"));
        assertTrue(regexParser.isMatch("abcbcd", "a.*c.*d"));
        assertTrue(regexParser.isMatch("abbbc", "ab*c"));
        assertTrue(regexParser.isMatch("aab", "c*a*b"));
        assertTrue(regexParser.isMatch("aa", "aa"));
        assertTrue(regexParser.isMatch("aa", "a*"));
        assertTrue(regexParser.isMatch("aa", ".*"));
        assertTrue(regexParser.isMatch("ab", ".*"));
        assertTrue(regexParser.isMatch("aaabbbabc", "*abc"));
        assertTrue(regexParser.isMatch("abca", ".b*c*a"));
        assertTrue(regexParser.isMatch("abc", "*"));
        assertTrue(regexParser.isMatch("abcdef", "a*"));
    }
}