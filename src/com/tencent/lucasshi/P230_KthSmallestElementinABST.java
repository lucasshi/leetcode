package com.tencent.lucasshi;

/**
 * Created by fzy on 17/7/31.
 */
public class P230_KthSmallestElementinABST {
    public int count = 0;
    public boolean stop = false;
    public int val = 123103809;

    public int kthSmallest(TreeNode root, int k) {
        visitNodes(root, k);
        return val;
    }

    public void visitNodes(TreeNode root, int k) {
        if (root == null)
            return;
        if (stop)
            return;

        visitNodes(root.left, k);
        count++;
        if (count == k) {
            stop = true;
            val = root.val;
            return;
        }
        visitNodes(root.right, k);
    }

    class FunctionRet {
        int count;
        TreeNode retNode;

        FunctionRet(int _count, TreeNode _retNode) {
            this.count = _count;
            this.retNode = _retNode;
        }
    }


    public FunctionRet helper(TreeNode root, int k) {
        if (root == null)
            return new FunctionRet(0, null);
        // do
        FunctionRet leftRet = helper(root.left, k);
        if (leftRet.retNode != null)
            return leftRet;
        else if (leftRet.count == k - 1) {
            return new FunctionRet(k, root.left);
        }
        // do
        FunctionRet rightRet = helper(root.right, k - leftRet.count - 1);
        if (rightRet.retNode != null)
            return rightRet;
        return new FunctionRet(rightRet.count + leftRet.count + 1, null);
    }
}
