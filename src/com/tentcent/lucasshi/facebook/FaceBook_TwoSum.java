package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

import java.util.Stack;

/**
 * Created by fzy on 17/10/2.
 */
public class FaceBook_TwoSum {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode p;

    public void init(TreeNode pNode) {
        this.p = pNode;
        while (p.left != null) {
            stack.push(p);
            p = p.left;
        }
        stack.push(p);
    }

    public void next() {
        p = stack.pop();
        System.out.println(p.val);
    }

    public boolean hasNext() {
        if (p.right != null) {
            p = p.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        } else {
            if (stack.empty())
                return false;
        }

        return true;
    }

    public void printStack() {
        for (int i = 0; i < stack.size(); i++)
            System.out.print(stack.get(i).val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(5);

        FaceBook_TwoSum p = new FaceBook_TwoSum();
        p.init(root);
        while (p.hasNext()) {
            p.next();
        }
    }
}
