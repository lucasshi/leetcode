package com.tencent.lucasshi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P297_SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "#,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }


    // Decodes your encoded data to tree.
    public TreeNode helper(List<String> datas) {
        if (datas.get(0).equals("#")) {
            datas.remove(0);
            return null;
        }
        System.out.println(datas);
        TreeNode root = new TreeNode(Integer.valueOf(datas.get(0)));
        datas.remove(0);
        root.left = helper(datas);
        root.right = helper(datas);
        return root;
    }

    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return helper(data_list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(110);
        root.left.left = new TreeNode(18);
        root.left.right = new TreeNode(17);
        root.right = new TreeNode(16);

        P297_SerializeDeserializeBinaryTree p = new P297_SerializeDeserializeBinaryTree();
        //System.out.println(p.serialize(root));
        TreeNode root2 = p.deserialize(p.serialize(root));
        //p.test("wef");
    }
}
