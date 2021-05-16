package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by fzy on 17/4/29.
 */
public class P98_ValidBinaryTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean helper(TreeNode root, long upperBound, long lowerBound) {
        if (root == null)
            return true;
        if (root.val > upperBound || root.val < lowerBound)
            return false;
        return helper(root.left, root.val, lowerBound) && helper(root.right, upperBound, root.val);
    }

}
