package io.github.azagniotov.puzzles.strings;


class ReverseStringCharactersTake2 {

    ReverseStringCharactersTake2() {

    }

    // Assumes that string is not empty nor null
    String reverse(final String subject) {

        char[] chars = subject.toCharArray();
        int leftPointer = 0;
        int rightPointer = chars.length - 1;

        while (leftPointer < rightPointer) {

            if (chars[leftPointer] != chars[rightPointer]) {
                char cache = chars[leftPointer];
                chars[leftPointer] = chars[rightPointer];
                chars[rightPointer] = cache;
            }

            leftPointer++;
            rightPointer--;
        }

        return String.valueOf(chars);
    }
}
