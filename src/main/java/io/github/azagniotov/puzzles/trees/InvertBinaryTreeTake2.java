package io.github.azagniotov.puzzles.trees;

import io.github.azagniotov.puzzles.common.TreeNode;


class InvertBinaryTreeTake2 {

    /*
     Invert a tree from:
             4
            /  \
           2    7
          / \   /\
         1   3 6  9

     to:

             4
            /  \
           7    2
          / \   /\
         9   6 3  1

     */
    TreeNode invertTree(final TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode cache = invertTree(root.right);
            root.right = invertTree(root.left);
            root.left = cache;

            return root;
        }
    }
}
