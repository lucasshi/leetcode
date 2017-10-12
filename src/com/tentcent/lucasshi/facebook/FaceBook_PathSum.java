package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

/**
 * Created by fzy on 17/10/11.
 */
public class FaceBook_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root.left == null && root.right == null)
            return sum == root.val;

        boolean leftResult = false;
        if (root.left != null) {
            leftResult = hasPathSum(root.left, sum - root.val);
        }

        boolean rightResult = false;
        if (root.right != null) {
            rightResult = hasPathSum(root.right, sum - root.val);
        }

        return leftResult || rightResult;
    }
}
