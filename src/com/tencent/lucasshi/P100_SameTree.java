package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/29.
 */
public class P100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null) {
            return false;
        }

        if (q == null) {
            return false;
        }

        // other
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
