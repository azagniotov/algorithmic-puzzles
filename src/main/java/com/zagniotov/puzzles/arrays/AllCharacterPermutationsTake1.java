package com.zagniotov.puzzles.arrays;

import static com.zagniotov.puzzles.common.Utils.swapTwo;

/**
 * - The characters in the string are unique, i.e.: solution does not eliminate duplicate permutations
 * - The time complexity of these solutions is O(n!)
 */
class AllCharacterPermutationsTake1 {

    AllCharacterPermutationsTake1() {

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
                swapTwo(chars, idx, length - 1);
                permuteArray(chars, length - 1);
                swapTwo(chars, idx, length - 1);
            }
        }
    }

    public static void main(String[] args) {
        final AllCharacterPermutationsTake1 allCharacterPermutationsTake1 = new AllCharacterPermutationsTake1();

        allCharacterPermutationsTake1.permuteArray("abc".toCharArray());
    }
}
