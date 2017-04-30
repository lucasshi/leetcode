package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/30.
 */
public class P110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // -1 means not balanced tree
        int heightLeft = getDepth(root.left);
        if (heightLeft == -1) {
            return -1;
        }

        int heightRight = getDepth(root.right);
        if (heightRight == -1) {
            return -1;
        }

        // do campare
        int difference = Math.abs(heightLeft - heightRight);
        return difference <= 1 ? Math.max(heightLeft, heightRight) + 1 : -1;
    }
}
