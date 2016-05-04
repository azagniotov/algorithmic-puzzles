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
        } else if (candidate == null || pattern == null) {
            return false;
        }

        // Empty pattern will always return false
        if (pattern.isEmpty()) {
            return false;
        } else if (candidate.isEmpty()) {
            return false;
        }

        // First Main Case
        if (pattern.charAt(0) == '.' || pattern.charAt(0) == candidate.charAt(0)) {
            // If the last pattern matches the last text OR
            // If hasn't reached the end, try to match the rest strings
            return (pattern.length() == 1 && candidate.length() == 1) || isMatch(candidate.substring(1), pattern.substring(1));
        }


        if (pattern.length() == 1) { // Second Main Case: pattern is of length 1
            return pattern.charAt(0) == '*';
        } else { // Third Main Case: pattern is of length greater than 1

            if (pattern.charAt(0) == '*') {
                // Skip as many chars as required
                for (int idx = 0; idx < candidate.length(); idx++) {
                    if (isMatch(candidate.substring(idx), pattern.substring(1))) {
                        return true;
                    }
                }
            } else if (pattern.charAt(1) == '*') {
                // any first char and the '*' char can stand for 0 element:
                // if pattern: c*a*b, then the 'c*' can be dropped when compared to text "aab"
                return isMatch(candidate, pattern.substring(2));
            }
        }
        return false;
    }
}
