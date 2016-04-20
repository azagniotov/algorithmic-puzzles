package com.zagniotov.puzzles.arrays;

import static com.zagniotov.puzzles.common.Utils.seed;
import static com.zagniotov.puzzles.common.Utils.stdout;

public class MatrixFlipperTake1 {


    public static void main(final String[] args) {
        final Matrix matrix = new Matrix(6, 6);
        matrix.dump();
        matrix.rotateCounterClockWise();
        matrix.dump();
        matrix.rotateClockWise();
        matrix.dump();
    }

    private static class Matrix {

        private final int columns;
        private final int rows;
        private final int[][] matrix;

        Matrix(final int columns, final int rows) {
            this.columns = columns;
            this.rows = rows;
            this.matrix = seed(this.rows, this.columns);
        }

        void rotateCounterClockWise() {
            int cache;

            for (int row = 0; row < this.rows / 2; row++) {
                for (int col = 0; col < Math.ceil(((double) this.columns) / 2.0); col++) {
                    cache = matrix[row][col];

                    this.matrix[row][col] = this.matrix[col][this.rows - 1 - row];
                    this.matrix[col][this.rows - 1 - row] = this.matrix[this.rows - 1 - row][this.columns - 1 - col];
                    this.matrix[this.rows - 1 - row][this.columns - 1 - col] = this.matrix[this.columns - 1 - col][row];
                    this.matrix[this.columns - 1 - col][row] = cache;

                    System.out.println("Cached: " + cache);
                }
            }
        }

        void rotateClockWise() {
            int cache;
            for (int row = 0; row < this.rows / 2; row++) {
                for (int col = 0; col < Math.ceil(((double) this.columns) / 2.0); col++) {
                    cache = matrix[row][col];

                    this.matrix[row][col] = this.matrix[this.columns - 1 - col][row];
                    this.matrix[this.columns - 1 - col][row] = this.matrix[this.rows - 1 - row][this.columns - 1 - col];
                    this.matrix[this.rows - 1 - row][this.columns - 1 - col] = this.matrix[col][this.rows - 1 - row];
                    this.matrix[col][this.rows - 1 - row] = cache;

                    System.out.println("Cached: " + cache);
                }
            }
        }

        void dump() {
            stdout(this.rows, this.columns, this.matrix);
        }
    }
}
