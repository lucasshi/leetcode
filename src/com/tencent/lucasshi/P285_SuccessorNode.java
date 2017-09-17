package com.tencent.lucasshi;

import java.util.Stack;

/**
 * Created by fzy on 17/9/17.
 */
public class P285_SuccessorNode {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cursor;

        // check cursor
        if (p.right != null) {
            cursor = p.right;
            while (cursor.left != null) {
                cursor = cursor.left;
            }

            return cursor;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        cursor = root;
        while (cursor != p) {
            nodeStack.push(cursor);
            if (cursor.val > p.val) {
                cursor = cursor.left;
            } else {
                cursor = cursor.right;
            }
        }

        System.out.println(nodeStack.size());
        // do iter
        cursor = null;
        TreeNode target = p;
        while (!nodeStack.empty()) {
            cursor = nodeStack.pop();
            if (cursor.left == target || cursor == root)
                break;
            target = cursor;
        }

        System.out.println(cursor.val);
        System.out.println(target.val);

        // find cursor 说明没用了
        if (cursor == root && cursor.right == target) {
            return null;
        }

        return cursor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        P285_SuccessorNode p = new P285_SuccessorNode();
        p.inorderSuccessor(root, root.right);
    }
}
