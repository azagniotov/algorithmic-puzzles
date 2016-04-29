package com.zagniotov.puzzles.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CalculatePowerTake3Test {

    @Test
    public void testPow_WhenExponentPositive() throws Exception {
        final CalculatePowerTake3 calculatePowerTake3 = new CalculatePowerTake3();
        double result = calculatePowerTake3.pow(2, 2);
        assertEquals(4, result, 0);

        result = calculatePowerTake3.pow(3, 1);
        assertEquals(3, result, 0);

        result = calculatePowerTake3.pow(2, 8);
        assertEquals(256, result, 0);

        result = calculatePowerTake3.pow(3, 0);
        assertEquals(1, result, 0);

        result = calculatePowerTake3.pow(1, 2);
        assertEquals(1, result, 0);
    }

    @Test
    public void testPow_WhenExponentNegative() throws Exception {
        final CalculatePowerTake3 calculatePowerTake3 = new CalculatePowerTake3();
        double result = calculatePowerTake3.pow(2, -1);
        assertEquals(0.5, result, 0);

        result = calculatePowerTake3.pow(2, -2);
        assertEquals(0.25, result, 0);

        result = calculatePowerTake3.pow(-1, -1);
        assertEquals(-1, result, 0);
    }
}
