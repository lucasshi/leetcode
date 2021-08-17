package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/6.
 */

public class P105_ConstructBinaryTree {
    public TreeNode buildTreeV2(int[] preorder, int[] inorder) {

        return null;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe)
            return null;

        if (ps == pe)
            return new TreeNode(preorder[ps]);

        int mid = inorder[is];
        int i = ps;
        for (i = ps; i < pe && preorder[i] != mid; i++) {}

        int leftSize = i - ps;
        int rightSize = pe - i;
        TreeNode left = helper(preorder, inorder, ps , i - 1, is + 1, is + leftSize);
        TreeNode right = helper(preorder, inorder, i + 1 , pe, ie - rightSize, ie);

        TreeNode result = new TreeNode(preorder[ps]);
        result.left = left;
        result.right = right;
        return result;
    }
}
