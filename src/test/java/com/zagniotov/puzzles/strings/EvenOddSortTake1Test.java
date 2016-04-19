package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EvenOddSortTake1Test {


    @Test
    public void shouldReturnEmptyString_WhenGivenStringIsNull() throws Exception {
        final EvenOddSortTake1 evenOddSortTake1 = new EvenOddSortTake1();
        final String result = evenOddSortTake1.segregate(null);

        assertEquals("", result);
    }

    @Test
    public void shouldReturnEmptyString_WhenGivenIsEmptyString() throws Exception {
        final EvenOddSortTake1 evenOddSortTake1 = new EvenOddSortTake1();
        final String result = evenOddSortTake1.segregate("");

        assertEquals("", result);
    }

    @Test
    public void shouldReturnEmptyString_WhenGivenStringContainsSpacesOnly() throws Exception {
        final EvenOddSortTake1 evenOddSortTake1 = new EvenOddSortTake1();
        final String result = evenOddSortTake1.segregate("   ");

        assertEquals("", result);
    }

    @Test
    public void shouldReturnSortedString() throws Exception {
        final EvenOddSortTake1 evenOddSortTake1 = new EvenOddSortTake1();

        String result = evenOddSortTake1.segregate("12");
        assertEquals("21", result);

        result = evenOddSortTake1.segregate("12345");
        assertEquals("42315", result);

        result = evenOddSortTake1.segregate("2222222");
        assertEquals("2222222", result);

        result = evenOddSortTake1.segregate("211111");
        assertEquals("211111", result);

        result = evenOddSortTake1.segregate("212111");
        assertEquals("221111", result);

        result = evenOddSortTake1.segregate("0");
        assertEquals("0", result);

        result = evenOddSortTake1.segregate("23232323");
        assertEquals("22223333", result);
    }
}
