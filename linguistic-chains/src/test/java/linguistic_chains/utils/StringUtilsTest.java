package linguistic_chains.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StringUtilsTest {

    @Test
    public void shouldRemoveFirstCharacterFromString() throws Exception {
        assertEquals("lex", StringUtils.removeCharAt(0, "Alex"));
    }

    @Test
    public void shouldRemoveLastCharacterFromString() throws Exception {
        assertEquals("Ale", StringUtils.removeCharAt("Alex".length() - 1, "Alex"));
    }

    @Test
    public void shouldRemoveMiddleCharacterFromString() throws Exception {
        assertEquals("Orage", StringUtils.removeCharAt(3, "Orange"));
    }
}
