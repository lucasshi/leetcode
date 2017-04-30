package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/4/30.
 */
public class P102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
                        q.add(node.left);
                        q.add(node.right);
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
