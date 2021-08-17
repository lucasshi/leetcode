package com.tencent.lucasshi;

import java.util.LinkedList;
import java.util.Stack;

public class P173_BSTIterator {
    Stack<TreeNode> stack;
    TreeNode pNode;

    public P173_BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pNode = root;
    }

    public int next () {
        while (pNode != null) {
            stack.push(pNode);
            pNode = pNode.left;
        }

        TreeNode node = stack.pop();
        pNode = node.right;
        return node.val;
    }

    public boolean hasNext () {
        if (stack.empty() && pNode == null)
            return false;

        return true;
    }

    public void inOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                System.out.print(node.val+"  ");
                pNode = node.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        P173_BSTIterator p173_BSTIterator = new P173_BSTIterator(root);
        while (p173_BSTIterator.hasNext())
            System.out.println(p173_BSTIterator.next());
    }
}
