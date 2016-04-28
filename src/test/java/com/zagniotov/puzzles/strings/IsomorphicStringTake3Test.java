package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IsomorphicStringTake3Test {

    @Test
    public void testIsIsomorphic() throws Exception {
        IsomorphicStringTake3 isomorphicStringTake3 = new IsomorphicStringTake3();

        assertTrue(isomorphicStringTake3.isIsomorphic("egg", "add"));
        assertTrue(isomorphicStringTake3.isIsomorphic("paper", "title"));

        assertFalse(isomorphicStringTake3.isIsomorphic("foo", "bar"));
        assertFalse(isomorphicStringTake3.isIsomorphic("aba", "baa"));
        assertFalse(isomorphicStringTake3.isIsomorphic("abba", "abab"));
        assertFalse(isomorphicStringTake3.isIsomorphic("ab", "aa"));
    }
}
