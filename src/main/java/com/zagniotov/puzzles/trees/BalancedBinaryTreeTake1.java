package com.zagniotov.puzzles.trees;


import com.zagniotov.puzzles.common.TreeNode;

public class BalancedBinaryTreeTake1 {
    public static void main(String[] args) {
        final int[] data =
                {5, 30, 33, 43, 78, 101, 113, 120, 135, 233, 265, 290, 293, 326, 363, 371, 393, 413, 445, 476};

        final BalancedBinaryTreeTake1 balancedBinaryTreeTake1 = new BalancedBinaryTreeTake1();
        final TreeNode root = balancedBinaryTreeTake1.build(data);

        System.out.println(root);
    }

    TreeNode build(final int[] data) {
        return buildTree(data, 0, data.length - 1);
    }

    private TreeNode buildTree(final int[] data, int leftPointer, int rightPointer) {
        if (leftPointer > rightPointer) {
            return null;
        }

        final int middlePointer = (leftPointer + rightPointer) / 2;
        final int middleValue = data[middlePointer];

        final TreeNode leftChild = buildTree(data, leftPointer, middlePointer - 1);
        final TreeNode rightChild = buildTree(data, middlePointer + 1, rightPointer);

        return new TreeNode(middleValue, leftChild, rightChild);
    }
}
