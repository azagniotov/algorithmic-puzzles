package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseWordsTake1Test {

    @Test
    public void testReverse() throws Exception {
        final ReverseWordsTake1 reverseStringWords = new ReverseWordsTake1();

        String result = reverseStringWords.reverse("hey");
        assertEquals("hey", result);

        result = reverseStringWords.reverse("a");
        assertEquals("a", result);

        result = reverseStringWords.reverse("hey hello world this is a story");
        assertEquals("story a is this world hello hey", result);
    }
}