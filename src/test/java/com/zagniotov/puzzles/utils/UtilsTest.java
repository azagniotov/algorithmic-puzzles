package com.zagniotov.puzzles.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static com.zagniotov.puzzles.common.Utils.removeCharAt;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UtilsTest {

    @Test
    public void shouldRemoveFirstCharacterFromString() throws Exception {
        assertEquals("lex", removeCharAt(0, "Alex"));
    }

    @Test
    public void shouldRemoveLastCharacterFromString() throws Exception {
        assertEquals("Ale", removeCharAt("Alex".length() - 1, "Alex"));
    }

    @Test
    public void shouldRemoveMiddleCharacterFromString() throws Exception {
        assertEquals("Orage", removeCharAt(3, "Orange"));
    }
}
