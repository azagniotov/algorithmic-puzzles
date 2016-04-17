package com.zagniotov.puzzles.strings;


class ReverseStringTake1 {

    ReverseStringTake1() {

    }

    String reverse(final String subject) {

        if (subject == null || subject.trim().equals("")) {
            return "";
        }

        final char[] chars = subject.toCharArray();
        int leftPointer = -1;
        int rightPointer = chars.length;

        while (leftPointer < rightPointer) {
            char cache = chars[++leftPointer];

            chars[leftPointer] = chars[--rightPointer];
            chars[rightPointer] = cache;
        }

        return String.valueOf(chars);
    }
}
