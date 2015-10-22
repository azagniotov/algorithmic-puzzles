package linguistic_chains.io;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class InputReaderTest {

    private static final Map<Integer, Set<String>> DICT = new HashMap<>();

    @BeforeClass
    public static void beforeClass() throws Exception {
        DICT.putAll(new InputReader().loadDictionary("input/test.dictionary.txt"));
    }

    @Test
    public void shouldNotLoadOneLetterWords() throws Exception {
        assertFalse(DICT.containsKey(1));
    }

    @Test
    public void shouldNotLoadDuplicateWords() throws Exception {
        final Set<String> words = DICT.get(25); // length of someVeryLongRepeatingWord

        assertTrue(words.size() == 1);
        assertTrue(words.contains("someVeryLongRepeatingWord"));
    }

    @Test
    public void shouldLoadWordsWithDifferentCases() throws Exception {
        final Set<String> words = DICT.get(18); // length of AlexanderZagniotov

        assertTrue(words.size() == 2);
        assertTrue(words.contains("alexanderZagniotov"));
        assertTrue(words.contains("AlexanderZagniotov"));
    }
}
