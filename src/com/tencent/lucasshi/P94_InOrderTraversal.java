package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by fzy on 17/4/29.
 */
public class
P94_InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);

        return values;
    }

    public void inorder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }

    public void inorderV2(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();

        nodeStack.push(root);
        TreeNode p = root;
        while (!nodeStack.empty()) {
            p = p.left;
            if (p != null) {
                nodeStack.push(p);
                continue;
            }

            if (p == null) {

                p = nodeStack.pop();
                System.out.println(p.val);
                while (p.right == null) {
                    p = nodeStack.pop();
                    System.out.print(p.val);
                }
                p = p.right;
                nodeStack.push(p);
            }
        }
    }


    public void inOrderV3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        stack.push(root);

        while (!stack.empty()) {
            p = p.left;
            if (p != null) {
                stack.push(p);
                continue;
            }

            while (!stack.empty()) {
                p = stack.pop();
                System.out.print(p.val + " ");
                if (p.right != null) {
                    p = p.right;
                    stack.push(p);
                    break;
                }
            }
        }
        System.out.println();

    }


    public void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode p = root;

        while (!stack.empty()) {
            if (p.left != null) {
                p = p.left;
                stack.push(p);
            }

            while (!stack.empty()) {
                p = stack.pop();
                System.out.println(p);
                if (p.right != null) {
                    p = p.right;
                    stack.push(p);
                    break;
                }
            }
        }
    }

    public Stack<TreeNode> st;
    public TreeNode p;

    public void next() {
        p = st.pop();
        System.out.println(p.val);
    }

    public boolean hasNext() {
        if (st.empty() && p.right == null)
            return false;

        if (p.right != null) {
            p = p.right;
            st.push(p);
        }

        while (p.left != null) {
            p = p.left;
            st.push(p);
        }

        return true;
    }


    public void PreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        stack.push(root);

        while (!stack.empty()) {
            System.out.print(p.val + " ");
            p = p.left;
            if (p != null) {
                stack.push(p);
                continue;
            }

            while (!stack.empty()) {
                p = stack.pop();
                if (p.right != null) {
                    p = p.right;
                    stack.push(p);
                    break;
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);

        P94_InOrderTraversal p = new P94_InOrderTraversal();
        p.inOrderV3(root);
        p.PreOrder(root);
    }
}
