package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AnagramTake2Test {

    @Test
    public void testIsAnagram() throws Exception {

        final AnagramTake2 anagramTake2 = new AnagramTake2();

        assertTrue(anagramTake2.isAnagram("MotherInLaw", "HitlerWoman"));
        assertTrue(anagramTake2.isAnagram("keEp", "peeK"));
        assertTrue(anagramTake2.isAnagram("SiLeNtCAT", "LisTenAcT"));
        assertTrue(anagramTake2.isAnagram("DebitCard", "BadCredit"));
        assertTrue(anagramTake2.isAnagram("SchoolMASTER", "TheClassROOM"));
        assertTrue(anagramTake2.isAnagram("DORMITORY", "DirtyRoom"));
        assertTrue(anagramTake2.isAnagram("ASTRONOMERS", "NOMORESTARS"));

        assertFalse(anagramTake2.isAnagram("Toss", "Shot"));
        assertFalse(anagramTake2.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake2.isAnagram("joy", "enjoy"));
        assertFalse(anagramTake2.isAnagram("aaaaa", "baaaa"));
    }
}