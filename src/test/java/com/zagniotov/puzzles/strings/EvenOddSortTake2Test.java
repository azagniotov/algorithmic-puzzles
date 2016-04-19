package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EvenOddSortTake2Test {


    @Test
    public void shouldReturnEmptyString_WhenGivenIsNull() throws Exception {
        final EvenOddSortTake2 EvenOddSortTake2 = new EvenOddSortTake2();
        final String result = EvenOddSortTake2.sort(null);

        assertEquals("", result);
    }

    @Test
    public void shouldReturnEmptyString_WhenGivenIsEmpty() throws Exception {
        final EvenOddSortTake2 EvenOddSortTake2 = new EvenOddSortTake2();
        final String result = EvenOddSortTake2.sort("");

        assertEquals("", result);
    }

    @Test
    public void shouldReturnEmptyString_WhenGivenContainsSpacesOnly() throws Exception {
        final EvenOddSortTake2 EvenOddSortTake2 = new EvenOddSortTake2();
        final String result = EvenOddSortTake2.sort("");

        assertEquals("", result);
    }

    @Test
    public void shouldReturnSortedString() throws Exception {
        final EvenOddSortTake2 evenOddSortTake2 = new EvenOddSortTake2();

        String result = evenOddSortTake2.sort("12");
        assertEquals("21", result);

        result = evenOddSortTake2.sort("12345");
        assertEquals("42315", result);

        result = evenOddSortTake2.sort("2222222");
        assertEquals("2222222", result);

        result = evenOddSortTake2.sort("211111");
        assertEquals("211111", result);

        result = evenOddSortTake2.sort("212111");
        assertEquals("221111", result);

        result = evenOddSortTake2.sort("0");
        assertEquals("0", result);

        result = evenOddSortTake2.sort("23232323");
        assertEquals("22223333", result);
    }
}