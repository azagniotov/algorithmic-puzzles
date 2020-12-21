package io.github.azagniotov.puzzles.math;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class IsPrimeTake1Test {

    private final static int LIMIT = 1000000000;

    @Test
    public void testIsPrime() throws Exception {
        final int[] data = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        final IsPrimeTake1 isPrimeTake1 = new IsPrimeTake1();
        for (int prime : data) {
            assertTrue(isPrimeTake1.isPrime(prime));
        }
    }
}