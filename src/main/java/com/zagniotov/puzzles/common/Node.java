package com.zagniotov.puzzles.common;

public final class Node {
    public final int value;
    public Node left;
    public Node right;

    public Node(final int value, final Node left, final Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}