package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

import java.util.Stack;

/**
 * Created by fzy on 17/10/13.
 */
public class FaceBook_InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            p = p.right;
            while (p.left != null)
                p = p.left;
            return p;
        }

        // others
        TreeNode lowestLeft = null;
        TreeNode ptr = root;
        while (ptr != p) {
            if (ptr.val > p.val) {
                lowestLeft = ptr;
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }

        return lowestLeft;
    }
}
