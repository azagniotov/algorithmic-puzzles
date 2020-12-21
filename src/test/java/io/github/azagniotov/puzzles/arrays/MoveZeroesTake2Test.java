package io.github.azagniotov.puzzles.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class MoveZeroesTake2Test {

    @Test
    public void testMoveZeroes() throws Exception {
        MoveZeroesTake2 moveZeroesTake2 = new MoveZeroesTake2();

        int[] result = moveZeroesTake2.moveZeroes(new int[]{0, 1, 0, 3, 12});
        assertEquals(Arrays.toString(new int[]{1, 3, 12, 0, 0}), Arrays.toString(result));

        result = moveZeroesTake2.moveZeroes(new int[]{1, 0});
        assertEquals(Arrays.toString(new int[]{1, 0}), Arrays.toString(result));

        result = moveZeroesTake2.moveZeroes(new int[]{1, 0, 0});
        assertEquals(Arrays.toString(new int[]{1, 0, 0}), Arrays.toString(result));

        result = moveZeroesTake2.moveZeroes(new int[]{1, 0, 1});
        assertEquals(Arrays.toString(new int[]{1, 1, 0}), Arrays.toString(result));

        result = moveZeroesTake2.moveZeroes(new int[]{1, 1, 1, 1, 1, 0, 1});
        assertEquals(Arrays.toString(new int[]{1, 1, 1, 1, 1, 1, 0}), Arrays.toString(result));

        result = moveZeroesTake2.moveZeroes(new int[]{1, 0, 1, 1, 1, 1, 1});
        assertEquals(Arrays.toString(new int[]{1, 1, 1, 1, 1, 1, 0}), Arrays.toString(result));
    }
}