package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

public class P958_isCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        boolean isLeaf = false;

        while (nodes.size() != 0) {
            List<Boolean> nextCode = new ArrayList<>();
            List<TreeNode> nextNodes = new ArrayList<>();

            for (TreeNode node: nodes) {
                if (isLeaf && node.left != null)
                    return false;

                if (isLeaf && node.right != null)
                    return false;

                nextCode.add(node.left != null);
                nextCode.add(node.right != null);

                if (node.left != null) {
                    nextNodes.add(node.left);
                }

                if (node.right != null) {
                    nextNodes.add(node.right);
                }
            }

            boolean meetNull = false;
            for (boolean code: nextCode) {
                if (isLeaf && code != false)
                    return false;

                if (code == false) {
                    isLeaf = true;
                    meetNull = true;
                    continue;
                } else if (meetNull && code == true) {
                    return false;
                }
            }
            nodes = nextNodes;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        P958_isCompleteTree p958_isCompleteTree = new P958_isCompleteTree();
        System.out.println(p958_isCompleteTree.isCompleteTree(root));

    }
}
