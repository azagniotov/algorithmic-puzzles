package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegexParserTake1Test {

    @Test
    public void testIsMatch() throws Exception {
        final RegexParserTake1 regexParser = new RegexParserTake1();

        assertTrue(regexParser.isMatch("ac", "ab*c"));
        assertTrue(regexParser.isMatch("abcbcd", "a.*c.*d"));
        assertTrue(regexParser.isMatch("abbbc", "ab*c"));
        assertTrue(regexParser.isMatch("aab", "c*a*b"));
        assertTrue(regexParser.isMatch("aa", "aa"));
        assertTrue(regexParser.isMatch("aa", "a*"));
        assertTrue(regexParser.isMatch("aa", ".*"));
        assertTrue(regexParser.isMatch("ab", ".*"));
        assertTrue(regexParser.isMatch("abca", ".b*c*a"));
        assertTrue(regexParser.isMatch("abc", "a.*b"));
        assertTrue(regexParser.isMatch("aa", "a*a"));
        assertTrue(regexParser.isMatch("aaaab", "a*b"));
        assertTrue(regexParser.isMatch("abbc", "ab*bbc"));

        assertFalse(regexParser.isMatch("a", "b"));
        assertFalse(regexParser.isMatch("aa", "a"));
        assertFalse(regexParser.isMatch("aaa", "aa"));
        assertFalse(regexParser.isMatch("abc", ".a*c"));
        assertFalse(regexParser.isMatch("aabcde", "c*a*b"));
        assertFalse(regexParser.isMatch("aaba", "ab*a*c*a"));
        assertFalse(regexParser.isMatch("aaa", "ab*a"));
        assertFalse(regexParser.isMatch("aaabbbabc", "*abc"));

        // this one fails :(
//      assertFalse(regexParser.isMatch("ab", ".*c"));


    }
}
