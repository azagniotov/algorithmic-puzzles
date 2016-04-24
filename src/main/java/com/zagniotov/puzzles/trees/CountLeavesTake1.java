package com.zagniotov.puzzles.trees;


import com.zagniotov.puzzles.common.Node;

public class CountLeavesTake1 {
    public static void main(String[] args) {
        final int[] data =
                {5, 30, 33, 43, 78, 101, 113, 120, 135, 233, 265, 290, 293, 326, 363, 371, 393, 413, 445, 476};

        final CountLeavesTake1 countLeavesTake1 = new CountLeavesTake1();
        final Node root = new BalancedBinaryTreeTake1().build(data);

        System.out.println(String.format("Total leaves: %s", countLeavesTake1.countLeaves(root)));
    }


    int countLeaves(final Node root) {
        if (root == null) {
            return 0;
        } else if (root.isLeaf()) {
            return 1;
        } else {
            return countLeaves(root.left) + countLeaves(root.right);
        }
    }
}
