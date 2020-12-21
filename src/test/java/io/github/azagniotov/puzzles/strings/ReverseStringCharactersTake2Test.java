package io.github.azagniotov.puzzles.strings;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringCharactersTake2Test {

    @Test
    public void shouldReverseString() throws Exception {
        final ReverseStringCharactersTake2 reverseStringCharactersTake2 = new ReverseStringCharactersTake2();

        String result = reverseStringCharactersTake2.reverse("1");
        assertEquals("1", result);

        result = reverseStringCharactersTake2.reverse("211111");
        assertEquals("111112", result);
    }
}
