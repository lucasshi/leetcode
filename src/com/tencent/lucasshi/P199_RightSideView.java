package com.tencent.lucasshi;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by fzy on 17/5/14.
 */
public class P199_RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;
        // do
        queue.offer(root);
        result.add(root.val);
        while (!queue.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }
            }

            if (nodes.size() != 0) {
                result.add(nodes.get(nodes.size() - 1).val);
            }
            for (TreeNode node : nodes) {
                queue.add(node);
            }
        }

        return result;
    }
}
