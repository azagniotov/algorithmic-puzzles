package io.github.azagniotov.puzzles.strings;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringCharactersTake1Test {

    @Test
    public void shouldReverseString() throws Exception {
        final ReverseStringCharactersTake1 reverseStringCharactersTake1 = new ReverseStringCharactersTake1();

        String result = reverseStringCharactersTake1.reverse("1");
        assertEquals("1", result);

        result = reverseStringCharactersTake1.reverse("   ");
        assertEquals("", result);

        result = reverseStringCharactersTake1.reverse(null);
        assertEquals("", result);

        result = reverseStringCharactersTake1.reverse("211111");
        assertEquals("111112", result);
    }
}
