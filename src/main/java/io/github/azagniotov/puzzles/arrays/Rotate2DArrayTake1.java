package io.github.azagniotov.puzzles.arrays;


import io.github.azagniotov.puzzles.common.Utils;

import static io.github.azagniotov.puzzles.common.Utils.stdout;

class Rotate2DArrayTake1 {

    private final int rows;
    private final int cols;
    private final int[][] matrix;

    Rotate2DArrayTake1(final int rows, final int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = Utils.seed(this.rows, this.cols);
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
        Utils.stdout(this.rows, this.cols, this.matrix);
    }

    public static void main(String[] args) {
        final Rotate2DArrayTake1 rotate2DArrayTake1 = new Rotate2DArrayTake1(7, 7);

        rotate2DArrayTake1.dump();

        rotate2DArrayTake1.rotateClockwise();

        rotate2DArrayTake1.dump();
    }
}
