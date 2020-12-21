package io.github.azagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IsomorphicStringTake1Test {

    @Test
    public void testIsIsomorphic() throws Exception {
        IsomorphicStringTake1 isomorphicStringTake1 = new IsomorphicStringTake1();

        assertTrue(isomorphicStringTake1.isIsomorphic("egg", "add"));
        assertTrue(isomorphicStringTake1.isIsomorphic("paper", "title"));

        assertFalse(isomorphicStringTake1.isIsomorphic("foo", "bar"));
        assertFalse(isomorphicStringTake1.isIsomorphic("aba", "baa"));
        assertFalse(isomorphicStringTake1.isIsomorphic("abba", "abab"));
        assertFalse(isomorphicStringTake1.isIsomorphic("ab", "aa"));
    }
}
