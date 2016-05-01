package com.zagniotov.puzzles.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Print2DArraySpiralOrderTake1Test {

    @Test
    public void testSpiral() throws Exception {

        final Print2DArraySpiralOrderTake1 spiralArray = new Print2DArraySpiralOrderTake1();

        assertEquals("[]", spiralArray.spiral(0, 0));
        assertEquals("[]", spiralArray.spiral(1, 0));
        assertEquals("[]", spiralArray.spiral(0, 1));
        assertEquals("[1]", spiralArray.spiral(1, 1));
        assertEquals("[1, 2]", spiralArray.spiral(2, 1));
        assertEquals("[1, 2, 4, 3]", spiralArray.spiral(2, 2));
        assertEquals("[1, 2, 3, 6, 5, 4]", spiralArray.spiral(2, 3));
        assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]", spiralArray.spiral(3, 3));
        assertEquals("[1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8]", spiralArray.spiral(4, 3));
        assertEquals("[1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]", spiralArray.spiral(4, 4));
        assertEquals("[1, 2, 3, 4, 8, 12, 16, 20, 19, 18, 17, 13, 9, 5, 6, 7, 11, 15, 14, 10]", spiralArray.spiral(5, 4));
        assertEquals("[1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]", spiralArray.spiral(4, 5));
    }
}