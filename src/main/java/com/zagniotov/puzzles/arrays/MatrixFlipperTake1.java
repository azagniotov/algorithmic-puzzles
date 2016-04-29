package com.zagniotov.puzzles.arrays;


import static com.zagniotov.puzzles.common.Utils.seed;
import static com.zagniotov.puzzles.common.Utils.stdout;

class MatrixFlipperTake1 {

    private final int rows;
    private final int cols;
    private final int[][] matrix;

    MatrixFlipperTake1(final int rows, final int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = seed(this.rows, this.cols);
    }

    void rotateClockwise() {
        int cache;
        for (int row = 0; row < this.rows / 2; row++) {
            // The "Math.ceil((double) this.cols / 2)" is for the case when we have odd number of rows & cols
            for (int col = 0; col < Math.ceil((double) this.cols / 2); col++) {

                cache = this.matrix[row][col];
                this.matrix[row][col] = this.matrix[this.rows - 1 - col][row];
                this.matrix[this.rows - 1 - col][row] = this.matrix[this.rows - 1 - row][this.cols - 1 - col];
                this.matrix[this.rows - 1 - row][this.cols - 1 - col] = this.matrix[col][this.cols - 1 - row];
                this.matrix[col][this.cols - 1 - row] = cache;
            }
        }
    }

    void dump() {
        stdout(this.rows, this.cols, this.matrix);
    }

    public static void main(String[] args) {
        final MatrixFlipperTake1 matrixFlipperTake1 = new MatrixFlipperTake1(7, 7);

        matrixFlipperTake1.dump();

        matrixFlipperTake1.rotateClockwise();

        matrixFlipperTake1.dump();
    }
}
