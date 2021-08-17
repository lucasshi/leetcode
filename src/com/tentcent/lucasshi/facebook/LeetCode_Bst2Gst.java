package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

public class LeetCode_Bst2Gst {
    private int sum = 0;

    public void bst2gst(TreeNode node) {
        if (node == null)
            return;

        bst2gst(node.right);
        sum += node.val;
        node.val = sum - node.val;
        bst2gst(node.left);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.right = new TreeNode(4);
        LeetCode_Bst2Gst leetCode_bst2Gst = new LeetCode_Bst2Gst();
        leetCode_bst2Gst.bst2gst(node);
        System.out.println(node.val);
    }
}
