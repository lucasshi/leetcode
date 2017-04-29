package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by fzy on 17/4/29.
 */
public class P99_RecoverBinaryTree {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> inorderList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode p = root;
        while (!stack.empty()) {
            // left node
            while (p.left != null) {
                stack.push(p.left);
                p = p.left;
            }

            while (!stack.empty()) {
                p = stack.pop();
                inorderList.add(p);

                if (p.right != null) {
                    stack.push(p.right);
                    p = p.right;
                    break;
                }
            }
        }

        int wrongIndex1 = -1;
        int wrongIndex2 = -1;
        for (int i = 0; i < inorderList.size(); i++) {
            if (inorderList.get(i).val > inorderList.get(i + 1).val) {
                wrongIndex1 = i;
            }
        }

        for (int i = inorderList.size() - 1; i > 0; i--) {
            if (inorderList.get(i).val < inorderList.get(i - 1).val) {
                wrongIndex2 = i;
            }
        }

        int tmp = inorderList.get(wrongIndex1).val;
        inorderList.get(wrongIndex1).val = inorderList.get(wrongIndex2).val;
        inorderList.get(wrongIndex2).val = tmp;

        return;
    }
}
