package com.zagniotov.puzzles.arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]
 */
class MoveZeroesTake1 {

    MoveZeroesTake1() {

    }

    int[] moveZeroes(final int[] numbers) {

        int totalZeroes = 0;
        for (int idx = 0; idx < numbers.length; idx++) {
            if (numbers[idx] == 0) {
                totalZeroes++;
            } else if (numbers[idx - totalZeroes] == 0) {
                int cache = numbers[idx];
                numbers[idx] = numbers[idx - totalZeroes];
                numbers[idx - totalZeroes] = cache;
            }
        }
        return numbers;
    }
}
