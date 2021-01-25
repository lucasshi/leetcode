package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

public class P863_AllNodesDistance {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<TreeNode> path = getPath(root, target);
        // this is K
        helper(path.get(0), K);

        for (int i = 1; i < path.size(); i++) {
            TreeNode node = path.get(i);
            if (node.left == path.get(i - 1)) {
                helper(node.right, K - i - 1);
            } else {
                helper(node.left, K - i - 1);
            }

            // the right upper
            if (i == K)
                result.add(node.val);
        }

        return result;
    }

    public void helper(TreeNode root, int K) {
        if (root == null || K < 0)
            return;

        if (K == 0) {
            result.add(root.val);
            return;
        }

        helper(root.left, K - 1);
        helper(root.right, K - 1);
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        if (root == null) {
            return null;
        }

        if (root == target) {
            List<TreeNode> result = new ArrayList<>();
            result.add(root);
            return result;
        }

        List<TreeNode> leftPath = getPath(root.left, target);
        List<TreeNode> rightPath = getPath(root.right, target);
        if (leftPath != null) {
            leftPath.add(root);
            return leftPath;
        } else if (rightPath != null) {
            rightPath.add(root);
            return rightPath;
        }
        return null;
    }

    public static void main(String[] args) {
        // [0,2,1,null,null,3]
        // 3
        // 3
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        P863_AllNodesDistance p = new P863_AllNodesDistance();
        System.out.println(p.distanceK(root, root.right.left, 10));


    }
}
