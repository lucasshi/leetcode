package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/4/30.
 */
public class P113_PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                List<Integer> path = new ArrayList<>();
                path.add(root.val);
                result.add(path);
                return result;
            }
        }

        List<List<Integer>> leftPaths = pathSum(root.left, sum - root.val);
        List<List<Integer>> rightPaths = pathSum(root.right, sum - root.val);

        for (List<Integer> leftPath : leftPaths) {
            leftPath.add(0, root.val);
            result.add(leftPath);
        }

        for (List<Integer> rightPath : rightPaths) {
            rightPath.add(0, root.val);
            result.add(rightPath);
        }

        return result;
    }
}
