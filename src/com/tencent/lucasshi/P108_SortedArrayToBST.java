package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/30.
 */
public class P108_SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        //
        int midIndex = (nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);

        int[] leftNums = new int[midIndex];
        for (int i = 0; i < midIndex; i++) {
            leftNums[i] = nums[i];
        }
        TreeNode left = sortedArrayToBST(leftNums);

        int[] rightNums = new int[nums.length - 1 - midIndex];
        for (int i = midIndex + 1; i < nums.length; i++) {
            rightNums[i - midIndex - 1] = nums[i];
        }
        TreeNode right = sortedArrayToBST(rightNums);

        root.left = left;
        root.right = right;

        return root;
    }
}
