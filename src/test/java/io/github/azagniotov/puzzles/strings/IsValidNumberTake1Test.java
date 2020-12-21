package io.github.azagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by alexanderzagniotov on 4/29/16.
 */
public class IsValidNumberTake1Test {

    @Test
    public void testIsNumber() throws Exception {
        IsValidNumberTake1 isValidNumberTake1 = new IsValidNumberTake1();

        assertTrue(isValidNumberTake1.isNumber("0"));
        assertTrue(isValidNumberTake1.isNumber(" 0.1 "));
        assertTrue(isValidNumberTake1.isNumber("2e10"));
        assertTrue(isValidNumberTake1.isNumber("-3"));
        assertTrue(isValidNumberTake1.isNumber(".3"));
        assertTrue(isValidNumberTake1.isNumber("-.3"));
        assertTrue(isValidNumberTake1.isNumber("-3787.989"));
        assertTrue(isValidNumberTake1.isNumber("+.8"));
        assertTrue(isValidNumberTake1.isNumber("2.2e81"));
        assertTrue(isValidNumberTake1.isNumber("2.e81"));
        assertTrue(isValidNumberTake1.isNumber(".2e81"));
        assertTrue(isValidNumberTake1.isNumber("-.2e81"));
        assertTrue(isValidNumberTake1.isNumber(" 005047e+6"));

        assertFalse(isValidNumberTake1.isNumber("."));
        assertFalse(isValidNumberTake1.isNumber(".1."));
        assertFalse(isValidNumberTake1.isNumber("1 a"));
        assertFalse(isValidNumberTake1.isNumber("abc"));
        assertFalse(isValidNumberTake1.isNumber("1.2.3"));
        assertFalse(isValidNumberTake1.isNumber("0e"));
        assertFalse(isValidNumberTake1.isNumber("e0"));
        assertFalse(isValidNumberTake1.isNumber("1e."));
        assertFalse(isValidNumberTake1.isNumber(".e1"));
        assertFalse(isValidNumberTake1.isNumber("6e65.8"));
        assertFalse(isValidNumberTake1.isNumber("1e2e3"));
    }
}