package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AnagramTake2Test {

    @Test
    public void testIsAnagram() throws Exception {

        final AnagramTake2 anagramTake2 = new AnagramTake2();

        assertTrue(anagramTake2.isAnagram("motherinlaw", "hitlerwoman"));
        assertTrue(anagramTake2.isAnagram("debitcard", "badcredit"));
        assertTrue(anagramTake2.isAnagram("DORMITORY", "DIRTYROOM"));
        assertTrue(anagramTake2.isAnagram("ASTRONOMERS", "NOMORESTARS"));

        assertFalse(anagramTake2.isAnagram("toss", "snot"));
        assertFalse(anagramTake2.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake2.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake2.isAnagram("aaaaa", "baaaa"));
    }
}