package com.tencent.lucasshi;

public class P951_flipEquiv {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null)
            return false;
        if (root1 != null && root2 == null)
            return false;
        if (root1 == null && root2 == null)
            return true;


        if (root1.val != root2.val)
            return false;

        if (flipEquiv(root1.left, root2.left)) {
            return flipEquiv(root1.right, root2.right);
        } else if (flipEquiv(root1.left, root2.right)) {
            return flipEquiv(root1.right, root2.left);
        }

        return false;
    }
}
