package com.zagniotov.puzzles.arrays;

import java.util.Arrays;

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
public class BinarySearch2DArray {

    private final int rows;
    private final int cols;
    private final int[][] matrix;

    BinarySearch2DArray(final int rows, final int cols) {
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

    int[] coordinatesWithoutRecursion(final int needle) {

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
        final BinarySearch2DArray binarySearch2DArray = new BinarySearch2DArray(7, 7);
        binarySearch2DArray.seed();

        binarySearch2DArray.dump();

        int[] coordinates = binarySearch2DArray.coordinatesWithoutRecursion(38);
        System.out.println(Arrays.toString(coordinates));

        //coordinates = binarySearch2DArray.coordinatesWithoutRecursion(49);
        //System.out.println(Arrays.toString(coordinates));
    }
}
