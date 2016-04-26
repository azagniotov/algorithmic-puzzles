package com.zagniotov.puzzles.bitwise;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class CountingBitsTake1Test {

    @Test
    public void testCountBits() throws Exception {
        final CountingBitsTake1 countingBitsTake1 = new CountingBitsTake1();
        int[] result = countingBitsTake1.countBits(5);

        assertEquals(Arrays.toString(new int[]{0, 1, 1, 2, 1, 2}), Arrays.toString(result));

        result = countingBitsTake1.countBits(7);
        assertEquals(Arrays.toString(new int[]{0, 1, 1, 2, 1, 2, 2, 3}), Arrays.toString(result));
    }
}