package com.zagniotov.puzzles.strings;

import static java.lang.Character.forDigit;
import static java.lang.Character.getNumericValue;

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
        int cache;

        while (leftPointer < rightPointer) {

            int left = getNumericValue(chars[leftPointer]);
            if (left % 2 == 0) {
                ++leftPointer;
                continue;
            } else {
                cache = left;
                int right = getNumericValue(chars[rightPointer]);
                if (right % 2 == 0) {
                    chars[leftPointer] = forDigit(right, 10);
                    chars[rightPointer] = forDigit(cache, 10);
                    --rightPointer;
                } else {
                    while (leftPointer < rightPointer && right % 2 != 0) {
                        right = getNumericValue(chars[--rightPointer]);
                    }

                    if (right % 2 == 0) {
                        chars[leftPointer] = forDigit(right, 10);
                        chars[rightPointer] = forDigit(cache, 10);
                    }
                }
            }
        }

        return String.valueOf(chars);
    }
}
