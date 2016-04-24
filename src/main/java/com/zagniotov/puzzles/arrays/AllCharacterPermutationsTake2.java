package com.zagniotov.puzzles.arrays;


import static com.zagniotov.puzzles.common.Utils.swapTwo;

class AllCharacterPermutationsTake2 {

    void permuteArray(final char[] chars) {
        permuteArray(chars, chars.length);
    }

    private void permuteArray(final char[] chars, final int length) {
        if (length == 1) {
            System.out.println(chars);
        } else {
            for (int idx = 0; idx < length; idx ++) {
                swapTwo(chars, idx, length - 1);
                permuteArray(chars, length - 1);
                swapTwo(chars, idx, length - 1);
            }
        }
    }

    public static void main(String[] args) {
        final AllCharacterPermutationsTake2 allCharacterPermutationsTake2 = new AllCharacterPermutationsTake2();

        allCharacterPermutationsTake2.permuteArray("abc".toCharArray());
    }
}
