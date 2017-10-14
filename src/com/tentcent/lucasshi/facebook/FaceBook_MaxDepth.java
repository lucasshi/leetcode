package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

/**
 * Created by fzy on 17/10/13.
 */
public class FaceBook_MaxDepth {
    public int getMaxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftMax = getMaxDepth(root.left);
        int rightMax = getMaxDepth(root.right);

        return Math.max(leftMax, rightMax) + 1;
    }
}
