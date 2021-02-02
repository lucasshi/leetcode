package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

public class P1123_lcaDeepestLeaves {
    private int maxDepth = 0;
    private List<List<TreeNode>> maxPaths = new ArrayList<>();

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        List<TreeNode> path = new ArrayList<>();
        getPath(root, path);

        TreeNode result = root;
        for (int i = 0; i < maxDepth; i++) {
            TreeNode first = maxPaths.get(0).get(i);
            for (int j = 1; j < maxPaths.size(); j++) {
                if (maxPaths.get(j).get(i) != first) {
                    return result;
                }
            }
            result = first;
        }
        return result;
    }

    public void getPath(TreeNode root, List<TreeNode> path) {
        if (root == null)
            return;

        path.add(root);
        if (root.left == null && root.right == null) {
            if (path.size() > maxDepth) {
                maxDepth = path.size();
                maxPaths.clear();
            }

            if (path.size() == maxDepth) {
                maxPaths.add(new ArrayList<>(path));
            }
        }

        getPath(root.left, path);
        getPath(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        P1123_lcaDeepestLeaves p1123_lcaDeepestLeaves = new P1123_lcaDeepestLeaves();
        p1123_lcaDeepestLeaves.lcaDeepestLeaves(root);
    }
}
