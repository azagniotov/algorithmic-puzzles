package com.zagniotov.puzzles.strings;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * '.' - exact one arbitrary character match
 * '*' - zero or more arbitrary character match
 */
class RegexParserTake1 {

    RegexParserTake1() {

    }

    boolean isMatch(final String candidate, final String pattern) {
        // base case
        // Empty pattern will always return false
        if (pattern.isEmpty()) {
            return false;
        }

        if (pattern.charAt(0) == '*') {
            // Last * matches everything
            if (pattern.length() == 1) {
                return true;
            } else {
                return matchStar(pattern.substring(1), candidate);
            }
        }
        // Return false if text is empty but pattern is not *
        else if (candidate.isEmpty()) {
            return false;
        } else if (pattern.charAt(0) == '.' || pattern.charAt(0) == candidate.charAt(0)) {
            // If the last pattern matches the last text
            // If hasn't reached the end, try to match the rest strings
            return pattern.length() == 1 && candidate.length() == 1 || isMatch(candidate.substring(1), pattern.substring(1));
        }

        // any first char & '*' can stand for 0 element:
        // is pattern: c*a*b, the c* can be dropped when compared to text "aab"
        else if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            return isMatch(candidate, pattern.substring(2));
        }
        return false;
    }

    // Otherwise skip as many chars as required
    boolean matchStar(final String pattern, final String candidate) {
        for (int i = 0; i < candidate.length(); i++) {
            if (isMatch(candidate.substring(i), pattern)) {
                return true;
            }
        }

        return false;
    }
}
