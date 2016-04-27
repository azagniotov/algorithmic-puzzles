package com.zagniotov.puzzles.bitwise;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerOfFourTake1Test {

    PowerOfFourTake1 powerOfFourTake1 = new PowerOfFourTake1();

    @Test
    public void testIsPowerOfFour() throws Exception {
        assertTrue(powerOfFourTake1.isPowerOfFour(1));
        assertTrue(powerOfFourTake1.isPowerOfFour(4));
        assertTrue(powerOfFourTake1.isPowerOfFour(16));
        assertTrue(powerOfFourTake1.isPowerOfFour(64));
        assertTrue(powerOfFourTake1.isPowerOfFour(256));

        assertFalse(powerOfFourTake1.isPowerOfFour(512));
    }
}