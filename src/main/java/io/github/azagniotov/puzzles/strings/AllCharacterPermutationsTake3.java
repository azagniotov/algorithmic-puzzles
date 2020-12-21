package io.github.azagniotov.puzzles.strings;

/**
 * - The characters in the string are unique, i.e.: solution does not eliminate duplicate permutations
 * - The time complexity of these solutions is O(n!)
 */
class AllCharacterPermutationsTake3 {

    AllCharacterPermutationsTake3() {

    }

    // Permutes in order
    void permuteString(final String subject) {
        char[] chars = subject.toCharArray();
        permuteString(chars, chars.length);
    }

    private void permuteString(final char[] chars, final int length) {
        if (length == 1) {
            System.out.println(chars);
        } else {
            for (int idx = 0; idx < length; idx++) {

                char cache = chars[idx];
                chars[idx] = chars[length - 1];
                chars[length - 1] = cache;

                permuteString(chars, length - 1);

                cache = chars[idx];
                chars[idx] = chars[length - 1];
                chars[length - 1] = cache;
            }
        }
    }

    public static void main(String[] args) {
        final AllCharacterPermutationsTake3 allCharacterPermutations = new AllCharacterPermutationsTake3();

        allCharacterPermutations.permuteString("abc");
    }
}
