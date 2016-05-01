package com.zagniotov.puzzles.arrays;

/**
 * Generates a matrix in a spiral order:
 * <p>
 * 64	63	62	61	60	59	58	57
 * 37	36	35	34	33	32	31	56
 * 38	17	16	15	14	13	30	55
 * 39	18	5	4	3	12	29	54
 * 40	19	6	1	2	11	28	53
 * 41	20	7	8	9	10	27	52
 * 42	21	22	23	24	25	26	51
 * 43	44	45	46	47	48	49	50
 * <p>
 */
class Generate2DArraySpiralOrderTake2 {

    Generate2DArraySpiralOrderTake2() {

    }

    public static void main(String[] args) {
        final Generate2DArraySpiralOrderTake2 generateSpiral = new Generate2DArraySpiralOrderTake2();

        generateSpiral.spiralInPlace(8, 8);
    }


    void spiralInPlace(final int rows, final int cols) {
        final int[][] matrix = new int[rows][cols];
        spiralInPlace(matrix, rows, cols);
        dump(matrix, rows, cols);
    }

    private void spiralInPlace(final int[][] matrix, int rows, int cols) {
        final int total = rows * cols;
        int value = total + 1;
        int currentRow = 0;
        int currentCol = 0;

        while (value > 0) {

            if (rows <= 0 || cols <= 0) {
                break;
            }

            if (rows == 1 && cols == 1) {
                matrix[currentRow][currentCol] = --value;
                break;
            }

            // Top side: right-to-left
            for (int idx = 0; idx < cols - 1; idx++) {
                matrix[currentRow][currentCol++] = --value;
            }

            // Right side: top-to-bottom
            for (int idx = 0; idx < rows - 1; idx++) {
                matrix[currentRow++][currentCol] = --value;
            }

            // Bottom side: left-to-right
            for (int idx = 0; idx < cols - 1; idx++) {
                matrix[currentRow][currentCol--] = --value;
            }

            // Left side: bottom-to-top
            for (int idx = 0; idx < rows - 1; idx++) {
                matrix[currentRow--][currentCol] = --value;
            }

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
