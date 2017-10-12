package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

/**
 * Created by fzy on 17/10/10.
 */
public class FaceBook_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null)
            return 0;

        // leaves
        if (root.left == null && root.right == null) {
            if (isLeft)
                return root.val;
            return 0;
        }


        int leftSum = sumOfLeftLeaves(root.left, true);
        int rightSum = sumOfLeftLeaves(root.right, false);

        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        FaceBook_SumOfLeftLeaves p = new FaceBook_SumOfLeftLeaves();
        System.out.println(p.sumOfLeftLeaves(root, false));

    }
}
