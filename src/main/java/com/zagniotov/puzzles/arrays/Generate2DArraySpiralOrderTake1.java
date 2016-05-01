package com.zagniotov.puzzles.arrays;

/**
 * Generates a matrix in a spiral order:
 * <p>
 * 1	2	3	4	5	6	7
 * 24	25	26	27	28	29	8
 * 23	40	41	42	43	30	9
 * 22	39	48	49	44	31	10
 * 21	38	47	46	45	32	11
 * 20	37	36	35	34	33	12
 * 19	18	17	16	15	14	13
 * <p>
 * There are two solutions provided, one of them uses recursion
 */
class Generate2DArraySpiralOrderTake1 {

    Generate2DArraySpiralOrderTake1() {

    }

    public static void main(String[] args) {
        final Generate2DArraySpiralOrderTake1 generateSpiral = new Generate2DArraySpiralOrderTake1();

        generateSpiral.spiralRecursive(7, 7);
        generateSpiral.spiralInPlace(6, 6);
    }

    void spiralRecursive(final int rows, final int cols) {
        final int[][] matrix = new int[rows][cols];
        spiralRecursive(matrix, 0, 0, rows, cols, 0);
        dump(matrix, rows, cols);
    }

    private void spiralRecursive(final int[][] matrix, int currentRow, int currentCol, int rows, int cols, int value) {
        if (rows <= 0 || cols <= 0) {
            return;
        }

        //only one element left
        if (rows == 1 && cols == 1) {
            matrix[currentRow][currentCol] = ++value;
            return;
        }

        //Top side: Move from left to right
        for (int idx = 0; idx < cols - 1; idx++) {
            matrix[currentRow][currentCol++] = ++value;
        }

        //Right side: Move from top to bottom
        for (int idx = 0; idx < rows - 1; idx++) {
            matrix[currentRow++][currentCol] = ++value;
        }

        //Bottom side: Move from right to left
        for (int idx = 0; idx < cols - 1; idx++) {
            matrix[currentRow][currentCol--] = ++value;
        }

        //Left side: Move from bottom to top
        for (int idx = 0; idx < rows - 1; idx++) {
            matrix[currentRow--][currentCol] = ++value;
        }

        // By the time we reached here, we finished walking the external 'circle',
        // the currentRow & currentCol are back to zeroes.
        //
        // Now, we want to start walking the next inner circle, by incrementing
        // currentRow & currentCol and adjusting the matrix limits
        spiralRecursive(matrix, currentRow + 1, currentCol + 1, rows - 2, cols - 2, value);
    }

    void spiralInPlace(final int rows, final int cols) {
        final int[][] matrix = new int[rows][cols];
        spiralInPlace(matrix, rows, cols);
        dump(matrix, rows, cols);
    }

    private void spiralInPlace(final int[][] matrix, int rows, int cols) {
        int value = 0;
        int currentRow = 0;
        int currentCol = 0;

        final int total = rows * cols;
        while (value <= total) {
            if (rows <= 0 || cols <= 0) {
                break;
            }

            //only one element left
            if (rows == 1 && cols == 1) {
                matrix[currentRow][currentCol] = ++value;
                break;
            }

            //Top side: Move from left to right
            for (int idx = 0; idx < cols - 1; idx++) {
                matrix[currentRow][currentCol++] = ++value;
            }

            //Right side: Move from top to bottom
            for (int idx = 0; idx < rows - 1; idx++) {
                matrix[currentRow++][currentCol] = ++value;
            }

            //Bottom side: Move from right to left
            for (int idx = 0; idx < cols - 1; idx++) {
                matrix[currentRow][currentCol--] = ++value;
            }

            //Left side: Move from bottom to top
            for (int idx = 0; idx < rows - 1; idx++) {
                matrix[currentRow--][currentCol] = ++value;
            }

            // By the time we reached here, we finished walking the external 'circle',
            // the currentRow & currentCol are back to zeroes.
            //
            // Now, we want to start walking the next inner circle, by incrementing
            // currentRow & currentCol and adjusting the matrix limits
            currentRow += 1;
            currentCol += 1;
            rows -= 2;
            cols -= 2;
        }
    }

    void dump(final int[][] matrix, final int rows, final int cols) {
        final StringBuilder dump = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dump.append(matrix[row][col]);

                if (col < cols - 1) {
                    dump.append("\t");
                }
            }
            dump.append("\n");
        }

        System.out.println(dump.toString());
    }
}
