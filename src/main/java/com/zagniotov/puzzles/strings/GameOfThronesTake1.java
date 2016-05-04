package com.zagniotov.puzzles.strings;

class GameOfThronesTake1 {

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

        String ans = isPotentialPalindrome("aaaabbbb") ? "YES" : "NO";
        System.out.println(ans);

        ans = isPotentialPalindrome("cdefghmnopqrstuvw") ? "YES" : "NO";
        System.out.println(ans);

        ans = isPotentialPalindrome("cdcdcdcdeeeef") ? "YES" : "NO";
        System.out.println(ans);
    }
}
