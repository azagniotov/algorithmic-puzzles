package com.zagniotov.puzzles.strings;


class ReverseWordsLocationsTake2 {

    ReverseWordsLocationsTake2() {

    }

    String reverse(final String subject) {

        final char[] chars = subject.toCharArray();
        int leftPointer = 0, rightPointer;

        // Swap all words up-to a last space
        for (int idx = 0; idx < chars.length; idx++) {
            if (chars[idx] == ' ') {

                rightPointer = idx - 1;
                while (leftPointer < rightPointer) {
                    char cache = chars[leftPointer];
                    chars[leftPointer] = chars[rightPointer];
                    chars[rightPointer] = cache;
                    leftPointer++;
                    rightPointer--;
                }
                leftPointer = idx + 1;
            }
        }

        // Reverse last word
        rightPointer = chars.length - 1;
        while (leftPointer < rightPointer) {
            char cache = chars[leftPointer];
            chars[leftPointer] = chars[rightPointer];
            chars[rightPointer] = cache;
            leftPointer++;
            rightPointer--;
        }

        // Reverse the whole string
        leftPointer = 0;
        rightPointer = chars.length - 1;
        while (leftPointer < rightPointer) {
            char cache = chars[leftPointer];
            chars[leftPointer] = chars[rightPointer];
            chars[rightPointer] = cache;
            leftPointer++;
            rightPointer--;
        }

        return String.valueOf(chars);
    }
}
