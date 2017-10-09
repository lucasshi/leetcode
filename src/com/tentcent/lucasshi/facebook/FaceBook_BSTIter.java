package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

import java.util.Stack;

/**
 * Created by fzy on 17/10/3.
 */
public class FaceBook_BSTIter {
    private TreeNode curr;
    private TreeNode p;
    private Stack<TreeNode> stack;

    void init(TreeNode root) {
        stack = new Stack<>();
        p = root;
        stack.push(p);
        while (p.left != null) {
            p = p.left;
            stack.push(p);
        }
    }

    void initV2(TreeNode root) {
        stack.clear();
        p = root;
        curr = null;
    }

    public int next() {
        return curr.val;
    }

    public boolean hasNext() {
        if (stack.empty())
            return false;

        curr = stack.pop();
        p = curr;

        if (p.right != null) {
            p = p.right;
            stack.push(p);
            while (p.left != null) {
                p = p.left;
                stack.push(p);
            }
        }

        return true;
    }

    public int nextV2() {
        return curr.val;
    }

    public boolean hasNextV2() {
        if (curr == null) {
            if (p == null) {
                return false;
            } else {
                curr = p;
                return true;
            }
        }

        if (curr.left != null) {
            stack.push(curr);
            curr = curr.left;
            return true;
        }

        stack.push(curr);
        while (!stack.empty()) {
            TreeNode p = stack.pop();
            if (p.right != null) {
                curr = p.right;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);

        FaceBook_BSTIter iter = new FaceBook_BSTIter();
        iter.init(root);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("haha");

        iter.initV2(root);
        while (iter.hasNextV2()) {
            System.out.println(iter.next());
        }
    }

}
