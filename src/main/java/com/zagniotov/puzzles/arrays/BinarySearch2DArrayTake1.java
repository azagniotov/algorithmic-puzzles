package com.zagniotov.puzzles.arrays;

import java.util.Arrays;

import static com.zagniotov.puzzles.common.Utils.seed;
import static com.zagniotov.puzzles.common.Utils.stdout;

/**
 * Find coordinates of a needle in 2D haystack
 * <p>
 * - Binary Search Solution:
 * As each row takes O(log N) time to search, and there are a total of N rows,
 * we are able to do it in O(N * log N) time.
 * <p>
 * - Step-wise Linear Search (current solution):
 * In each step either a row or a column gets eliminated.
 * The worst case scenario is where it ended up in the opposite corner of the matrix,
 * which takes at most 2N steps. Therefore, ths algorithm runs in O(n) time.
 */
public class BinarySearch2DArrayTake1 {

    private final int rows;
    private final int cols;
    private final int[][] matrix;

    BinarySearch2DArrayTake1(final int rows, final int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = seed(rows, cols);
    }

    void dump() {
        stdout(this.rows, this.cols, this.matrix);
    }

    int[] coordinates(final int needle) {

        int row = 0;
        int col = this.cols - 1;

        while (row < this.rows && col >= 0) {

            if (needle > this.matrix[row][col]) {
                System.out.println("Checked: " + row + ", " + col);
                ++row;
            } else if (needle < this.matrix[row][col]) {
                System.out.println("Checked: " + row + ", " + col);
                --col;
            } else {
                break;
            }
        }

        return new int[]{row, col};
    }

    public static void main(String[] args) {
        final BinarySearch2DArrayTake1 binarySearch2DArrayTake1 = new BinarySearch2DArrayTake1(7, 7);

        binarySearch2DArrayTake1.dump();

        int[] coordinates = binarySearch2DArrayTake1.coordinates(38);
        System.out.println(Arrays.toString(coordinates));
    }
}
