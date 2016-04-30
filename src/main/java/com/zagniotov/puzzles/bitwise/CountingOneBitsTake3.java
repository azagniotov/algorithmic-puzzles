package com.zagniotov.puzzles.bitwise;

public class CountingOneBitsTake3 {

    CountingOneBitsTake3() {

    }

    int[] countOneBits1(int subject) {
        final int[] result = new int[subject + 1];
        result[0] = 0;
        for (int idx = 1; idx <= subject; idx++) {
            int andResult = idx & (idx - 1);
            result[idx] = result[andResult] + 1;
        }

        return result;
    }
}
