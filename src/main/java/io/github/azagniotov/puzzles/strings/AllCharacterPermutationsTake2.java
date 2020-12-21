package io.github.azagniotov.puzzles.strings;

/**
 * - The characters in the string are unique, i.e.: solution does not eliminate duplicate permutations
 * - The time complexity of these solutions is O(n!)
 */
class AllCharacterPermutationsTake2 {

    AllCharacterPermutationsTake2() {

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

    public static void main(String[] args) {
        final AllCharacterPermutationsTake2 allCharacterPermutationsTake2 = new AllCharacterPermutationsTake2();

        allCharacterPermutationsTake2.permuteString("abc");
    }
}
