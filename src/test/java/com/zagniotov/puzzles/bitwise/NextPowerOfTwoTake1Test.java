package com.zagniotov.puzzles.bitwise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NextPowerOfTwoTake1Test {

    @Test
    public void testNextPowerOfTwo() throws Exception {

        NextPowerOfTwoTake1 nextPowerOfTwo = new NextPowerOfTwoTake1();

        assertEquals(2048, nextPowerOfTwo.nextPowerOfTwo(1025));
        assertEquals(2048, nextPowerOfTwo.nextPowerOfTwo(2047));
        assertEquals(4096, nextPowerOfTwo.nextPowerOfTwo(2048));
    }
}