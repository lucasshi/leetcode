package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by fzy on 17/5/6.
 */
public class P144_Preorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        TreeNode p = root;
        while (!stack.empty() || p != null) {
            while (p != null) {
                result.add(p.val);
                p = p.left;
                stack.push(p);
            }

            while (!stack.empty()) {
                p = stack.pop();
                p = p.right;
                if (p != null) {
                    break;
                }
            }
        }

        return result;
    }
}
