package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EvenOddSortTake2Test {


    @Test
    public void shouldReturnEmptyString_WhenGivenIsNull() throws Exception {
        final EvenOddSortTake2 evenOddSortTake2 = new EvenOddSortTake2();
        final String result = evenOddSortTake2.segregate(null);

        assertEquals("", result);
    }

    @Test
    public void shouldReturnEmptyString_WhenGivenIsEmpty() throws Exception {
        final EvenOddSortTake2 evenOddSortTake2 = new EvenOddSortTake2();
        final String result = evenOddSortTake2.segregate("");

        assertEquals("", result);
    }

    @Test
    public void shouldReturnEmptyString_WhenGivenContainsSpacesOnly() throws Exception {
        final EvenOddSortTake2 evenOddSortTake2 = new EvenOddSortTake2();
        final String result = evenOddSortTake2.segregate("");

        assertEquals("", result);
    }

    @Test
    public void shouldReturnSortedString() throws Exception {
        final EvenOddSortTake2 evenOddSortTake2 = new EvenOddSortTake2();

        String result = evenOddSortTake2.segregate("1222112221");
        assertEquals("2222221111", result);
    }
}