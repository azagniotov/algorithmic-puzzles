package com.zagniotov.puzzles.arrays;

import static com.zagniotov.puzzles.common.Utils.seed;
import static com.zagniotov.puzzles.common.Utils.stdout;

class Rotate2DArrayTake2 {

    private final int rows;
    private final int cols;
    private final int[][] matrix;

    Rotate2DArrayTake2(final int rows, final int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = seed(this.rows, this.cols);
    }

    void rotateClockwise() {
        int cache;
        for (int row = 0; row < this.rows / 2; row++) {
            for (int col = 0; col < Math.ceil((double) this.cols / 2); col++) {
                cache = this.matrix[row][col];
                this.matrix[row][col] = this.matrix[this.rows - 1 - col][row];
                this.matrix[this.rows - 1 - col][row] = this.matrix[this.rows - 1 - row][this.cols - 1 - col];
                this.matrix[this.rows - 1 - row][this.cols - 1 - col] = this.matrix[col][this.cols - 1 - row];
                this.matrix[col][this.cols - 1 - row] = cache;
            }
        }
    }

    void rotateCounterClockwise() {
        int cache;
        for (int row = 0; row < this.rows / 2; row++) {
            for (int col = 0; col < Math.ceil((double) this.cols / 2); col++) {
                cache = this.matrix[row][col];
                this.matrix[row][col] = this.matrix[col][this.cols - 1 - row];
                this.matrix[col][this.cols - 1 - row] = this.matrix[this.rows - 1 - row][this.cols - 1 - col];
                this.matrix[this.rows - 1 - row][this.cols - 1 - col] = this.matrix[this.rows - 1 - col][row];
                this.matrix[this.rows - 1 - col][row] = cache;
            }
        }
    }

    void dump() {
        stdout(this.rows, this.cols, this.matrix);
    }

    public static void main(String[] args) {
        final Rotate2DArrayTake2 rotate2DArrayTake2 = new Rotate2DArrayTake2(7, 7);

        rotate2DArrayTake2.dump();

        rotate2DArrayTake2.rotateClockwise();

        rotate2DArrayTake2.dump();

        rotate2DArrayTake2.rotateCounterClockwise();

        rotate2DArrayTake2.dump();
    }
}
