package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/6.
 */

public class P105_ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0  && inorder.length == 0) {
            return null;
        }

        if (preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        // 进行处理
        TreeNode center = new TreeNode(preorder[0]);
        int centerIndex = 0;
        for (int i = 0; i < inorder.length; i ++) {
            if (inorder[i] == preorder[0]) {
                centerIndex = i;
            }
        }

        // build left right
        TreeNode left = null;
        if (centerIndex > 0) {
            int[] preorderLeft = new int[centerIndex];
            for (int i = 0; i < preorderLeft.length; i++) {
                preorderLeft[i] = preorder[i + 1];
            }

            int[] inorderLeft = new int[centerIndex];
            for (int i = 0; i < inorderLeft.length; i++) {
                inorderLeft[i] = inorder[i];
            }
            left = buildTree(preorderLeft, inorderLeft);
        } else {
            left = null;
        }

        // build right
        TreeNode right = null;
        if (preorder.length - centerIndex - 1 > 0) {
            int[] preorderRight = new int[preorder.length - centerIndex - 1];
            for (int i = 0; i < preorderRight.length; i++) {
                preorderRight[i] = preorder[centerIndex + 1 + i];
            }

            int[] inorderRight = new int[preorder.length - centerIndex - 1];
            for (int i = 0; i < inorderRight.length; i++) {
                inorderRight[i] = inorder[centerIndex + 1 + i];
            }

            right = buildTree(preorderRight, inorderRight);
        } else {
            right = null;
        }


        center.left = left;
        center.right = right;
        return center;
    }
}
