package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/19.
 */
public class P543_DiameterOfBinaryTree {
    private int diameter = -1;

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth + rightDepth + 1 > diameter) {
            diameter = leftDepth + rightDepth + 1;
        }

        return Math.max(leftDepth, rightDepth);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return diameter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        P543_DiameterOfBinaryTree p = new P543_DiameterOfBinaryTree();
        p.diameterOfBinaryTree(root);
    }
}
