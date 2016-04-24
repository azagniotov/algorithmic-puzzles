package com.zagniotov.puzzles.strings;


import static com.zagniotov.puzzles.common.Utils.isConsonant;

class ReverseVowelsTake1 {

    ReverseVowelsTake1() {

    }

    String reverseVowels(final String subject) {

        char[] chars = subject.toCharArray();
        int leftPointer = 0;
        int rightPointer = chars.length - 1;
        while (leftPointer < rightPointer) {
            while (isConsonant(chars[leftPointer]) && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (isConsonant(chars[rightPointer]) && leftPointer < rightPointer) {
                rightPointer--;
            }

            if (leftPointer < rightPointer) {
                char cache = chars[leftPointer];
                char right = chars[rightPointer];
                if (cache == right) {
                    leftPointer++;
                    rightPointer--;
                    continue;
                }
                chars[leftPointer] = right;
                chars[rightPointer] = cache;
                leftPointer++;
                rightPointer--;
            }
        }
        return String.valueOf(chars);
    }
}
