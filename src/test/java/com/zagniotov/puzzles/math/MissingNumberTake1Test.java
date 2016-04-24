package com.zagniotov.puzzles.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissingNumberTake1Test {

    @Test
    public void testMissingNumber() throws Exception {
        MissingNumberTake1 missingNumberTake1 = new MissingNumberTake1();

        final int[] data = {0, 1, 2, 3, 4, 5, 6, 8, 9};
        final int result = missingNumberTake1.missingNumber(data);

        assertEquals(7, result);
    }
}