package com.zagniotov.puzzles.arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]
 */
class MoveZeroesTake2 {

    MoveZeroesTake2() {

    }

    int[] moveZeroes(final int[] numbers) {

        int zeroCount = 0;
        for (int idx = 0; idx < numbers.length; idx++) {
            if (numbers[idx] == 0) {
                zeroCount++;
            } else if (numbers[idx] != 0 && numbers[idx - zeroCount] == 0) {
                numbers[idx - zeroCount] = numbers[idx];
                numbers[idx] = 0;
            }
        }

        return numbers;
    }
}
