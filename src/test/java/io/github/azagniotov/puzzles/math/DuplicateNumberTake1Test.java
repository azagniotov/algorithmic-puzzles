package io.github.azagniotov.puzzles.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DuplicateNumberTake1Test {

    @Test
    public void testDuplicateNumber1() throws Exception {
        DuplicateNumberTake1 duplicateNumberTake1 = new DuplicateNumberTake1();

        // 8 is duplicate
        int result = duplicateNumberTake1.duplicateNumber1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 8, 0});

        assertEquals(8, result);
    }

    @Test
    public void testDuplicateNumber2() throws Exception {
        DuplicateNumberTake1 duplicateNumberTake1 = new DuplicateNumberTake1();

        // 8 is duplicate
        int result = duplicateNumberTake1.duplicateNumber2(new int[]{1, 2, 6, 3, 7, 4, 12, 5, 8, 9, 10, 11, 8, 13, 14, 15});
        assertEquals(8, result);

        // 4 is duplicate
        result = duplicateNumberTake1.duplicateNumber2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 4, 9});
        assertEquals(4, result);
    }
}