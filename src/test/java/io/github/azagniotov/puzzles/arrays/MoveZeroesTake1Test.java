package io.github.azagniotov.puzzles.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class MoveZeroesTake1Test {

    @Test
    public void testMoveZeroes() throws Exception {
        MoveZeroesTake1 moveZeroesTake1 = new MoveZeroesTake1();

        int[] result = moveZeroesTake1.moveZeroes(new int[]{0, 1, 0, 3, 12});
        assertEquals(Arrays.toString(new int[]{1, 3, 12, 0, 0}), Arrays.toString(result));

        result = moveZeroesTake1.moveZeroes(new int[]{1, 0});
        assertEquals(Arrays.toString(new int[]{1, 0}), Arrays.toString(result));

        result = moveZeroesTake1.moveZeroes(new int[]{1, 0, 0});
        assertEquals(Arrays.toString(new int[]{1, 0, 0}), Arrays.toString(result));

        result = moveZeroesTake1.moveZeroes(new int[]{1, 0, 1});
        assertEquals(Arrays.toString(new int[]{1, 1, 0}), Arrays.toString(result));

        result = moveZeroesTake1.moveZeroes(new int[]{1, 1, 1, 1, 1, 0, 1});
        assertEquals(Arrays.toString(new int[]{1, 1, 1, 1, 1, 1, 0}), Arrays.toString(result));

        result = moveZeroesTake1.moveZeroes(new int[]{1, 0, 1, 1, 1, 1, 1});
        assertEquals(Arrays.toString(new int[]{1, 1, 1, 1, 1, 1, 0}), Arrays.toString(result));
    }
}