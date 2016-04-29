package com.zagniotov.puzzles.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p>
 * For example,
 * Given "egg", "add", return true.
 * Given "paper", "title", return true.
 * Given "foo", "bar", return false.
 * Given "ab", "aa", return false.
 * Given "abba", "abab", return false.
 * <p>
 * Note:
 * You may assume both s and t have the same length.
 */
class IsomorphicStringTake1 {


    IsomorphicStringTake1() {

    }

    public boolean isIsomorphic(final String first, final String second) {
        final Map<Character, Character> paths = new HashMap<>();
        final Set<Character> mapped = new HashSet<>();

        final char[] firstChars = first.toCharArray();
        final char[] secondChars = second.toCharArray();

        int firstCharsLength = firstChars.length;
        if (firstCharsLength != secondChars.length) {
            return false;
        }

        for (int idx = 0; idx < firstCharsLength; idx++) {
            char currentChar = firstChars[idx];
            if (!paths.containsKey(currentChar)) {
                char destinationChar = secondChars[idx];
                if (mapped.contains(destinationChar)) {
                    //No two characters may map to the same character
                    return false;
                } else {
                    paths.put(currentChar, destinationChar);
                    mapped.add(destinationChar);
                }
            }

            firstChars[idx] = paths.get(currentChar);
            if (firstChars[idx] != secondChars[idx]) {
                return false;
            }
        }

        return true;
    }
}
