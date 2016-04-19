package com.zagniotov.puzzles.strings;

/**
 * - Takes in a string of numeric characters (positive ints only) and shifts all the odd characters to the right,
 * while keeping all the even characters on the left.
 * - The characters shifted to either left or right sides of the given string, are not sorted
 * - The algorithm looks at each character only once and uses a constant space for character swapping
 * - The running time is O(n) and the space complexity is O(n) where 'n' is number of characters in the given string
 * - ascii values for numeric characters from 0 to 9, are respectively from 48 to 57, i.e.:
 * a numeric char with an even numeric value has an ascii even value
 */
class EvenOddSortTake2 {

    EvenOddSortTake2() {

    }

    String sort(final String subject) {
        if (subject == null || subject.trim().equals("")) {
            return "";
        }

        final char[] chars = subject.toCharArray();
        int leftPointer = 0;
        int rightPointer = chars.length - 1;

        while (leftPointer < rightPointer) {

            while (isEven(chars[leftPointer]) && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (isOdd(chars[rightPointer]) && leftPointer < rightPointer) {
                rightPointer--;
            }

            if (leftPointer < rightPointer) {
                char cache = chars[leftPointer];
                chars[leftPointer] = chars[rightPointer];
                chars[rightPointer] = cache;
            }
        }

        return String.valueOf(chars);
    }

    private boolean isEven(final int value) {
        return value % 2 == 0;
    }

    private boolean isOdd(final int value) {
        return !isEven(value);
    }
}
