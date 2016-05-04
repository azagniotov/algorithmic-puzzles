package com.zagniotov.puzzles.strings;

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
        // Base cases
        if (candidate == null && pattern == null) {
            return true;
        }  else if (candidate == null || pattern == null) {
            return false;
        } else if (candidate.isEmpty() && pattern.isEmpty()) {
            return true;
        }

        // Empty pattern will always return false
        if (pattern.isEmpty()) {
            return false;
        } else if (candidate.isEmpty()) {
            return true;
        }

        if (pattern.length() > 1) {
            if (pattern.charAt(1) == '*') {
                int start = 0;
                while (start < candidate.length() && (pattern.charAt(0) == '.' || candidate.charAt(start) == pattern.charAt(0))) {
                    if (isMatch(candidate.substring(start), pattern.substring(2))) {
                        return true;
                    }
                    start++;
                }
                return isMatch(candidate.substring(start), pattern.substring(2));
            }
        }

        if (pattern.charAt(0) == '.' || pattern.charAt(0) == candidate.charAt(0)) {
            // If the last pattern matches the last text OR
            // If hasn't reached the end, try to match the rest strings
            return (pattern.length() == 1 && candidate.length() == 1) || isMatch(candidate.substring(1), pattern.substring(1));
        }
        return false;
    }
}
