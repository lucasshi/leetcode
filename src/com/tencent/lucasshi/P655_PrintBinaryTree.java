package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P655_PrintBinaryTree {
    /*
    public void helper(TreeNode root, int i, int j, int curH, int height, List<List<String>> result) {
        if (curH == height || root == null)
            return;
        result.get(curH).set(i + j / 2, root.val + "");
        helper(root.left, i, i + j / 2 - 1, curH + 1, height, result);
        helper(root.right, i + j / 2 + 1, j, curH + 1, height, result);
    }


    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (int) (Math.pow(2, height)) - 1;

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            result.add(new ArrayList<>(width));
        }
        // do
        helper(root, 0, width - 1, 0, height, result);
        return result;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int lheight = getHeight(root.left);
        int rheight = getHeight(root.right);
        return Math.max(lheight, rheight) + 1;
    }
    */

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int lheight = getHeight(root.left);
        int rheight = getHeight(root.right);
        return Math.max(lheight + 1, rheight + 1);
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (int) (Math.pow(2, height)) - 1;
        List<List<String>> result = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            result.add(new ArrayList<>(Collections.nCopies(width, "")));
        }
        // parse
        helper(result, root, 0, 0, width - 1);
        return result;
    }

    public void helper(List<List<String>> result, TreeNode root, int height, int left, int right) {
        int index = (left + right) / 2;
        if (root == null) {
            return;
        }
        result.get(height).set(index, "" + root.val);
        helper(result, root.left, height + 1, left, index - 1);
        helper(result, root.right, height + 1, index + 1, right);
    }

    public static void main(String[] args) {
        P655_PrintBinaryTree p = new P655_PrintBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(p.printTree(root));
    }

}
