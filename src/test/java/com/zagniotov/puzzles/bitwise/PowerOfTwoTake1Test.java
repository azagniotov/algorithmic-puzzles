package com.zagniotov.puzzles.bitwise;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PowerOfTwoTake1Test {

    PowerOfTwoTake1 powerOfTwoTake1 = new PowerOfTwoTake1();

    @Test
    public void testCheckPowerOfTwo() throws Exception {
        assertTrue(powerOfTwoTake1.isPowerOfTwo(1));
        assertTrue(powerOfTwoTake1.isPowerOfTwo(2));
        assertTrue(powerOfTwoTake1.isPowerOfTwo(4));
        assertTrue(powerOfTwoTake1.isPowerOfTwo(8));
        assertTrue(powerOfTwoTake1.isPowerOfTwo(16));

        assertFalse(powerOfTwoTake1.isPowerOfTwo(20));
    }


}