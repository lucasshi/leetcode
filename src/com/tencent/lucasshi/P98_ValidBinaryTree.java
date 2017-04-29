package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by fzy on 17/4/29.
 */
public class P98_ValidBinaryTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        List<Integer> inorderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode p = root;
        while (!stack.empty()) {
            // left node
            while (p.left != null) {
                stack.push(p.left);
                p = p.left;
            }

            p = stack.pop();
            inorderList.add(p.val);

            if (p.right != null) {
                stack.push(p.right);
                p = p.right;
            }
        }

        for (int i = 1; i < inorderList.size(); i++) {
            if (inorderList.get(i - 1) >= inorderList.get(i)) {
                return false;
            }
        }

        return true;
    }

}
