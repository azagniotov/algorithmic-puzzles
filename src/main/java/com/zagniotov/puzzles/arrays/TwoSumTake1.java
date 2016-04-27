package com.zagniotov.puzzles.arrays;


import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example: given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSumTake1 {

    public TwoSumTake1() {

    }

    public int[] twoSum(final int[] nums, int target) {

        final Map<Integer, Integer> cache = new HashMap<>();
        final int[] indices = new int[2];
        for (int idx = 0; idx < nums.length; idx++) {
            final int difference = target - nums[idx];
            if (cache.containsKey(difference)) {
                indices[0] = cache.get(difference);
                indices[1] = idx;
                break;
            } else {
                cache.put(nums[idx], idx);
            }
        }

        return indices;
    }
}
