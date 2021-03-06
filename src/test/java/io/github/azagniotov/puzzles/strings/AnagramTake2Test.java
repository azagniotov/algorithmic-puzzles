package io.github.azagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AnagramTake2Test {

    @Test
    public void testIsAnagram() throws Exception {

        final AnagramTake3 anagramTake = new AnagramTake3();

        assertTrue(anagramTake.isAnagram("motherinlaw", "hitlerwoman"));
        assertTrue(anagramTake.isAnagram("debitcard", "badcredit"));
        assertTrue(anagramTake.isAnagram("DORMITORY", "DIRTYROOM"));
        assertTrue(anagramTake.isAnagram("ASTRONOMERS", "NOMORESTARS"));
        assertTrue(anagramTake.isAnagram("aaaba", "aaaab"));
        assertTrue(anagramTake.isAnagram("Astronomer", "MoonStarer"));
        assertTrue(anagramTake.isAnagram("PrincessDiana", "EndIsACarSpin"));
        assertTrue(anagramTake.isAnagram("YearTwoThousand", "AYearToShutDown"));
        assertTrue(anagramTake.isAnagram("aaxju", "juxaa"));

        assertFalse(anagramTake.isAnagram("toss", "snot"));
        assertFalse(anagramTake.isAnagram("benjo", "enjoy"));
        assertFalse(anagramTake.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake.isAnagram("aaaaa", "baaaa"));
    }
}