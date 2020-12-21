package io.github.azagniotov.puzzles.math;


class DuplicateNumberTake2 {

    DuplicateNumberTake2() {

    }

    int duplicateNumber1(int[] numbers) {
        boolean[] visited = new boolean[numbers.length];
        for (int number : numbers) {
            if (visited[number]) {
                return number;
            } else {
                visited[number] = true;
            }
        }

        return -1;
    }

    /**
     * If we assume that:
     * <p>
     * 1. numbers are in sequence that starts increasing from 1 (incl.); and
     * 2. numbers can be sorted or unsorted; and
     * 3. numbers contain only ONE value which appears twice
     * <p>
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
