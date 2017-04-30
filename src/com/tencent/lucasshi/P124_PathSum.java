package com.tencent.lucasshi;

import java.util.Map;

/**
 * Created by fzy on 17/4/30.
 */
public class P124_PathSum {
    public static int treeMaxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxPathSumWithNode(root);
        return treeMaxPath;
    }

    public int maxPathSumWithNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int curVal = root.val;
        int leftSum = maxPathSumWithNode(root.left);
        int rightSum = maxPathSumWithNode(root.right);

        // 这个只记录了单跳
        int singlePathMax = root.val;
        singlePathMax = Math.max(leftSum + curVal, singlePathMax);
        singlePathMax = Math.max(rightSum + curVal, singlePathMax);

        int doublePathMax = leftSum + rightSum + root.val;
        treeMaxPath = Math.max(treeMaxPath, singlePathMax);
        treeMaxPath = Math.max(treeMaxPath, doublePathMax);

        return singlePathMax;
    }
}
