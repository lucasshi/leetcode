package com.tencent.lucasshi;

/**
 * Created by fzy on 17/7/30.
 */
public class P222_CountTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int l = getLeft(root) + 1;
        int r = getRight(root) + 1;

        if (l == r) {
            return (2 << (l - 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int getLeft(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            root = root.left;
            ++count;
        }
        return count;
    }

    private int getRight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            root = root.right;
            ++count;
        }
        return count;
    }
}
