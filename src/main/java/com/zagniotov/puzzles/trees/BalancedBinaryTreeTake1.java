package com.zagniotov.puzzles.trees;


public class BalancedBinaryTreeTake1 {
    public static void main(String[] args) {
        final int[] data =
                {5, 30, 33, 43, 78, 101, 113, 120, 135, 233, 265, 290, 293, 326, 363, 371, 393, 413, 445, 476};

        final BalancedBinaryTreeTake1 balancedBinaryTree = new BalancedBinaryTreeTake1();
        final Node root = balancedBinaryTree.build(data);

        System.out.println(String.format("Total leaves: %s", balancedBinaryTree.countLeaves(root)));
    }

    Node build(final int[] data) {
        return buildTree(data, 0, data.length - 1);
    }

    int countLeaves(final Node root) {
        if (root == null) {
            return 0;
        } else if (root.isLeaf()) {
            return 1;
        } else {
            return countLeaves(root.getLeftChild()) + countLeaves(root.getRightChild());
        }
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

    private final static class Node {
        private final int value;
        private final Node leftChild;
        private final Node rightChild;

        Node(final int value, final Node leftChild, final Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }

        public int getValue() {
            return value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + getValue() +
                    ", leftChild=" + getLeftChild() +
                    ", rightChild=" + getRightChild() +
                    '}';
        }
    }
}
