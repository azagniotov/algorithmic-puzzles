package com.zagniotov.puzzles.strings;

import static com.zagniotov.puzzles.common.Utils.*;

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

    String segregate(final String subject) {
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
                swapTwo(chars, leftPointer, rightPointer);

                leftPointer++;
                rightPointer--;
            }
        }

        return String.valueOf(chars);
    }

}
