package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by fzy on 17/4/29.
 */
public class P94_InOrderTraversal {
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
                    System.out.println(p.val);
                }
                p = p.right;
                nodeStack.push(p);
            }
        }
    }
}
