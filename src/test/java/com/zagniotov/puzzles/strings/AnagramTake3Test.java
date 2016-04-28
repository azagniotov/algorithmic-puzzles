package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AnagramTake3Test {

    @Test
    public void testIsAnagram() throws Exception {

        final AnagramTake3 anagramTake3 = new AnagramTake3();

        assertTrue(anagramTake3.isAnagram("motherinlaw", "hitlerwoman"));
        assertTrue(anagramTake3.isAnagram("debitcard", "badcredit"));
        assertTrue(anagramTake3.isAnagram("DORMITORY", "DIRTYROOM"));
        assertTrue(anagramTake3.isAnagram("ASTRONOMERS", "NOMORESTARS"));

        assertFalse(anagramTake3.isAnagram("toss", "snot"));
        assertFalse(anagramTake3.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake3.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake3.isAnagram("aaaaa", "baaaa"));
    }
}