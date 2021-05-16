package com.tencent.lucasshi;

public class Facebook_MedianInBinarySearchTree {
    private TreeNode result = null;
    private int index = 0;
    public TreeNode MedianInBinaryTree(TreeNode root) {
        int size = getSize(root);
        int median = (size + 1) / 2;
        helper(median, root);
        return result;
    }

    public void helper(int target, TreeNode root) {
        if (root == null)
            return;

        helper(target, root.left);
        if (result != null)
            return;

        index += 1;
        if (index == target) {
            result = root;
            return;
        }

        helper(target, root.right);
    }

    public int getSize(TreeNode root) {
        if (root == null)
            return 0;
        return getSize(root.left) + getSize(root.right) + 1;
    }
}
