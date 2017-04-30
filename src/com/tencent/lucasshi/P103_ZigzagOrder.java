package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/4/30.
 */
public class P103_ZigzagOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<TreeNode> p = new ArrayList<>();
        List<TreeNode> q = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        p.add(root);

        while (!p.isEmpty() || !q.isEmpty()) {
            if (q.isEmpty()) {
                List<Integer> subResult = new ArrayList<>();
                for (TreeNode node : p) {
                    if (node != null) {
                        subResult.add(node.val);
                    }
                }

                for (int i = p.size() - 1; i >= 0; i--) {
                    TreeNode node = p.get(i);
                    if (node != null) {
                        q.add(node.right);
                        q.add(node.left);
                    }
                }

                if (subResult.size() != 0) {
                    result.add(subResult);
                }
                // 清空q
                p.clear();
            } else {
                List<Integer> subResult = new ArrayList<>();
                for (TreeNode node : q) {
                    if (node != null) {
                        subResult.add(node.val);
                    }
                }

                // add next
                for (int i = q.size() - 1; i >= 0; i--) {
                    TreeNode node = q.get(i);
                    if (node != null) {
                        p.add(node.left);
                        p.add(node.right);
                    }
                }

                if (subResult.size() != 0) {
                    result.add(subResult);
                }
                q.clear();
            }
        }

        return result;
    }
}
