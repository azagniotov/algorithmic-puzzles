package com.zagniotov.puzzles.strings;

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
class IsomorphicStringTake2 {


    IsomorphicStringTake2() {

    }

    // Assumes that strings will contain ASCII characters [0-9a-zA-Z]
    public boolean isIsomorphic(final String first, final String second) {
        final char[] paths = new char[127];
        final char[] mapped = new char[127]; //Enough space to cover numeric values of ASCII characters [0-9a-zA-Z]

        final char[] firstChars = first.toCharArray();
        final char[] secondChars = second.toCharArray();

        int firstCharsLength = firstChars.length;
        if (firstCharsLength != secondChars.length) {
            return false;
        }

        for (int idx = 0; idx < firstCharsLength; idx++) {
            char currentChar = firstChars[idx];
            if (paths[currentChar] == 0) {
                char destinationChar = secondChars[idx];
                if (mapped[destinationChar] == destinationChar) {
                    //No two characters may map to the same character
                    return false;
                } else {
                    paths[currentChar] = destinationChar;
                    mapped[destinationChar] = destinationChar;
                }
            }
            if (paths[currentChar] != secondChars[idx]) {
                return false;
            }
        }

        return true;
    }
}
