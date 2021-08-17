package com.tencent.lucasshi;

public class P333_largestBSTSubtree {
    class Ret {
        public boolean isBst;
        public int max;
        public int min;
        public int nodeCount;

        public Ret(boolean isBst, int max, int min, int nodeCount) {
            this.isBst = isBst;
            this.max = max;
            this.min = min;
            this.nodeCount = nodeCount;
        }
    }

    public static int MAX_RESULT = -1;
    public int largestBSTSubtree(TreeNode root) {
        MAX_RESULT = -1;
        helper(root);
        return MAX_RESULT;
    }

    public Ret helper(TreeNode root) {
        if (root == null)
            return new Ret(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        Ret leftRet = helper(root.left);
        Ret rightRet = helper(root.right);

        if (leftRet.isBst && rightRet.isBst) {
            boolean leftOk = leftRet.nodeCount == 0 || leftRet.max < root.val;
            boolean righOK = rightRet.nodeCount == 0 || rightRet.min > root.val;

            if (leftOk && righOK) {
                int min = leftRet.nodeCount == 0 ? root.val : leftRet.min;
                int max = rightRet.nodeCount == 0 ? root.val : rightRet.max;
                MAX_RESULT = Math.max(leftRet.nodeCount + rightRet.nodeCount + 1, MAX_RESULT);
                return new Ret(true, max, min, leftRet.nodeCount + rightRet.nodeCount + 1);
            }
        }

        return new Ret(false, -1, -1, leftRet.nodeCount + rightRet.nodeCount + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(7);
        P333_largestBSTSubtree p333_largestBSTSubtree = new P333_largestBSTSubtree();

        System.out.println(p333_largestBSTSubtree.largestBSTSubtree(root));
    }
}
