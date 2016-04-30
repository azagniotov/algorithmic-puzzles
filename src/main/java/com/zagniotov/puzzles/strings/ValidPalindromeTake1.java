package com.zagniotov.puzzles.strings;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Palindrome: a word, phrase, number, or other sequence of symbols or elements, whose meaning may be interpreted the
 * same way in either forward or reverse direction.
 */
class ValidPalindromeTake1 {

    ValidPalindromeTake1() {

    }

    boolean isPalindrome(final String subject) {
        if (subject == null) {
            return false;
        } else if (subject.trim().equals("")) {
            return true;
        }

        char[] chars = subject.toCharArray();
        int leftPointer = 0;
        int rightPointer = chars.length - 1;

        while (leftPointer < rightPointer) {

            char left = chars[leftPointer];
            while (isInvalid(left) && leftPointer < rightPointer) {
                left = chars[++leftPointer];
            }

            char right = chars[rightPointer];
            while (isInvalid(right) && leftPointer < rightPointer) {
                right = chars[--rightPointer];
            }

            if (leftPointer < rightPointer) {
                // Instead Character.toLowerCase
                if (left >= 'A' && left <= 'Z') {
                    left += 32;
                }
                if (right >= 'A' && right <= 'Z') {
                    right += 32;
                }
                if (left != right) {
                    return false;
                }
                leftPointer++;
                rightPointer--;
            }
        }
        return true;
    }

    // This check is more efficient than !Character.isLetterOrDigit
    private boolean isInvalid(final char ch) {
        return !(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9');
    }
}
