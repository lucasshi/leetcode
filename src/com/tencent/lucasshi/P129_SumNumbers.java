package com.tencent.lucasshi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by fzy on 17/5/1.
 */
public class P129_SumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> p = new LinkedList<>();
        Queue<Integer> values = new LinkedList<>();
        int result = 0;

        p.offer(root);
        values.offer(root.val);

        while (!p.isEmpty()) {
            TreeNode treeNode = p.poll();
            int value = values.poll();

            if (treeNode.left == null && treeNode.right == null) {
                result += value;
                continue;
            }

            if (treeNode.left != null) {
                TreeNode leftNode = treeNode.left;
                int leftValue = value * 10 + leftNode.val;

                p.offer(leftNode);
                values.offer(leftValue);
            }

            if (treeNode.right !=null) {
                TreeNode rightNode = treeNode.right;
                int rightValue = value * 10 + rightNode.val;

                p.offer(rightNode);
                values.offer(rightValue);
            }
        }

        return result;
    }
}
