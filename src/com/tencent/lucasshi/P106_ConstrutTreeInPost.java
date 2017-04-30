package com.tencent.lucasshi;

import java.util.Arrays;

/**
 * Created by fzy on 17/4/30.
 */
public class P106_ConstrutTreeInPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }

        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }

        int index = indexOf(inorder, postorder[postorder.length - 1]);
        TreeNode node = new TreeNode(inorder[index]);
        if (index >= 1) {
            node.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        }

        if (postorder.length - 1 >= index)
            node.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));
        return node;
    }

    public int indexOf(int[] arr, int val) {
        if (arr == null || arr.length == 0) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
