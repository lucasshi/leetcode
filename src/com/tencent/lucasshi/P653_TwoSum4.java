package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by fzy on 17/9/18.
 */
public class P653_TwoSum4 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        List<Integer> inorderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        stack.push(root);

        while (!stack.empty()) {
            if (p.left != null) {
                p = p.left;
                stack.push(p);
            }

            while (!stack.empty()) {
                p = stack.pop();
                inorderList.add(p.val);
                if (p.right != null) {
                    p = p.right;
                    stack.push(p);
                    break;
                }
            }
        }

        int start = 0;
        int end = inorderList.size() - 1;
        while (start < end) {
            int startVal = inorderList.get(start);
            int endVal = inorderList.get(end);

            if (startVal + endVal == k)
                return true;
            if (startVal + endVal > k) {
                end--;
                continue;
            }
            if (startVal + endVal < k) {
                start++;
                continue;
            }
        }

        return false;
    }
}
