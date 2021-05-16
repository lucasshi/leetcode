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


        int mid = is;
        for (; inorder[mid] != preorder[ps]; mid++) {
        }

        int leftNodeSize = mid - is + 1;
        TreeNode root = new TreeNode(preorder[ps]);
        root.left = helper(preorder, inorder, ps + 1, ps + leftNodeSize, is, mid - 1);
        root.right = helper(preorder, inorder, ps + 1, ps + leftNodeSize, is, mid - 1);
        return root;
    }
}
