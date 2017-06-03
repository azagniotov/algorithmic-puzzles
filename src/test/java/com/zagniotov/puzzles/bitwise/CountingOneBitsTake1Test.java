package com.zagniotov.puzzles.bitwise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CountingOneBitsTake1Test {

    final CountingOneBitsTake1 countingOneBitsTake1 = new CountingOneBitsTake1();


    @Test
    public void naive() throws Exception {
        assertEquals(naive(10, 13), 0);
        assertEquals(naive(12, 13), 1);
//        assertEquals(naive(11, 61), solution(11, 61));
    }

    @Test
    public void testCountBits1() throws Exception {
//        assertEquals(naive(10, 13), solution(10, 13));
//        assertEquals(naive(12, 13), solution(12, 13));
//        assertEquals(naive(12, 14), solution(12, 14));
//        assertEquals(naive(11, 15), solution(11, 15));
//        assertEquals(naive(11, 11), solution(11, 11));
//        assertEquals(naive(11, 16), solution(11, 16));
//        assertEquals(naive(1, 457), solution(1, 457));
//        assertEquals(naive(11, 61), solution(11, 61));
        assertEquals(naive(5, 9), solution(5, 9));
    }

    /**
     * Submitted version
     */
    private int solution(int start, int limit) {
        if (start % 2 != 0) {
            return start ^ solution(start + 1, limit);
        }
        if (limit % 2 == 0) {
            return solution(start, limit - 1) ^ limit;
        }
        int numbersInBetween = limit - start + 1;
        return numbersInBetween / 2 % 2;
    }

    /*
    Find XOR result of all the elements in given range

    Another version, much shorter

     private int solution(int start, int limit) {
        int result = 0;
        if (start % 2 != 0) {
            result ^= start++;
        }
        if (limit % 2 == 0) {
            result ^= limit--;
        }
        int numbersInBetween = limit - start + 1;
        return result ^ numbersInBetween / 2 % 2;
    }
     */

    private int naive(int start, int limit) {
        int result = 0;
        while (start <= limit) {
            result ^= start++;
        }
        return result;
    }

}
