package io.github.azagniotov.puzzles.trees;

import io.github.azagniotov.puzzles.common.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
class IsSameTreeTake1 {

    IsSameTreeTake1() {

    }

    boolean isSameTree(final TreeNode first, final TreeNode second) {
        if (first == null && second == null) {
            return true;
        } else if (first == null || second == null) {
            return false;
        }

        return first.value == second.value &&
                isSameTree(first.left, second.left) && isSameTree(first.right, second.right);
    }
}
