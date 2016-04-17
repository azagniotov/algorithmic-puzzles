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
class EvenOddSortTake1 {

    EvenOddSortTake1() {

    }

    String sort(final String subject) {
        if (subject == null || subject.trim().equals("")) {
            return "";
        }

        final char[] chars = subject.toCharArray();
        int leftPointer = 0;
        int rightPointer = chars.length - 1;

        while (leftPointer < rightPointer) {
            int left = (int) chars[leftPointer];
            if (isEven(left)) {
                ++leftPointer;
            } else {
                // the 'left' char is odd, lets start looking form the other end
                int right = (int) chars[rightPointer];
                if (isEven(right)) {
                    chars[leftPointer] = (char) right;
                    chars[rightPointer] = (char) left;
                    --rightPointer;
                } else {
                    // keep iterating from the end if a char is odd & while the right pointer larger than left
                    while (leftPointer < rightPointer && isOdd(right)) {
                        right = (int) chars[--rightPointer];
                    }

                    // if we broke out because the pointer condition is false, swap only if the the char is even
                    if (isEven(right)) {
                        chars[leftPointer] = (char) right;
                        chars[rightPointer] = (char) left;
                    }
                }
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
