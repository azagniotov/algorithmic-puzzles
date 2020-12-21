package io.github.azagniotov.puzzles.strings;

class AnagramTake2 {

    AnagramTake2() {

    }

    boolean isAnagram(final String first, final String second) {
        if (first.length() != second.length()) {
            return false;
        }

        int counter = 0;
        int[] cache = new int[128];
        char[] firstChars = first.toLowerCase().toCharArray();
        char[] secondChars = second.toLowerCase().toCharArray();

        for (int idx = 0; idx < first.length(); idx++) {
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
