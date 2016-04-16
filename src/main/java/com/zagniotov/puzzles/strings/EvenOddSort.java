package com.zagniotov.puzzles.strings;

/**
 * - Takes in a string of numeric characters and shifts all the odd characters to the right, while keeping all
 * the even characters on the left.
 * - The characters shifted to either to left or right are not sorted
 * - The algorithm looks at each character only once and uses a constant space for character swapping
 * - The running time is O(n) and the space complexity is O(n) where 'n' is number of characters in the given string
 * <p>
 * P.S. ascii values for numeric characters 0 - 9 are 48 - 57, i.e.: char even numeric value has an even ascii value
 */
class EvenOddSort {

    EvenOddSort() {

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
            if (left % 2 == 0) {
                ++leftPointer;
            } else {
                // the 'left' char is odd, lets start looking form the other end
                int right = (int) chars[rightPointer];
                if (right % 2 == 0) {
                    chars[leftPointer] = (char) right;
                    chars[rightPointer] = (char) left;
                    --rightPointer;
                } else {
                    // keep iterating from the end if a char is odd & while the right pointer larger than left
                    while (leftPointer < rightPointer && right % 2 != 0) {
                        right = (int) chars[--rightPointer];
                    }

                    // if we broke out because the pointer condition is false, swap only if the the char is even
                    if (right % 2 == 0) {
                        chars[leftPointer] = (char) right;
                        chars[rightPointer] = (char) left;
                    }
                }
            }
        }

        return String.valueOf(chars);
    }
}
