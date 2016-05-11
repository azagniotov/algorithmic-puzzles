package com.zagniotov.puzzles.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by alexanderzagniotov on 5/11/16.
 */
public class EvaluateReversePolishNotationTake1Test {

    @Test
    public void testEvalRPN() throws Exception {
        EvaluateReversePolishNotationTake1 notation = new EvaluateReversePolishNotationTake1();

        String[] data = new String[]{"18"};

        int result = notation.evalRPN(data);
        assertEquals(18, result);

        data = new String[]{"-78", "-33", "196", "+", "-19", "-", "115", "+", "-", "-99", "/", "-18",
                "8", "*", "-86", "-", "-", "16", "/", "26", "-14", "-", "-", "47", "-", "101", "-", "163", "*", "143",
                "-", "0", "-", "171", "+", "120", "*", "-60", "+", "156", "/", "173", "/", "-24", "11", "+", "21", "/",
                "*", "44", "*", "180", "70", "-40", "-", "*", "86", "132", "-84", "+", "*", "-", "38", "/", "/", "21",
                "28", "/", "+", "83", "/", "-31", "156", "-", "+", "28", "/", "95", "-", "120", "+", "8", "*", "90",
                "-", "-94", "*", "-73", "/", "-62", "/", "93", "*", "196", "-", "-59", "+", "187", "-", "143", "/",
                "-79", "-89", "+", "-"};

        result = notation.evalRPN(data);
        assertEquals(165, result);
    }
}