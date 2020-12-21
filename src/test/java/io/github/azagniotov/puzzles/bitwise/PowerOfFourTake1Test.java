package io.github.azagniotov.puzzles.bitwise;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerOfFourTake1Test {

    PowerOfFourTake1 powerOfFourTake1 = new PowerOfFourTake1();

    @Test
    public void testIsPowerOfFour1() throws Exception {
        assertTrue(powerOfFourTake1.isPowerOfFour1(1));
        assertTrue(powerOfFourTake1.isPowerOfFour1(4));
        assertTrue(powerOfFourTake1.isPowerOfFour1(16));
        assertTrue(powerOfFourTake1.isPowerOfFour1(64));
        assertTrue(powerOfFourTake1.isPowerOfFour1(256));

        assertFalse(powerOfFourTake1.isPowerOfFour1(512));
    }

    @Test
    public void testIsPowerOfFour2() throws Exception {
        assertTrue(powerOfFourTake1.isPowerOfFour2(1));
        assertTrue(powerOfFourTake1.isPowerOfFour2(4));
        assertTrue(powerOfFourTake1.isPowerOfFour2(16));
        assertTrue(powerOfFourTake1.isPowerOfFour2(64));
        assertTrue(powerOfFourTake1.isPowerOfFour2(256));

        assertFalse(powerOfFourTake1.isPowerOfFour2(512));
    }
}