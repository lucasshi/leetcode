package com.tencent.lucasshi;

import java.util.Map;

/**
 * Created by fzy on 17/4/30.
 */
public class P124_PathSum {
    public static int treeMaxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        treeMaxPath = Integer.MIN_VALUE;
        helper(root);
        return treeMaxPath;
    }

    public int helper(TreeNode node) {
        if (node == null)
            return 0;

        int leftSum = helper(node.left) + node.val;
        int rightSum = helper(node.right) + node.val;
        int totalSum = leftSum + rightSum - node.val;

        treeMaxPath = Math.max(
                treeMaxPath, Math.max(
                        leftSum, Math.max(node.val, Math.max(rightSum, totalSum))));
        return Math.max(leftSum, Math.max(node.val, rightSum));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);

    }

}
