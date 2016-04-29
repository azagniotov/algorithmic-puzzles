package com.zagniotov.puzzles.math;


class DuplicateNumberTake1 {

    DuplicateNumberTake1() {

    }

    int duplicateNumber1(int[] numbers) {
        boolean[] found = new boolean[numbers.length + 1];
        for (int idx = 0; idx < numbers.length; idx++) {
            if (found[numbers[idx]]) {
                return numbers[idx];
            } else {
                found[numbers[idx]] = true;
            }
        }
        return 0;
    }

    /**
     * If we assume that:
     *
     * 1. numbers are in sequence that starts increasing from 1 (incl.); and
     * 2. numbers can be sorted or unsorted; and
     * 3. numbers contain only ONE value which appears twice
     *
     * Then, the following trick using XOR will work!
     */
    int duplicateNumber2(int[] numbers) {
        int result = 0;
        for (int idx = 0; idx < numbers.length; idx++) {
            result = result ^ (numbers[idx]) ^ idx;
        }
        return result;
    }
}
