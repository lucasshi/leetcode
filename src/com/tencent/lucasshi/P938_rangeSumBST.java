package com.tencent.lucasshi;

public class P938_rangeSumBST {
    public int result = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        result = 0;
        helper(root, low, high);
        return result;
    }

    public void helper(TreeNode root, int low, int high) {
        if (root == null)
            return;

        if (root.val < low) {
            helper(root.right, low, high);
        } else if (root.val > high) {
            helper(root.left, low, high);
        } else {
            result += root.val;
            helper(root.left, low, high);
            helper(root.right, low, high);
        }
    }




}
