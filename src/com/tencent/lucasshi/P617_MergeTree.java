package com.tencent.lucasshi;

/**
 * Created by fzy on 17/7/30.
 */
public class P617_MergeTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null) {
            t1 = new TreeNode(t2.val);
            return t1;
        }

        if (t2 == null) {
            return t1;
        }

        t1.val += t2.val;
        if (t1.left == null && t2.left != null) {
            t1.left = new TreeNode(0);
            t1.left = mergeTrees(t1.left, t2.left);
        } else {
            t1.left = mergeTrees(t1.left, t2.left);
        }

        if (t1.right == null && t2.right != null) {
            t1.right = new TreeNode(0);
            t1.right = mergeTrees(t1.right, t2.right);
        } else {
            t1.right = mergeTrees(t1.right, t2.right);
        }

        return t1;
    }

    public static void main(String[] args) {

    }
}
