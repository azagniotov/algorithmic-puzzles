package io.github.azagniotov.puzzles.math;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example, given nums = [0, 1, 3] return 2.
 */
class MissingNumberTake1 {

    MissingNumberTake1() {

    }

    public int missingNumber(final int[] nums) {
        int length = nums.length;
        int sum = (length * (length + 1)) / 2;
        for (int idx = 0; idx < length; idx++) {
            sum -= nums[idx];
        }
        return sum;
    }
}
