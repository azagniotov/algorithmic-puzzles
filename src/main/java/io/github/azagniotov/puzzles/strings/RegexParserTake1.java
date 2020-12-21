package io.github.azagniotov.puzzles.strings;

/**
 * Implement regular expression matching with support for '.' and '*'
 * <p>
 * '.' - Matches any single character
 * '*' - Matches zero or more of the preceding element
 */
class RegexParserTake1 {

    RegexParserTake1() {

    }

    boolean isMatch(final String candidate, final String pattern) {
        if (pattern.isEmpty()) {
            return candidate.isEmpty();
        }

        final char patternStart = pattern.charAt(0);
        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            int start = 0;
            final String patternTail = pattern.substring(2);
            while (start < candidate.length() && (candidate.charAt(start) == patternStart || patternStart == '.')) {
                if (isMatch(candidate.substring(start), patternTail)) {
                    return true;
                }
                start++;
            }
            return isMatch(candidate.substring(start), patternTail);

        }
        return !candidate.isEmpty() && (candidate.charAt(0) == patternStart || patternStart == '.') &&
                isMatch(candidate.substring(1), pattern.substring(1));
    }
}
