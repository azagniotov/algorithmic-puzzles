package com.zagniotov.puzzles.strings;


import java.util.HashSet;
import java.util.Set;

class CountWordsInStringTake1 {


    CountWordsInStringTake1() {

    }

    int countWords(final String subject) {
        if (subject == null || subject.trim().equals("")) {
            return 0;
        }

        final char[] chars = subject.toCharArray();
        int wordCounter = 1;
        for (char aChar : chars) {
            if (aChar == ' ') {
                ++wordCounter;
            }
        }

        return wordCounter;
    }

    int countUniqueWords(final String subject) {
        if (subject == null || subject.trim().equals("")) {
            return 0;
        }

        final Set<String> usedWords = new HashSet<>();
        final char[] chars = subject.toCharArray();
        int wordCounter = 0;
        int wordLastStart = 0;
        int wordLastEnd;
        for (int idx = 0; idx < chars.length; idx++) {
            if (chars[idx] == ' ') {

                wordLastEnd = idx - 1;
                while (isInvalid(chars[wordLastEnd]) &&  wordLastStart < wordLastEnd) {
                    wordLastEnd--;
                }

                final String currentWord = String.valueOf(subject.substring(wordLastStart, wordLastEnd + 1)).toLowerCase();
                if (!usedWords.contains(currentWord)) {
                    usedWords.add(currentWord);
                    ++wordCounter;
                }
                wordLastStart = idx + 1;
            }
        }

        // Check for the last word
        wordLastEnd = chars.length - 1;
        while (isInvalid(chars[wordLastEnd]) &&  wordLastStart < wordLastEnd) {
            wordLastEnd--;
        }
        final String lastWord = String.valueOf(subject.substring(wordLastStart, wordLastEnd + 1));
        if (!usedWords.contains(lastWord.toLowerCase())) {
            usedWords.add(lastWord);
            ++wordCounter;
        }

        System.out.println(7 / 3);

        return wordCounter;
    }


    // This check is more efficient than !Character.isLetterOrDigit
    private boolean isInvalid(final char ch) {
        return !(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9');
    }
}
