package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AnagramTake6Test {

    @Test
    public void testIsAnagram() throws Exception {

        final AnagramTake6 anagramTake6 = new AnagramTake6();

        assertTrue(anagramTake6.isAnagram("motherinlaw", "hitlerwoman"));
        assertTrue(anagramTake6.isAnagram("debitcard", "badcredit"));
        assertTrue(anagramTake6.isAnagram("DORMITORY", "DIRTYROOM"));
        assertTrue(anagramTake6.isAnagram("ASTRONOMERS", "NOMORESTARS"));
        assertTrue(anagramTake6.isAnagram("aaaba", "aaaab"));

        assertFalse(anagramTake6.isAnagram("toss", "snot"));
        assertFalse(anagramTake6.isAnagram("benjo", "enjoy"));
        assertFalse(anagramTake6.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake6.isAnagram("aaaaa", "baaaa"));
    }
}