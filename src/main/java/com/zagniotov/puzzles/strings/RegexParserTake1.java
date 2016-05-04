package com.zagniotov.puzzles.strings;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * '.' - exact one arbitrary character match
 * '*' - matches zero or more occurrences of the previous character
 */
class RegexParserTake1 {

    RegexParserTake1() {

    }

    boolean isMatch(final String candidate, final String pattern) {
        // base case
        // Empty pattern will always return false
        if (candidate == null && pattern == null) {
            return true;
        }

        if (pattern.isEmpty()) {
            return false;
        } else if (candidate.isEmpty()) {
            return false;
        }

        // Return false if text is empty but pattern is not *
        if (pattern.charAt(0) == '.' || pattern.charAt(0) == candidate.charAt(0)) {
            // If the last pattern matches the last text
            // If hasn't reached the end, try to match the rest strings
            return pattern.length() == 1 && candidate.length() == 1 || isMatch(candidate.substring(1), pattern.substring(1));
        }

        if (pattern.length() == 1) {
            if (pattern.charAt(0) == '*') {
                return true;
            }
        } else {

            if (pattern.charAt(0) == '*') {
                // Otherwise skip as many chars as required
                for (int idx = 0; idx < candidate.length(); idx++) {
                    if (isMatch(candidate.substring(idx), pattern.substring(1))) {
                        return true;
                    }
                }
            } else if (pattern.charAt(1) == '*') {
                // any first char & '*' can stand for 0 element:
                // is pattern: c*a*b, the c* can be dropped when compared to text "aab"
                return isMatch(candidate, pattern.substring(2));
            }
        }

        return false;
    }
}
