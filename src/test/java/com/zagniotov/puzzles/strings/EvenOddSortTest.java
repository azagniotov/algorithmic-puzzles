package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EvenOddSortTest {


    @Test
    public void shouldReturnEmptyString_WhenGivenIsNull() throws Exception {
        final EvenOddSort evenOddSort = new EvenOddSort();
        final String result = evenOddSort.sort(null);

        assertEquals("", result);
    }

    @Test
    public void shouldReturnEmptyString_WhenGivenIsEmpty() throws Exception {
        final EvenOddSort evenOddSort = new EvenOddSort();
        final String result = evenOddSort.sort("");

        assertEquals("", result);
    }

    @Test
    public void shouldReturnEmptyString_WhenGivenContainsSpacesOnly() throws Exception {
        final EvenOddSort evenOddSort = new EvenOddSort();
        final String result = evenOddSort.sort("");

        assertEquals("", result);
    }

    @Test
    public void shouldReturnSortedString() throws Exception {
        final EvenOddSort evenOddSort = new EvenOddSort();

        String result = evenOddSort.sort("12");
        assertEquals("21", result);

        result = evenOddSort.sort("12345");
        assertEquals("42315", result);

        result = evenOddSort.sort("2222222");
        assertEquals("2222222", result);

        result = evenOddSort.sort("211111");
        assertEquals("211111", result);

        result = evenOddSort.sort("212111");
        assertEquals("221111", result);

        result = evenOddSort.sort("0");
        assertEquals("0", result);

        result = evenOddSort.sort("23232323");
        assertEquals("22223333", result);
    }
}