package io.github.azagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ValidPalindromeTake2Test {

    @Test
    public void testIsPalindrome() throws Exception {
        ValidPalindromeTake2 ValidPalindromeTake2 = new ValidPalindromeTake2();

        assertTrue(ValidPalindromeTake2.isPalindrome("AmoreRoma"));
        assertTrue(ValidPalindromeTake2.isPalindrome("NotSoBoston"));
        assertTrue(ValidPalindromeTake2.isPalindrome("AManaPlanAcanalPanama"));
        assertTrue(ValidPalindromeTake2.isPalindrome("eeeeeweeeee"));
        assertTrue(ValidPalindromeTake2.isPalindrome("eeeee9eeeee"));
        assertTrue(ValidPalindromeTake2.isPalindrome("1weee9eeew1"));
        assertTrue(ValidPalindromeTake2.isPalindrome("a"));

        assertFalse(ValidPalindromeTake2.isPalindrome("raceacar"));
        assertFalse(ValidPalindromeTake2.isPalindrome("0P"));
        assertFalse(ValidPalindromeTake2.isPalindrome("aab"));
        assertFalse(ValidPalindromeTake2.isPalindrome("abccb1a"));


    }
}