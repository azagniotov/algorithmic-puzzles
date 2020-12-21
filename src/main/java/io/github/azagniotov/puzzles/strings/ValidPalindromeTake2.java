package io.github.azagniotov.puzzles.strings;

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
class ValidPalindromeTake2 {

    ValidPalindromeTake2() {

    }

    // ASSUMPTION: ONLY alpha-numeric characters
    boolean isPalindrome(final String subject) {
        if (subject == null) {
            return false;
        } else if (subject.trim().equals("") || subject.trim().length() == 1) {
            return true;
        }

        final char[] chars = subject.toCharArray();
        final int[] letters = new int[37]; // lower case alphabet

        for (char aChar : chars) {
            char current = aChar;
            if (current >= 'A' && current <= 'Z') {
                current += 32;
            }
            if (current >= '0' && current <= '9') {
                current += 76;
            }
            letters[current - 'a']++;
        }

        int countOdds = 0;
        for (int idx = 0; idx < letters.length; idx++) {
            int letterCount = letters[idx];
            if (letterCount % 2 == 1) {
                char current = chars[chars.length / 2];
                if (current >= 'A' && current <= 'Z') {
                    current += 32;
                }
                if (current >= '0' && current <= '9') {
                    current += 76;
                }
                if (current - 'a' != idx) {
                    return false;
                }
                countOdds++;
            }
        }
        return countOdds <= 1;
    }
}
