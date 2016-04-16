package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EvenOddSortTest {


    @Test
    public void shouldReturnEmptyString_WhenGivenIsNull() throws Exception {
        final EvenOddSort evenOddSort = new EvenOddSort();
        final String result = evenOddSort.sort(null);

        assertEquals(result, "");
    }

    @Test
    public void shouldReturnEmptyString_WhenGivenIsEmpty() throws Exception {
        final EvenOddSort evenOddSort = new EvenOddSort();
        final String result = evenOddSort.sort("");

        assertEquals(result, "");
    }

    @Test
    public void shouldReturnEmptyString_WhenGivenContainsSpacesOnly() throws Exception {
        final EvenOddSort evenOddSort = new EvenOddSort();
        final String result = evenOddSort.sort("");

        assertEquals(result, "");
    }

    @Test
    public void shouldReturnSortedString() throws Exception {
        final EvenOddSort evenOddSort = new EvenOddSort();

        String result = evenOddSort.sort("12");
        assertEquals(result, "21");

        result = evenOddSort.sort("12345");
        assertEquals(result, "42315");

        result = evenOddSort.sort("2222222");
        assertEquals(result, "2222222");

        result = evenOddSort.sort("211111");
        assertEquals(result, "211111");

        result = evenOddSort.sort("212111");
        assertEquals(result, "221111");

        result = evenOddSort.sort("0");
        assertEquals(result, "0");

        result = evenOddSort.sort("23232323");
        assertEquals(result, "22223333");
    }
}