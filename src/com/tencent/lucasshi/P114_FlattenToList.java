package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/30.
 */
public class P114_FlattenToList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode leftNode = root.left;
        TreeNode right = root.right;

        flatten(root.left);
        flatten(root.right);

        root.left = null;
        root.right = leftNode;
        TreeNode pointer = root;
        while (pointer.right != null) {
            pointer = pointer.right;
        }

        pointer.right = right;
    }
}
