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
        if (candidate == null && pattern == null) {
            return true;
        }  else if (candidate == null || pattern == null) {
            return false;
        } else if (candidate.isEmpty() && pattern.isEmpty()) {
            return true;
        }

        if (pattern.isEmpty()) {
            return false;
        } else {
            if (candidate.isEmpty()) {

                if (pattern.length() > 1) {
                    if (pattern.charAt(1) == '*') {
                        return isMatch("", pattern.substring(2));
                    }
                }

                /*
                if (pattern.length() == 2 && pattern.charAt(pattern.length() - 1) == '*') {
                    return true;
                }
                return pattern.charAt(pattern.length() - 1) == '*';
                */
            }
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
            return (pattern.length() == 1 && candidate.length() == 1) || isMatch(candidate.substring(1), pattern.substring(1));
        }
        return false;
    }
}
