package com.zagniotov.puzzles.strings;

/**
 * Created by alexanderzagniotov on 5/2/16.
 */
public class GameOfThronesTake1 {

    private static boolean permute(final String palindrome) {
        return !(palindrome == null || palindrome.trim().equals("") || palindrome.length() > 100000)
                && isPotentialPalindrome(palindrome) && permute("", palindrome);
    }

    private static boolean permute(final String prefix, final String suffix) {
        final int suffixLength = suffix.length();
        if (suffixLength == 1) {
            final String palindrome = prefix + suffix;
            if (isPotentialPalindrome(palindrome)) {
                int leftPointer = 0;
                int rightPointer = palindrome.length() - 1;
                char[] chars = palindrome.toCharArray();

                while (leftPointer < rightPointer) {
                    if (chars[leftPointer] != chars[rightPointer]) {
                        return false;
                    }
                    leftPointer++;
                    rightPointer--;
                }
                return true;
            }
            return false;
        } else {
            for (int idx = 0; idx < suffixLength; idx++) {
                final String newPrefix = prefix + suffix.charAt(idx);
                final String newSuffix = suffix.substring(0, idx) + suffix.substring(idx + 1, suffixLength);
                if (permute(newPrefix, newSuffix)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPotentialPalindrome(final String palindrome) {
        final char[] chars = (palindrome).toCharArray();
        final int[] letters = new int[26]; // lower case alphabet

        for (char charc : chars) {
            letters[charc - 'a']++;
        }

        int countOdds = 0;
        for (int letter : letters) {
            if (letter % 2 == 1) {
                countOdds++;
            }
        }

        return countOdds <= 1;
    }

    public static void main(String[] args) {

        String ans = permute("aaaabbbb") ? "YES" : "NO";
        System.out.println(ans);

        ans = permute("cdefghmnopqrstuvw") ? "YES" : "NO";
        System.out.println(ans);

        ans = permute("cdcdcdcdeeeef") ? "YES" : "NO";
        System.out.println(ans);
    }
}
