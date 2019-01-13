package com.tencent.lucasshi;

public class FindKBst {
    public int findKBst(TreeNode root, int k) {
        TreeNode result = new TreeNode(-1);
        helper(root, result, k);
        return result.val;
    }

    public int helper(TreeNode root, TreeNode result, int k) {
        if (root == null)
            return 0;
        System.out.println(k + " " + root.val);

        int leftCount = helper(root.left, result, k);
        // we find
        if (result.val != -1)
            return 0;
        if (leftCount == k - 1) {
            result.val = root.val;
            System.out.println("haha1 we find" + result.val);
            return 0;
        }

        int rightCount = helper(root.right, result, k - leftCount - 1);
        if (result.val != -1) {
            System.out.println("haha1 we find" + result.val);
            return 0;
        }
        return leftCount + rightCount + 1;
    }

    public void test(TreeNode root) {
        root = new TreeNode(1);
    }

    public static void main(String[] args) {
        FindKBst p = new FindKBst();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(11);
        root.right.right.left= new TreeNode(10);
        p.findKBst(root, 3);

    }
}
