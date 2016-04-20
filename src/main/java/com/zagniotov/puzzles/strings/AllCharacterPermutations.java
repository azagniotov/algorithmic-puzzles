package com.zagniotov.puzzles.strings;

/**
 * - The characters in the string are unique, i.e.: solution does not eliminate duplicate permutations
 * - The time complexity of these solutions is O(n!)
 */
class AllCharacterPermutations {

    AllCharacterPermutations() {

    }

    // Permutes not in order
    void permuteArray(final char[] chars) {
        permuteArray(chars, chars.length);
    }

    private void permuteArray(final char[] chars, final int length) {
        if (length == 1) {
            System.out.println(chars);
        } else {
            for (int idx = 0; idx < length; idx++) {
                swap(chars, idx, length - 1);
                permuteArray(chars, length - 1);
                swap(chars, idx, length - 1);
            }
        }
    }

    // Permutes in order
    void permuteString(final String subject) {
        permuteString("", subject);
    }

    private void permuteString(final String prefix, final String suffix) {
        final int suffixLength = suffix.length();
        if (suffixLength == 1) {
            System.out.println(prefix + suffix);
        } else {
            for (int idx = 0; idx < suffixLength; idx++) {
                final String newPrefix = prefix + suffix.charAt(idx);
                final String newSuffix = suffix.substring(0, idx) + suffix.substring(idx + 1, suffixLength);
                permuteString(newPrefix, newSuffix);
            }
        }
    }

    private static void swap(char[] chars, final int leftPointer, final int rightPointer) {
        char cache = chars[leftPointer];
        chars[leftPointer] = chars[rightPointer];
        chars[rightPointer] = cache;
    }

    public static void main(String[] args) {
        final AllCharacterPermutations allCharacterPermutations = new AllCharacterPermutations();

        allCharacterPermutations.permuteString("abc");
        System.out.println("\n\n");
        allCharacterPermutations.permuteArray("abc".toCharArray());
    }
}
