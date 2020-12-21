package io.github.azagniotov.puzzles.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CalculateFactorialTake1Test {

    @Test
    public void testFactorial() throws Exception {
        CalculateFactorialTake1 calculateFactorialTake1 = new CalculateFactorialTake1();

        int result = calculateFactorialTake1.factorial(3);
        assertEquals(6, result);

        result = calculateFactorialTake1.factorial(4);
        assertEquals(24, result);
    }
}