package com.zagniotov.puzzles.strings;


class AnagramTake2 {

    AnagramTake2() {

    }

    // Assumes that strings will contain only the same cased ASCII characters
    boolean isAnagram(final String first, final String second) {
        if (first.length() != second.length()) {
            return false;
        }

        final char[] firstChars = first.toCharArray();
        final char[] secondChars = second.toCharArray();
        final int[] mapping = new int[127]; //Enough space to cover numeric values of ASCII characters [0-9a-zA-Z]
        int counter = 0;

        for (int idx = 0; idx < firstChars.length; idx++) {

            if (++mapping[firstChars[idx]] == 1) {
                counter++;
            }
            if (--mapping[secondChars[idx]] == 0) {
                counter--;
            }
        }

        return counter == 0;
    }
}
