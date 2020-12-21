package io.github.azagniotov.puzzles.strings;

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
class IsomorphicStringTake3 {


    IsomorphicStringTake3() {

    }

    // Assumes that strings will contain ASCII characters [0-9a-zA-Z]
    public boolean isIsomorphic(final String first, final String second) {
        if (first.length() != second.length()) {
            return false;
        }

        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();
        char[] paths = new char[127];
        char[] visited = new char[127];

        for (int idx = 0; idx < firstChars.length; idx++) {
            char current = firstChars[idx];
            char destination = secondChars[idx];
            if (paths[current] == 0) {
                if (visited[destination] != 0) {
                    return false;
                }
                paths[current] = destination;
                visited[destination] = destination;
            }

            if (paths[current] != destination) {
                return false;
            }
        }

        return true;
    }
}
