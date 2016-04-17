package com.zagniotov.puzzles.strings;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringTake1Test {

    @Test
    public void shouldReverseString() throws Exception {
        final ReverseStringTake1 reverseStringTake1 = new ReverseStringTake1();

        String result = reverseStringTake1.reverse("1");
        assertEquals("1", result);

        result = reverseStringTake1.reverse("");
        assertEquals("", result);

        result = reverseStringTake1.reverse(null);
        assertEquals("", result);

        result = reverseStringTake1.reverse("211111");
        assertEquals("111112", result);
    }
}