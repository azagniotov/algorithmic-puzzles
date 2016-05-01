package com.zagniotov.puzzles.arrays;


import java.util.ArrayList;
import java.util.List;

class Spiral2DArrayTake1 {

    Spiral2DArrayTake1() {

    }

    void seed(final int[][] matrix, final int rows, final int cols) {
        int value = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = value;
                value++;
            }
        }
    }

    String spiral(final int rows, final int cols) {
        final int[][] matrix = new int[rows][cols];
        seed(matrix, rows, cols);

        return spiral(matrix, 0, 0, rows, cols).toString();
    }

    private List<Integer> spiral(final int[][] matrix, int currentRow, int currentCol, int rows, int cols) {
        final List<Integer> result = new ArrayList<>();

        if (rows <= 0 || cols <= 0) {
            return result;
        }

        //only one element left
        if (rows == 1 && cols == 1) {
            result.add(matrix[currentRow][currentCol]);
            return result;
        }

        //Top side: Move from left to right
        for (int idx = 0; idx < cols - 1 /* the '-1' is important, it will be the start of next loop */; idx++) {
            result.add(matrix[currentRow][currentCol++]);
        }

        //Right side: Move from top to bottom
        for (int idx = 0; idx < rows - 1 /* the '-1' is important*/; idx++) {
            result.add(matrix[currentRow++][currentCol]);
        }

        //Bottom side: Move from right to left
        for (int idx = 0; idx < cols - 1 /* the '-1' is important*/; idx++) {
            result.add(matrix[currentRow][currentCol--]);
        }

        //Left side: Move from bottom to top
        for (int idx = 0; idx < rows - 1 /* the '-1' is important*/; idx++) {
            result.add(matrix[currentRow--][currentCol]);
        }

        // By the time we reached here, we finished walking the external 'circle',
        // the currentRow & currentCol are back to zeroes.
        //
        // Now, we want to start walking the next inner circle, by incrementing
        // currentRow & currentCol and adjusting the matrix limits
        result.addAll(spiral(matrix, currentRow + 1, currentCol + 1, rows - 2, cols - 2));

        return result;
    }
}
