package io.github.azagniotov.puzzles.arrays;


class AllCharacterPermutationsTake2 {

    void permuteArray(final char[] chars) {
        permuteArray(chars, chars.length);
    }

    private void permuteArray(final char[] chars, final int length) {
        if (length == 1) {
            System.out.println(chars);
        } else {
            for (int idx = 0; idx < length; idx++) {
                char cache = chars[idx];
                chars[idx] = chars[length - 1];
                chars[length - 1] = cache;

                permuteArray(chars, length - 1);

                cache = chars[idx];
                chars[idx] = chars[length - 1];
                chars[length - 1] = cache;
            }
        }
    }

    public static void main(String[] args) {
        final AllCharacterPermutationsTake2 allCharacterPermutationsTake2 = new AllCharacterPermutationsTake2();

        allCharacterPermutationsTake2.permuteArray("abc".toCharArray());
    }
}
