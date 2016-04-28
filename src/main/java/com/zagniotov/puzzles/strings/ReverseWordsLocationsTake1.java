package com.zagniotov.puzzles.strings;


import static com.zagniotov.puzzles.common.Utils.swapAll;

class ReverseWordsLocationsTake1 {

    ReverseWordsLocationsTake1() {

    }

    String reverse(final String subject) {

        final char[] chars = subject.toCharArray();
        int leftPointer = 0, rightPointer;

        // reverse each word first
        for (int idx = 0; idx < chars.length; idx++) {
            if (chars[idx] == ' ') {

                rightPointer = idx - 1;
                swapAll(chars, leftPointer, rightPointer);
                leftPointer = idx + 1;
            }
        }

        // reverse the chars of the last word
        swapAll(chars, leftPointer, chars.length - 1);

        // reverse everything to get correct char order in a word
        swapAll(chars, 0, chars.length - 1);

        return String.valueOf(chars);
    }
}
