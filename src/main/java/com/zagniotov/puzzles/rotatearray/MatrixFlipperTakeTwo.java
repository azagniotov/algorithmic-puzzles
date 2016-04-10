package com.zagniotov.puzzles.rotatearray;


class MatrixFlipperTakeTwo {

    private final int rows;
    private final int cols;
    private final int[][] matrix;

    MatrixFlipperTakeTwo(final int rows, final int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    void seed() {
        int value = 0;
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                this.matrix[row][col] = ++value;
            }
        }
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
        final StringBuilder dump = new StringBuilder();
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                dump.append(this.matrix[row][col]);
                if (col < this.cols - 1) {
                    dump.append("\t");
                }
            }
            dump.append("\n");
        }
        System.out.println(dump.toString());
    }

    public static void main(String[] args) {
        final MatrixFlipperTakeTwo matrixFlipperTakeTwo = new MatrixFlipperTakeTwo(7, 7);
        matrixFlipperTakeTwo.seed();
        matrixFlipperTakeTwo.dump();

        matrixFlipperTakeTwo.rotateClockwise();

        matrixFlipperTakeTwo.dump();
    }
}
