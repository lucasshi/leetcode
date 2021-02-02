package com.tencent.lucasshi;

public class P1023_maxAncestorDiff {
    private int value = 0;
    public int maxAncestorDiff(TreeNode root) {
        value = 0;
        helper(root, root.val, root.val);
        return value;
    }

    private void helper(TreeNode root, int min, int max) {
        if (root == null)
            return;

        value = Math.max(value, Math.abs(min - root.val));
        value = Math.max(value, Math.abs(max - root.val));

        helper(root.left, Math.min(root.val, min), Math.max(max, root.val));
        helper(root.right, Math.min(root.val, min), Math.max(max, root.val));
    }


}
