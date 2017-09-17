package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/17.
 */
public class P572_SubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (isSameTree(s, t))
            return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t != null) {
            return false;
        }

        if (s != null && t == null) {
            return false;
        }

        if (s == null && t == null)
            return true;

        if (s.val != t.val) {
            return false;
        }

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        P572_SubTree p = new P572_SubTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);

        System.out.println(p.isSubtree(root, root2));
    }
}
