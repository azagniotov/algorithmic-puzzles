package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AnagramTake5Test {

    @Test
    public void testIsAnagram() throws Exception {

        final AnagramTake5 anagramTake5 = new AnagramTake5();

        assertTrue(anagramTake5.isAnagram("motherinlaw", "hitlerwoman"));
        assertTrue(anagramTake5.isAnagram("debitcard", "badcredit"));
        assertTrue(anagramTake5.isAnagram("DORMITORY", "DIRTYROOM"));
        assertTrue(anagramTake5.isAnagram("ASTRONOMERS", "NOMORESTARS"));
        assertTrue(anagramTake5.isAnagram("aaaba", "aaaab"));

        assertFalse(anagramTake5.isAnagram("toss", "snot"));
        assertFalse(anagramTake5.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake5.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake5.isAnagram("aaaaa", "baaaa"));
    }
}