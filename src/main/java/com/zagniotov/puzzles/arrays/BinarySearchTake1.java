package com.zagniotov.puzzles.arrays;


class BinarySearchTake1 {

    BinarySearchTake1() {

    }

    int findPosition(final int[] haystack, final int needle) {
        return findPosition(haystack, needle, 0, haystack.length - 1);
    }

    private int findPosition(final int[] haystack, final int needle, final int leftPointer, final int rightPointer) {
        if (leftPointer > rightPointer) {
            return -1;
        }

        final int middlePointer = (leftPointer + rightPointer) / 2;
        final int middleValue = haystack[middlePointer];

        if (middleValue < needle) {
            return findPosition(haystack, needle, middlePointer + 1, rightPointer);
        } else if (middleValue > needle) {
            return findPosition(haystack, needle, leftPointer, middlePointer - 1);
        } else {
            return middlePointer;
        }
    }

    public static void main(String[] args) {
        final int[] haystack =
                {5, 30, 33, 43, 78, 101, 113, 120, 135, 233, 265, 290, 293, 326, 363, 371, 393, 413, 445, 476};
        final int needle = 476;
        final BinarySearchTake1 binarySearch = new BinarySearchTake1();
        final int position = binarySearch.findPosition(haystack, needle);

        if (position == -1) {
            System.out.println(
                    String.format("Needle: %s, found position: %s, not in haystack!", needle, position));
        } else {
            System.out.println(
                    String.format("Needle: %s, found position: %s, found in haystack: %s", needle, position, haystack[position]));
        }
    }
}
