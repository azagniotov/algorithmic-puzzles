package com.zagniotov.puzzles.strings;


class ReverseStringCharactersTake1 {

    ReverseStringCharactersTake1() {

    }

    String reverse(final String subject) {

        if (subject == null || subject.trim().equals("")) {
            return "";
        }

        final char[] chars = subject.toCharArray();
        int leftPointer = 0;
        int rightPointer = chars.length - 1;

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
