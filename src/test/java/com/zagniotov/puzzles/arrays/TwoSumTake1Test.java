package com.zagniotov.puzzles.arrays;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class TwoSumTake1Test {

    @Test
    public void testTwoSum() throws Exception {
        TwoSumTake1 twoSumTake1 = new TwoSumTake1();

        int[] indices = twoSumTake1.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertEquals(Arrays.toString(new int[]{0, 1}), Arrays.toString(indices));

        indices = twoSumTake1.twoSum(new int[]{-3, 4, 3, 90}, 0);
        assertEquals(Arrays.toString(new int[]{0, 2}), Arrays.toString(indices));
    }
}
