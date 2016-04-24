package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class AnagramTake1Test {

    @Test
    public void testIsAnagram() throws Exception {

        final AnagramTake1 anagramTake1 = new AnagramTake1();

        assertTrue(anagramTake1.isAnagram("MotherInLaw", "HitlerWoman"));
        assertTrue(anagramTake1.isAnagram("keEp", "peeK"));
        assertTrue(anagramTake1.isAnagram("SiLeNtCAT", "LisTenAcT"));
        assertTrue(anagramTake1.isAnagram("DebitCard", "BadCredit"));
        assertTrue(anagramTake1.isAnagram("SchoolMASTER", "TheClassROOM"));
        assertTrue(anagramTake1.isAnagram("DORMITORY", "DirtyRoom"));
        assertTrue(anagramTake1.isAnagram("ASTRONOMERS", "NOMORESTARS"));

        assertFalse(anagramTake1.isAnagram("Toss", "Shot"));
        assertFalse(anagramTake1.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake1.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake1.isAnagram("aaaaa", "baaaa"));
    }
}