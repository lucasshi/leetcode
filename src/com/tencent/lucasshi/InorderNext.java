package com.tencent.lucasshi;

import java.util.Stack;

public class InorderNext {
    public TreeNode cursor;
    public Stack<TreeNode> stack = new Stack<>();

    public TreeNode next() {
        if (cursor.left != null) {
            stack.push(cursor);
            cursor = cursor.left;
            return cursor;
        } else if (cursor.right != null) {
            cursor = cursor.right;
            return cursor;
        }

        while (!stack.empty()) {
            TreeNode top = stack.pop();
            if (top.right != null) {
                cursor = top.right;
                return cursor;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(16);

        InorderNext inorderNext = new InorderNext();
        inorderNext.cursor = root;
        System.out.println(inorderNext.next().val);
        System.out.println(inorderNext.next().val);
        System.out.println(inorderNext.next().val);
        System.out.println(inorderNext.next().val);
        System.out.println(inorderNext.next().val);
    }
}
