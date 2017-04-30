package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/30.
 */
public class P111_MinDepth {
    public int minDepth(TreeNode root) {
        // 说明是叶子节点
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);

        return Math.min(leftMin, rightMin) + 1;
    }
}
