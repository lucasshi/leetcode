package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 17/9/21.
 */
public class P663_EqualPartition {
    public HashMap<Integer, TreeNode> sumVal;

    public boolean checkEqualTree(TreeNode root) {
        sumVal = new HashMap<>();
        int totalSum = getSum(root);

        if (totalSum % 2 != 0)
            return false;

        System.out.println("haha");

        return sumVal.containsKey(totalSum / 2) &&
                sumVal.get(totalSum / 2) != root;
    }

    public int getSum(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int sum = leftSum + rightSum + root.val;

        if (!sumVal.containsKey(sum)) {
            sumVal.put(sum, root);
        }
        return sum;
    }

    public static void main(String[] args) {
        P663_EqualPartition p = new P663_EqualPartition();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        System.out.println(p.checkEqualTree(root));
        System.out.println(-13 % 2);
    }
}
