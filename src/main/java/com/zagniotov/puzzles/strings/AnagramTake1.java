package com.zagniotov.puzzles.strings;


import java.util.Arrays;

class AnagramTake1 {

    AnagramTake1() {

    }

    boolean isAnagram(final String first, final String second) {
        if (first.length() != second.length()) {
            return false;
        }

        final char[] firstChars = first.toCharArray();
        final int[] firstCharsCounter = new int[127]; //Enough space to cover numeric values of ASCII alpha-numeric characters

        for (char ch : firstChars) {
            int count = firstCharsCounter[ch] != 0 ? firstCharsCounter[ch] : 0;
            firstCharsCounter[ch] = count + 1;
        }

        final char[] secondChars = second.toCharArray();
        final int[] secondCharsCounter = new int[127]; //Enough space to cover numeric values of ASCII alpha-numeric characters

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
