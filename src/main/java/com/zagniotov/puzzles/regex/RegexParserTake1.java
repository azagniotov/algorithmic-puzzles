package com.zagniotov.puzzles.regex;

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

/*

class RegexParserTake1 {

    RegexParserTake1() {

    }

    boolean isMatch(final String text, final String pattern) {
        // base case
        if (pattern.length() == 0) {
            return text.length() == 0;
        }

        // special case
        if (pattern.length() == 1) {

            // if the length of text is 0, return false
            if (text.length() < 1) {
                return false;
            }

            //if the first does not match, return false
            else if (isFirstCharsNotMatching(text, pattern) && isFirstCharNot('.', pattern)) {
                return false;
            }

            // otherwise, compare the rest of the string of text and pattern.
            else {
                return isMatch(text.substring(1), pattern.substring(1));
            }
        }

        // case 1: when the second char of pattern is not '*'
        if (pattern.charAt(1) != '*') {
            if (text.length() < 1) {
                return false;
            }
            if (isFirstCharsNotMatching(text, pattern) && isFirstCharNot('.', pattern)) {
                return false;
            } else {
                return isMatch(text.substring(1), pattern.substring(1));
            }
        }

        // case 2: when the second char of pattern is '*', complex case.
        else {
            //case 2.1: a char & '*' can stand for 0 element
            if (isMatch(text, pattern.substring(2))) {
                return true;
            }

            //case 2.2: a char & '*' can stand for 1 or more preceding element,
            //so try every sub string
            int i = 0;
            while (i < text.length() && (text.charAt(i) == pattern.charAt(0) || pattern.charAt(0) == '.')) {
                if (isMatch(text.substring(i + 1), pattern.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

    boolean isFirstCharsNotMatching(final String text, final String pattern) {
        return (pattern.charAt(0) != text.charAt(0)) && (pattern.charAt(0) != '.');
    }

    boolean isFirstCharNot(final char pattern, final String subject) {
        return subject.charAt(0) != pattern;
    }

    public static void main(String[] args) {
        final RegexParserTake1 regexParserTake1 = new RegexParserTake1();

        System.out.println(regexParserTake1.isMatch("aa", "a"));
        System.out.println(regexParserTake1.isMatch("aa", "aa"));
        System.out.println(regexParserTake1.isMatch("aaa", "aa"));
        System.out.println(regexParserTake1.isMatch("aa", "a*"));
        System.out.println(regexParserTake1.isMatch("aa", ".*"));
        System.out.println(regexParserTake1.isMatch("ab", ".*"));
        System.out.println(regexParserTake1.isMatch("aab", "c*a*b"));
    }
}

 */