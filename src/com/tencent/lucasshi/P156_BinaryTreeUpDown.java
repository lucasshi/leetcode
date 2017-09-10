package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/9.
 */
public class P156_BinaryTreeUpDown {
    public TreeNode BinaryUpsideDown(TreeNode root) {
        if (root.left == null)
            return root;

        TreeNode newRoot = BinaryUpsideDown(root.left);
        TreeNode p = newRoot;

        // do
        while (p.right != null) {
            p = p.right;
        }
        p.right = root;
        p.left = root.right;

        return newRoot;
    }
}
