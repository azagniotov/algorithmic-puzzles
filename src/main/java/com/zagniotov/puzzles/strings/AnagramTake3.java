package com.zagniotov.puzzles.strings;

import java.util.Arrays;

class AnagramTake3 {

    AnagramTake3() {

    }

    boolean isAnagram(final String first, final String second) {
        if (first.length() != second.length()) {
            return false;
        }

        int[] firstCache = new int[127];
        char[] firstChars = first.toCharArray();
        for (char current : firstChars) {
            int count = firstCache[current] != 0 ? firstCache[current] : 0;
            firstCache[current] = count + 1;
        }

        int[] secondCache = new int[127];
        char[] secondChars = second.toCharArray();
        for (char current : secondChars) {
            if (firstCache[current] == 0) {
                return false;
            }
            int count = secondCache[current] != 0 ? secondCache[current] : 0;
            secondCache[current] = count + 1;
        }

        return Arrays.equals(firstCache, secondCache);
    }
}