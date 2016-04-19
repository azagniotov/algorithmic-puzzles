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

        String result = evenOddSortTake2.segregate("12");
        assertEquals("21", result);

        result = evenOddSortTake2.segregate("12345");
        assertEquals("42315", result);

        result = evenOddSortTake2.segregate("2222222");
        assertEquals("2222222", result);

        result = evenOddSortTake2.segregate("211111");
        assertEquals("211111", result);

        result = evenOddSortTake2.segregate("212111");
        assertEquals("221111", result);

        result = evenOddSortTake2.segregate("0");
        assertEquals("0", result);

        result = evenOddSortTake2.segregate("23232323");
        assertEquals("22223333", result);
    }
}