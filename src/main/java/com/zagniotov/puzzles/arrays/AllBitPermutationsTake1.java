package com.zagniotov.puzzles.arrays;

/**
 * - The characters in the string are unique, i.e.: solution does not eliminate duplicate permutations
 * - The time complexity of this solutions is O(2^n)
 */
class AllBitPermutationsTake1 {

    AllBitPermutationsTake1() {

    }

    // Permutes not in order
    void permuteBits(final int numberOfBits) {

        final char[] chars = new char[numberOfBits];
        permuteBits(chars, numberOfBits);
    }

    private void permuteBits(final char[] chars, final int length) {
        if (length == 0) {
            System.out.println(chars);
        } else {
            chars[length - 1] = '0';
            permuteBits(chars, length - 1);
            chars[length - 1] = '1';
            permuteBits(chars, length - 1);
        }
    }

    public static void main(String[] args) {
        final AllBitPermutationsTake1 allBitPermutationsTake1 = new AllBitPermutationsTake1();

        allBitPermutationsTake1.permuteBits(3);
    }
}
