package com.zagniotov.puzzles.strings;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class AnagramTake2 {

    AnagramTake2() {

    }

    // Assumes that strings will contain ASCII characters [0-9A-Z]
    boolean isAnagram(final String first, final String second) {
        if (first.length() != second.length()) {
            return false;
        }

        final char[] firstChars = first.toUpperCase().toCharArray();
        final int[] firstCharsCounter = new int[91]; //Enough space to cover numeric values of ASCII characters [0-9A-Z]

        for (char ch : firstChars) {
            int count = firstCharsCounter[ch] != 0 ? firstCharsCounter[ch] : 0;
            firstCharsCounter[ch] = count + 1;
        }

        final char[] secondChars = second.toUpperCase().toCharArray();
        final int[] secondCharsCounter = new int[91]; //Enough space to cover numeric values of ASCII characters [0-9A-Z]

        for (char ch : secondChars) {
            if (firstCharsCounter[ch] == 0) {
                return false;
            } else {
                int count = secondCharsCounter[ch] != 0 ? secondCharsCounter[ch] : 0;
                secondCharsCounter[ch] = count + 1;
            }
        }

        return Arrays.equals(firstCharsCounter, secondCharsCounter);
    }
}
