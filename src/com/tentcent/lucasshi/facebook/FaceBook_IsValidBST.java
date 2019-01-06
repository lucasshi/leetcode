package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

/**
 * Created by fzy on 17/10/15.
 */
public class FaceBook_IsValidBST {
    class Ret {
        public boolean isValid;
        public int min;
        public int max;

        public Ret(boolean isValid, int min, int max) {
            this.isValid = isValid;
            this.min = min;
            this.max = max;
        }
    }

    public boolean IsValidBST(TreeNode root) {
        Ret ret = helper(root);
        return ret.isValid;
    }

    public Ret helper(TreeNode root) {
        if (root == null) {
            return new Ret(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Ret left = helper(root.left);
        if (left.isValid == false)
            return new Ret(false, 0, 0);

        Ret right = helper(root.right);
        if (right.isValid == false)
            return new Ret(false, 0, 0);

        if (left.max > root.val)
            return new Ret(false, 0, 0);

        if (right.min < root.val)
            return new Ret(false, 0, 0);

        int min = Math.min(left.min, root.val);
        int max = Math.max(right.max, root.val);

        return new Ret(true, min, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(11);
        root.right.right.left= new TreeNode(10);

        FaceBook_IsValidBST p = new FaceBook_IsValidBST();
        System.out.println(p.IsValidBST(root));
    }

}

