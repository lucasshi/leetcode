package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/30.
 */
public class P112_HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        boolean leftHas = hasPathSum(root.left, sum - root.val);
        boolean rightHas = hasPathSum(root.right, sum - root.val);

        return leftHas || rightHas;
    }
}
