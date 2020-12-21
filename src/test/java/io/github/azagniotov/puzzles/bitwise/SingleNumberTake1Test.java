package io.github.azagniotov.puzzles.bitwise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SingleNumberTake1Test {

    @Test
    public void testSingleNumber() throws Exception {
        SingleNumberTake1 singleNumberTake1 = new SingleNumberTake1();

        // 8 appears once
        int result = singleNumberTake1.singleNumber(new int[]{10, 3, 3, 8, 4, 4, 6, 7, 2, 7, 2, 6, 10});

        assertEquals(8, result);
    }
}