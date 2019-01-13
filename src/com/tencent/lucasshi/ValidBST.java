package com.tencent.lucasshi;

public class ValidBST {
    public boolean validBst(TreeNode root) {
        return validBst(root);
    }

    public boolean helper(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null)
            return true;
        if (max != null && root.val > max.val) {
            return false;
        }

        if (min != null && root.val < min.val) {
            return false;
        }

        if (!helper(root.left, root, min))
            return false;
        return helper(root.right, max, root.right);
    }
}
