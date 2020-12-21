package io.github.azagniotov.puzzles.strings;

/**
 * Implement regular expression matching with support for '.' and '*'
 * <p>
 * '.' - Matches any single character
 * '*' - Matches zero or more of the preceding element
 */
class RegexParserTake2 {

    RegexParserTake2() {

    }

    boolean isMatch(final String candidate, final String pattern) {
        return isMatch(candidate.toCharArray(), 0, pattern.toCharArray(), 0);
    }

    boolean isMatch(final char[] text, final int textIndex, final char[] pattern, final int patternIndex) {
        if (pattern.length  == patternIndex) {
            return text.length  == textIndex;
        }

        final char firstPatternChar = pattern[patternIndex];
        if ((pattern.length - patternIndex) > 1 && pattern[patternIndex + 1] == '*') {
            int start = textIndex;
            while (start < text.length && (text[start] == firstPatternChar || firstPatternChar == '.')) {
                if (isMatch(text, start, pattern, patternIndex + 2)) {
                    return true;
                }
                start++;
            }
            return isMatch(text, start, pattern, patternIndex + 2);

        }
        return (textIndex < text.length) && (text[textIndex] == firstPatternChar || firstPatternChar == '.') &&
                isMatch(text, textIndex + 1, pattern, patternIndex + 1);
    }
}
