package com.zagniotov.puzzles.bitwise;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
class SingleNumberTake1 {

    SingleNumberTake1() {

    }

    /**
     * XOR:
     *
     * 00000111
     * 00000111
     * --------
     * 00000000
     */
    int singleNumber(int[] numbers) {
        int result = 0;
        for (int idx = 0; idx < numbers.length; idx++) {
            result = result ^ numbers[idx];
        }
        return result;
    }
}
