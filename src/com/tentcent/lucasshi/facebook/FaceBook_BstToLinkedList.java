package com.tentcent.lucasshi.facebook;


import com.tencent.lucasshi.TreeNode;

import java.util.Stack;

/**
 * Created by fzy on 17/10/8.
 */
public class FaceBook_BstToLinkedList {
    public TreeNode bstToLinkedList(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        stack.push(root);
        TreeNode listP = null;
        TreeNode head = null;

        // iter
        while (!stack.empty()) {
            while (p.left != null) {
                p = p.left;
                stack.push(p);
            }

            while (!stack.empty()) {
                p = stack.pop();
                if (listP == null) {
                    listP = p;
                    head = p;
                } else {
                    listP.next = p;
                    listP = p;
                }

                if (p.right != null) {
                    p = p.right;
                    stack.push(p);
                    break;
                }
            }
        }

        return listP;
    }
}
