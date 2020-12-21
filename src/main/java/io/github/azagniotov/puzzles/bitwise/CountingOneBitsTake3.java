package io.github.azagniotov.puzzles.bitwise;

/**
 * Given a non negative integer number num.
 * <p>
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation
 * and return them as an array. Example:
 * <p>
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * 00000000  == 0
 * 00000001  == 1
 * 00000010  == 2
 * 00000011  == 3
 * 00000100  == 4
 * 00000101  == 5
 * 00000110  == 6
 * 00000111  == 7
 * 00001000  == 8
 * 00001001  == 9
 * 00001010  == 10
 * 00001011  == 11
 * 00001100  == 12
 * 00001101  == 13
 * <p>
 * This is an example of dynamic programming where whatever was produced earlier is used. Running time is O(n)
 */
class CountingOneBitsTake3 {

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
