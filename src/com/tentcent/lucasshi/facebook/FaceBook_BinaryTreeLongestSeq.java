package com.tentcent.lucasshi.facebook;

import com.apple.eawt.AppEvent;
import com.tencent.lucasshi.TreeNode;

/**
 * Created by fzy on 17/10/15.
 */
public class FaceBook_BinaryTreeLongestSeq {
    private int longest = 0;

    public int LogestSeq(TreeNode root) {
        helper(root, 1, root.val);
        return longest;
    }

    public void helper(TreeNode root, int length, int lastvalue) {
        if (root == null) {
            longest = Math.max(length, longest);
            return;
        }

        int nextLength = length;
        if (root.val - lastvalue == 1) {
            nextLength += 1;
        } else {
            nextLength = 1;
        }

        longest = Math.max(longest, nextLength);
        helper(root.left, nextLength, root.val);
        helper(root.right, nextLength, root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        FaceBook_BinaryTreeLongestSeq p = new FaceBook_BinaryTreeLongestSeq();
        System.out.println(p.LogestSeq(root));
    }
}
