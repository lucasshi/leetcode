package com.tencent.lucasshi;

import java.util.Map;

/**
 * Created by fzy on 17/4/30.
 */
public class P124_PathSum {
    public static int treeMaxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumWithNode(root);
        return treeMaxPath;
    }

    public int maxPathSumWithNode(TreeNode root) {
        if (root == null)
            return 0;

        int leftPathMax = maxPathSumWithNode(root.left);
        int rightPathMax = maxPathSumWithNode(root.right);

        int maxPath = root.val;
        maxPath += leftPathMax >= 0? leftPathMax : 0;
        maxPath += rightPathMax >= 0? rightPathMax : 0;
        treeMaxPath = Math.max(maxPath, treeMaxPath);

        return Math.max(root.val, Math.max(leftPathMax + root.val, rightPathMax + root.val));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        P124_PathSum p124_pathSum = new P124_PathSum();
        System.out.println(p124_pathSum.maxPathSum(root));
    }
}
