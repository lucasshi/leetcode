package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

/**
 * Created by fzy on 17/10/11.
 */
public class Facebook_PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int midCount = 0;
        if (root.val == sum)
            midCount += 1;

        int leftCount = helper(root.left, sum - root.val);
        int rightCount = helper(root.right, sum - root.val);

        return leftCount + rightCount + midCount;
    }

    public static void main(String[] args) {

    }
}
