package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AnagramTake4Test {

    @Test
    public void testIsAnagram() throws Exception {

        final AnagramTake4 anagramTake4 = new AnagramTake4();

        assertTrue(anagramTake4.isAnagram("motherinlaw", "hitlerwoman"));
        assertTrue(anagramTake4.isAnagram("debitcard", "badcredit"));
        assertTrue(anagramTake4.isAnagram("DORMITORY", "DIRTYROOM"));
        assertTrue(anagramTake4.isAnagram("ASTRONOMERS", "NOMORESTARS"));
        assertTrue(anagramTake4.isAnagram("aaaba", "aaaab"));

        assertFalse(anagramTake4.isAnagram("toss", "snot"));
        assertFalse(anagramTake4.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake4.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake4.isAnagram("aaaaa", "baaaa"));
    }
}