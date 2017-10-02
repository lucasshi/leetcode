package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by fzy on 17/9/26.
 */
public class BSTIterator {
    public Stack<TreeNode> stack = new Stack<>();
    public TreeNode p;
    public HashSet<TreeNode> visited = new HashSet<>();

    public BSTIterator(TreeNode p) {
        this.stack.push(p);
        this.p = p;
    }

    public void next() {
        //printStack();
        p = stack.pop();
        System.out.println(p.val);
        visited.add(p);
    }

    public boolean hasNext() {
        if (visited.contains(p)) {
            if (p.right != null) {
                p = p.right;
                stack.push(p);
            } else {
                return !stack.empty();
            }
        }

        while (p.left != null) {
            p = p.left;
            stack.push(p);
        }

        return !stack.empty();
    }

    public void printStack() {
        for (int i = 0; i < stack.size(); i++)
            System.out.print(stack.get(i).val + " ");
        System.out.println();
        System.out.flush();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);

        BSTIterator bstIterator = new BSTIterator(root);
        while (bstIterator.hasNext()) {
            bstIterator.next();
        }

    }
}
