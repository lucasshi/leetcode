package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

/**
 * Created by fzy on 17/10/13.
 */
public class FaceBook_IsSymentric {
    public boolean isSymmentric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;
        if (!isSymmentric(root1.left, root2.right))
            return false;

        if (!isSymmentric(root1.right, root2.left))
            return false;

        return true;
    }

    public void isSymentric(TreeNode root) {
        isSymmentric(root.left, root.right);
    }

    public static void main(String[] args) {

    }
}
