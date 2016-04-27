package com.zagniotov.puzzles.bitwise;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class CountingOneBitsTake1Test {

    final CountingOneBitsTake1 countingOneBitsTake1 = new CountingOneBitsTake1();

    @Test
    public void testCountBits1() throws Exception {
        int result = countingOneBitsTake1.countOneBits1(21);

        assertEquals(3, result);
    }

    @Test
    public void testCountBits2() throws Exception {
        int result = countingOneBitsTake1.countOneBits2(21);

        assertEquals(3, result);
    }

    @Test
    public void testCountBits3() throws Exception {
        int result = countingOneBitsTake1.countOneBits3(21);
        assertEquals(3, result);

        result = countingOneBitsTake1.countOneBits3(7);
        assertEquals(3, result);
    }

    @Test
    public void testCountBits() throws Exception {
        final CountingOneBitsTake1 countingOneBitsTake1 = new CountingOneBitsTake1();
        int[] result = countingOneBitsTake1.countOneBits4(5);

        assertEquals(Arrays.toString(new int[]{0, 1, 1, 2, 1, 2}), Arrays.toString(result));

        result = countingOneBitsTake1.countOneBits4(7);
        assertEquals(Arrays.toString(new int[]{0, 1, 1, 2, 1, 2, 2, 3}), Arrays.toString(result));
    }

    @Test
    public void playground() throws Exception {
        int n = 4;

        System.out.println((n & n - 1));
    }
}