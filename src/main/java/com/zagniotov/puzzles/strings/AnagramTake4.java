package com.zagniotov.puzzles.strings;

import java.util.Arrays;

class AnagramTake4 {

    AnagramTake4() {

    }

    boolean isAnagram(final String first, final String second) {
        if (first.length() != second.length()) {
            return false;
        }

        int counter = 0;
        int[] cache = new int[127];
        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();

        for (int idx = 0; idx < firstChars.length; idx++) {
            if (++cache[firstChars[idx]] == 1) {
                counter++;
            }
            if (--cache[secondChars[idx]] == 0) {
                counter--;
            }
        }

        return counter == 0;
    }
}