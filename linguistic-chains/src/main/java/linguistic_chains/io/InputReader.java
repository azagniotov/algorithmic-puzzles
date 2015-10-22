package linguistic_chains.io;

import linguistic_chains.common.annotations.VisibleForTesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class InputReader {

    private static final String DICTIONARY_FILE_PARENT_DIR = System.getProperty("user.dir") + File.separatorChar;

    @VisibleForTesting
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public Map<Integer, Set<String>> loadDictionary(final String filename) throws IOException {
        try (final BufferedReader bufferedReader =
                     Files.newBufferedReader(Paths.get(DICTIONARY_FILE_PARENT_DIR + filename), DEFAULT_CHARSET)) {
            return populateWordsByLength(bufferedReader);
        }
    }

    @VisibleForTesting
    public static Map<Integer, Set<String>> populateWordsByLength(final BufferedReader bufferedReader) throws IOException {
        final Map<Integer, Set<String>> wordsByLength = new HashMap<>();
        while (true) {
            final String line = bufferedReader.readLine();
            if (line == null || line.trim().isEmpty()) {
                break;
            }
            final int lineLength = line.length();
            // Skip over words with less than 2 characters
            if (lineLength < 2) {
                continue;
            }
            if (!wordsByLength.containsKey(lineLength)) {
                wordsByLength.put(lineLength, new HashSet<String>());
            }
            wordsByLength.get(lineLength).add(line);
        }
        return wordsByLength;
    }
}
