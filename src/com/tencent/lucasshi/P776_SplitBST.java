package com.tencent.lucasshi;

public class P776_SplitBST {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode bigestSmall = helper(root, V);
        TreeNode[] res = new TreeNode[2];
        //
        if (bigestSmall == root) {
            res[0] = root.right;
            res[1] = root;
            root.right = null;
        } else {
            // != null
            TreeNode father = null;
            TreeNode p = root;
            while (p != bigestSmall) {
                if (p.val > bigestSmall.val) {
                    father = p;
                    p = p.left;
                } else {
                    father = p;
                    p = p.left;
                }
            }

            if (father.right == p) {
                father.right = p.right;
            } else {
                father.left = p.right;
            }
        }
        return null;
    }

    public TreeNode helper(TreeNode root, int V) {
        if (root == null)
            return null;

        if (root.val == V)
            return root;

        if (root.val < V) {
            TreeNode p = helper(root.right, V);
            if (p == null)
                return root;
            return p;
        } else {
            return helper(root.left, V);
        }
    }
}
