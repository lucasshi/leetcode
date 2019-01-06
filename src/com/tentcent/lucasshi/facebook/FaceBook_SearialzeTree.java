package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

/**
 * Created by fzy on 17/10/15.
 */
public class FaceBook_SearialzeTree {
    public String serializeTree(TreeNode root) {
        if (root == null) {
            return "";
        }

        String left = serializeTree(root.left);
        String right = serializeTree(root.right);

        return root.val + "(" + left + ")" + "(" + right + ")";
    }

    public TreeNode deserializeTree(String input) {
        if (input.equals(""))
            return null;
        String leftString = "";
        String rootString = "";
        String rightString = "";

        rootString = input.substring(0, input.indexOf('('));
        input = input.substring(input.indexOf('('));
        int count = 0;
        int i = 0;
        for (i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                count++;
            } else if (input.charAt(i) == ')') {
                count--;
                if (count == 0)
                    break;
            }
        }

        leftString = i == 0 ? "" : input.substring(1, i);
        rightString = input.substring(i + 2, input.length() - 1);
        TreeNode root = new TreeNode(Integer.valueOf(rootString));

        root.left = deserializeTree(leftString);
        root.right = deserializeTree(rightString);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        FaceBook_SearialzeTree p = new FaceBook_SearialzeTree();
        String serialzeResult = p.serializeTree(root);
        // System.out.println(p.serializeTree(root));
        p.deserializeTree(serialzeResult);
    }
}
