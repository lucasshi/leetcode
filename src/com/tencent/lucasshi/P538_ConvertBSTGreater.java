package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by fzy on 17/9/17.
 */
public class P538_ConvertBSTGreater {
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        // root
        TreeNode p = root;
        stack.push(root);

        while (!stack.empty()) {
            if (p.left != null) {
                p = p.left;
                stack.push(p);
                continue;
            }

            while (!stack.empty()) {
                p = stack.pop();
                nodeList.add(p);
                if (p.right != null) {
                    p = p.right;
                    stack.push(p);
                    break;
                }
            }
        }

        // buildArray
        int[] sumArray = new int[nodeList.size()];
        for (int i = sumArray.length - 1; i >= 0; i--) {
            if (i == sumArray.length - 1) {
                sumArray[i] = 0;
                continue;
            }
            sumArray[i] = sumArray[i + 1] + nodeList.get(i + 1).val;
        }

        // other
        for (int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).val += sumArray[i];
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);

        P538_ConvertBSTGreater p = new P538_ConvertBSTGreater();
        p.convertBST(root);

    }
}
