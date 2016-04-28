package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IsomorphicStringTake2Test {

    @Test
    public void testIsIsomorphic() throws Exception {
        IsomorphicStringTake2 isomorphicStringTake2 = new IsomorphicStringTake2();

        assertTrue(isomorphicStringTake2.isIsomorphic("egg", "add"));
        assertTrue(isomorphicStringTake2.isIsomorphic("paper", "title"));

        assertFalse(isomorphicStringTake2.isIsomorphic("foo", "bar"));
        assertFalse(isomorphicStringTake2.isIsomorphic("aba", "baa"));
        assertFalse(isomorphicStringTake2.isIsomorphic("abba", "abab"));
        assertFalse(isomorphicStringTake2.isIsomorphic("ab", "aa"));
    }
}
