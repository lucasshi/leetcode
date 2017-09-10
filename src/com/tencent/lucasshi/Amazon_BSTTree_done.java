package com.tencent.lucasshi;

import java.util.ArrayList;

/**
 * Created by fzy on 17/9/3.
 */
public class Amazon_BSTTree_done {
    public static int bstDistance(int[] values, int n, int node1, int node2) {
        if (values == null)
            return -1;
        TreeNode root = new TreeNode(values[0]);
        for (int i = 1; i < values.length; i++) {
            addNode(root, values[i]);
        }

        ArrayList<Integer> node1List = getPath(root, node1);
        ArrayList<Integer> node2List = getPath(root, node2);

        // get value
        if (node1List == null || node2List == null) {
            return -1;
        }

        int sameIndex = 0;
        for (sameIndex = 0; sameIndex < node1List.size() && sameIndex < node2List.size(); sameIndex++) {
            if (node1List.get(sameIndex) == node2List.get(sameIndex)) {
                continue;
            }
            break;
        }

        sameIndex--;
        return node1List.size() - 1 - sameIndex + node2List.size() - 1 - sameIndex;
    }

    public static ArrayList<Integer> getPath(TreeNode root, int value) {
        TreeNode p = root;
        ArrayList<Integer> nodeList = new ArrayList<>();
        while (true) {
            if (p == null)
                return null;

            if (p.val == value) {
                nodeList.add(p.val);
                break;
            }

            // p.val
            if (p.val > value) {
                nodeList.add(p.val);
                p = p.left;
                continue;
            }

            if (p.val < value) {
                nodeList.add(p.val);
                p = p.right;
                continue;
            }
        }

        return nodeList;
    }

    public static void addNode(TreeNode root, int value) {
        if (value < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(value);
            } else {
                addNode(root.left, value);
            }
        }

        if (value > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(value);
            } else {
                addNode(root.right, value);
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] list = {5, 3, 6, 1, 4, 2};
        System.out.println(bstDistance(list, 6, 2, 4));
    }
}
