package com.tencent.lucasshi;

public class P1120_maximumAverageSubtree {
    double max = Integer.MIN_VALUE;
    TreeNode maxNode = null;

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }

    private double[] helper(TreeNode root) {
        if (root == null) return new double[] {0, 0};

        double curTotal = root.val;
        double count = 1;

        double[] leftCur = helper(root.left);
        double[] rightCur = helper(root.right);

        double allTotal = curTotal + leftCur[0] + rightCur[0];
        double allCount = count + leftCur[1] + rightCur[1];
        double avg = allTotal / allCount;

        if (count >= 1 && avg > max) { //taking "at least 1 child" into account
            max = avg;
            maxNode = root;
        }
        return new double[] {allTotal, allCount};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        P1120_maximumAverageSubtree p1120_maximumAverageSubtree = new P1120_maximumAverageSubtree();
        System.out.println(p1120_maximumAverageSubtree.maximumAverageSubtree(root));
    }
}
