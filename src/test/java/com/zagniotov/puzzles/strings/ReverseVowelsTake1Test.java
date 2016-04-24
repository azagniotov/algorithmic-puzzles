package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ReverseVowelsTake1Test {

    @Test
    public void testReverseVowels() throws Exception {
        ReverseVowelsTake1 reverseVowelsTake1 = new ReverseVowelsTake1();

        String result = reverseVowelsTake1.reverseVowels("hey");
        assertEquals("hey", result);

        result = reverseVowelsTake1.reverseVowels("hello");
        assertEquals("holle", result);

        result = reverseVowelsTake1.reverseVowels("leetcode");
        assertEquals("leotcede", result);
    }
}