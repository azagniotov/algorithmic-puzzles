package io.github.azagniotov.puzzles.strings;


public class AnagramTake3 {

    AnagramTake3() {

    }

    boolean isAnagram(final String first, final String second) {
        if (first.length() != second.length()) {
            return false;
        }

        int counter = 0;
        final char[] firstChars = first.toLowerCase().toCharArray();
        final char[] secondChars = second.toLowerCase().toCharArray();
        final int[] cache = new int[127];

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
