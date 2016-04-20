package com.zagniotov.puzzles.trees;


import com.zagniotov.puzzles.common.Node;

public class BalancedBinaryTreeTake1 {
    public static void main(String[] args) {
        final int[] data =
                {5, 30, 33, 43, 78, 101, 113, 120, 135, 233, 265, 290, 293, 326, 363, 371, 393, 413, 445, 476};

        final BalancedBinaryTreeTake1 balancedBinaryTreeTake1 = new BalancedBinaryTreeTake1();
        final Node root = balancedBinaryTreeTake1.build(data);

        System.out.println(root);
    }

    Node build(final int[] data) {
        return buildTree(data, 0, data.length - 1);
    }

    private Node buildTree(final int[] data, int leftPointer, int rightPointer) {
        if (leftPointer > rightPointer) {
            return null;
        }

        final int middlePointer = (leftPointer + rightPointer) / 2;
        final int middleValue = data[middlePointer];

        final Node leftChild = buildTree(data, leftPointer, middlePointer - 1);
        final Node rightChild = buildTree(data, middlePointer + 1, rightPointer);

        return new Node(middleValue, leftChild, rightChild);
    }
}
