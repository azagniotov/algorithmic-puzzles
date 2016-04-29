package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AnagramTake1Test {

    @Test
    public void testIsAnagram() throws Exception {

        final AnagramTake1 anagramTake1 = new AnagramTake1();

        assertTrue(anagramTake1.isAnagram("motherinlaw", "hitlerwoman"));
        assertTrue(anagramTake1.isAnagram("debitcard", "badcredit"));
        assertTrue(anagramTake1.isAnagram("DORMITORY", "DIRTYROOM"));
        assertTrue(anagramTake1.isAnagram("ASTRONOMERS", "NOMORESTARS"));

        assertFalse(anagramTake1.isAnagram("toss", "snot"));
        assertFalse(anagramTake1.isAnagram("benjo", "enjoy"));
        assertFalse(anagramTake1.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake1.isAnagram("aaaaa", "baaaa"));
    }
}