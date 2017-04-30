package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by fzy on 17/4/30.
 */
public class P101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> p = new ArrayList<>();
        List<TreeNode> q = new ArrayList<>();

        p.add(root);

        while (!p.isEmpty() || !q.isEmpty()) {
            if (q.isEmpty()) {
                if (!checkSymmetric(p)) {
                    return false;
                }

                for (TreeNode node : p) {
                    if (node != null) {
                        q.add(node.left);
                        q.add(node.right);
                    }
                }

                // 清空q
                p.clear();
            } else {
                if (!checkSymmetric(q)) {
                    return false;
                }

                for (TreeNode node : q) {
                    if (node != null) {
                        p.add(node.left);
                        p.add(node.right);
                    }
                }

                // 清空
                q.clear();
            }
        }

        return true;
    }

    public boolean checkSymmetric(List<TreeNode> queue) {
        for (int i = 0; i < queue.size(); i++) {
            TreeNode ele = queue.get(i);
            TreeNode symEle = queue.get(queue.size() - 1 - i);

            if (ele == null && symEle == null) {
                continue;
            }

            if (ele == null || symEle == null) {
                return false;
            }

            if (ele.val != symEle.val) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<TreeNode> n = new ArrayList<>();
        n.add(null);
        System.out.println(n.size());
    }
}
