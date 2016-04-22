package com.zagniotov.puzzles.common;

public final class Utils {

    private Utils() {

    }

    public static boolean isEven(final int value) {
        return value % 2 == 0;
    }

    public static boolean isOdd(final int value) {
        return !isEven(value);
    }

    public static int[][] seed(final int rows, final int cols) {
        final int[][] matrix = new int[rows][cols];
        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = ++value;
            }
        }
        return matrix;
    }

    public static void stdout(final int rows, final int cols, final int[][] matrix) {

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

    public static void stdout(final String[] array) {
        final StringBuilder dump = new StringBuilder();
        for (int idx = 0; idx < array.length; idx++) {
            dump.append(array[idx]);
            if (idx < array.length - 1) {
                dump.append(", ");
            }
        }
        System.out.println(dump.toString());
    }

    public static String removeCharAt(final int position, final String original) {
        return original.substring(0, position) + original.substring(position + 1);
    }

    public static void swapTwo(char[] chars, final int leftPointer, final int rightPointer) {
        char cache = chars[leftPointer];
        chars[leftPointer] = chars[rightPointer];
        chars[rightPointer] = cache;
    }

    public static void swapTwo(String[] words, final int leftPointer, final int rightPointer) {
        String cache = words[leftPointer];
        words[leftPointer] = words[rightPointer];
        words[rightPointer] = cache;
    }

    public static void swapAll(char[] chars, int leftPointer, int rightPointer) {
        while (leftPointer < rightPointer) {
            char cache = chars[leftPointer];
            chars[leftPointer] = chars[rightPointer];
            chars[rightPointer] = cache;
            leftPointer++;
            rightPointer--;
        }
    }
}
