package com.zagniotov.puzzles.strings;


class ReverseWordsTake1 {

    ReverseWordsTake1() {

    }

    String reverse(final String subject) {

        final char[] chars = subject.toCharArray();
        int leftPointer = 0, rightPointer;

        // reverse each word first
        for (int idx = 0; idx < chars.length; idx++) {
            if (chars[idx] == ' ') {
                rightPointer = idx - 1;
                swap(chars, leftPointer, rightPointer);
                leftPointer = idx + 1;
            }
        }

        // reverse the chars of the last word
        swap(chars, leftPointer, chars.length - 1);

        // reverse everything to get correct char order in a word
        swap(chars, 0, chars.length - 1);

        return String.valueOf(chars);
    }

    private void swap(final char[] chars, int leftPointer, int rightPointer) {
        while (leftPointer < rightPointer) {
            char cache = chars[leftPointer];
            chars[leftPointer] = chars[rightPointer];
            chars[rightPointer] = cache;

            leftPointer++;
            rightPointer--;
        }
    }
}
