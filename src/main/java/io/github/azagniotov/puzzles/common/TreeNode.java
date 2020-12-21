package io.github.azagniotov.puzzles.common;

public final class TreeNode {
    public final int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int value, final TreeNode left, final TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}