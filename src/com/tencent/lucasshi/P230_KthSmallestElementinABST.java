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
}
