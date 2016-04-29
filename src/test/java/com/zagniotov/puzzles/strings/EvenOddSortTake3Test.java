package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EvenOddSortTake3Test {

    @Test
    public void shouldReturnSortedString() throws Exception {
        final EvenOddSortTake3 evenOddSortTake3 = new EvenOddSortTake3();

        String result = evenOddSortTake3.segregate("1222112221");
        assertEquals("2222221111", result);

        result = evenOddSortTake3.segregate("12");
        assertEquals("21", result);

        result = evenOddSortTake3.segregate("2");
        assertEquals("2", result);
    }
}