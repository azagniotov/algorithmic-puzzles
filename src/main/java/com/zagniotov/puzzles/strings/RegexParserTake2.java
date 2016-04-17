package com.zagniotov.puzzles.strings;

/**
 * -    . matches any single character
 * -    ^ matches the beginning of the input string
 * -    * matches zero or more occurrences of the previous character
 */
class RegexParserTake2 {

    RegexParserTake2() {

    }

    boolean isMatch(final String candidate, final String pattern) {

        if (candidate.isEmpty() && pattern.isEmpty()) {
            return true;
        } else if (pattern.isEmpty()) {
            return false;
        } else {
            if (pattern.charAt(0) == '^') {
                return isMatchHere(candidate, pattern.substring(1));
            } else {
                int i = 0;
                while (i < candidate.length()) {
                    if (isMatchHere(candidate, pattern)) {
                        return true;
                    }
                    i++;
                }
            }
        }

        return false;
    }

    boolean isMatchHere(final String candidate, final String pattern) {
        if (candidate.isEmpty() && pattern.isEmpty()) {
            return true;
        } else if (pattern.isEmpty()) {
            return false;
        }

        if (pattern.length() == 1 && pattern.charAt(0) == '*') {
            return true;
        }

        if (pattern.length() > 1 && pattern.charAt(0) == '*') {
            return matchStar(candidate, pattern.substring(1));
        } else if (pattern.length() > 2 && pattern.charAt(1) == '*') {
            return matchStar(candidate, pattern.substring(2));
        }
        if (candidate.length() > 0 && (pattern.charAt(0) == '.' || pattern.charAt(0) == candidate.charAt(0))) {
            return isMatchHere(candidate.substring(1), pattern.substring(1));
        }
        return false;
    }

    boolean matchStar(final String candidate, final String pattern) {

        int i = 0;
        while (i < candidate.length() && (candidate.charAt(i) == pattern.charAt(0) || pattern.charAt(0) == '.')) {
            if (isMatchHere(candidate, pattern)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
