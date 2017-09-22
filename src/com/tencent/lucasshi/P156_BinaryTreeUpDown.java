package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/9.
 */
public class P156_BinaryTreeUpDown {
    public TreeNode BinaryUpsideDown(TreeNode root) {
        if (root == null)
            return null;
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

        p.right.left = null;
        p.right.right = null;

        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);


        P156_BinaryTreeUpDown p = new P156_BinaryTreeUpDown();
        TreeNode newRoot = p.BinaryUpsideDown(root);
        System.out.println(newRoot.val);
        System.out.println(newRoot.left.val);
        System.out.println(newRoot.right.val);
        System.out.println(newRoot.right.left.val);
        System.out.println(newRoot.right.right.val);
    }


}
