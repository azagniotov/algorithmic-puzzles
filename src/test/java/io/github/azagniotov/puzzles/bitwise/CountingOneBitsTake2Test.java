package io.github.azagniotov.puzzles.bitwise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CountingOneBitsTake2Test {

    final CountingOneBitsTake2 countingOneBitsTake2 = new CountingOneBitsTake2();

    @Test
    public void testCountBits1() throws Exception {
        int result = countingOneBitsTake2.countOneBits1(21);
        assertEquals(3, result);

        result = countingOneBitsTake2.countOneBits1(7);
        assertEquals(3, result);
    }

    @Test
    public void testCountBits2() throws Exception {
        int result = countingOneBitsTake2.countOneBits2(21);
        assertEquals(3, result);

        result = countingOneBitsTake2.countOneBits2(7);
        assertEquals(3, result);
    }
}