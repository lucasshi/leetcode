package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

public class P863_AllNodesDistance {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        getDistance(root, target, K);
        helper(target, K);
        return result;
    }

    public void helper(TreeNode root, int k) {
        if (root == null || k < 0)
            return;
        if (k == 0) {
            result.add(root.val);
            return;
        }

        helper(root.left, k - 1);
        helper(root.right, k - 1);
    }

    public int getDistance(TreeNode root, TreeNode target, int k) {
        if (root == null)
            return -1;
        if (root == target)
            return 0;
        int leftDistance = getDistance(root.left, target, k);
        if (leftDistance != -1) {
            helper(root.right, k - leftDistance - 2);
            if (leftDistance + 1 == k)
                result.add(root.val);
            return leftDistance + 1;
        }
        int rightDistance = getDistance(root.right, target, k);
        if (rightDistance != -1) {
            helper(root.left, k - rightDistance - 2);
            if (rightDistance + 1 == k)
                result.add(root.val);
            return rightDistance + 1;
        }
        return -1;
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
        System.out.println(p.distanceK(root, root.right.left, 3));


    }
}
