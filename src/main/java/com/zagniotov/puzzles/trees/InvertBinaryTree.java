package com.zagniotov.puzzles.trees;

import com.zagniotov.puzzles.common.Node;


class InvertBinaryTree {

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
    Node invertTree(final Node root) {
        if (root == null) {
            return null;
        } else {
            Node cache = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = cache;

            return root;
        }
    }
}
