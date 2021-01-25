package com.tencent.lucasshi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P297_SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    private static int deserializeIndex = 0;
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";

        String lstring = serialize(root.left);
        String rstring = serialize(root.right);
        return root.val + "," + lstring + "," + rstring;
    }

    public TreeNode deserialize(String data) {
        deserializeIndex = 0;
        String[] segs = data.split(",");
        return helper(segs);
    }

    public TreeNode helper(String[] segs) {
        if (segs[deserializeIndex].equals("#"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(segs[deserializeIndex]));
        deserializeIndex += 1;
        root.left = helper(segs);

        deserializeIndex += 1;
        root.right = helper(segs);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(110);
        root.left.left = new TreeNode(18);
        root.left.right = new TreeNode(17);
        root.right = new TreeNode(16);

        P297_SerializeDeserializeBinaryTree p = new P297_SerializeDeserializeBinaryTree();
        System.out.println(p.serialize(root));
        TreeNode root2 = p.deserialize(p.serialize(root));
        //p.test("wef");
    }
}
