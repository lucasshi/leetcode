package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/17.
 */
public class P449_SerializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        int val = root.val;
        String leftString = serialize(root.left);
        String rightString = serialize(root.right);

        if (leftString.length() == 0) {
            if (rightString.length() == 0) {
                return val + "";
            }

            return val + "," + rightString;
        }

        if (rightString.length() == 0) {
            return val + "," + leftString;
        }

        return val + "," + leftString + "," + rightString;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] input = data.split(",");
        return buildTree(input, 0, input.length - 1);
    }

    public TreeNode buildTree(String[] input, int startIndex, int endIndex) {
        int val = Integer.parseInt(input[startIndex]);
        if (startIndex > endIndex) {
            return null;
        }
        if (startIndex == endIndex) {
            return new TreeNode(val);
        }

        // other
        TreeNode root = new TreeNode(val);
        int index = startIndex + 1;
        boolean findBigger = false;
        for (; index <= endIndex; index++) {
            int tmpVal = Integer.parseInt(input[index]);
            if (tmpVal > val) {
                findBigger = true;
                break;
            }
        }

        if (findBigger) {
            root.left = buildTree(input, startIndex + 1, index - 1);
            root.right = buildTree(input, index, endIndex);
        } else {
            root.left = buildTree(input, startIndex + 1, endIndex);
            root.right = null;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);


        P449_SerializeBST p = new P449_SerializeBST();
        System.out.println(p.serialize(root));

        TreeNode root1 = p.deserialize("3,2,5,4,6");
        System.out.println(root1.val);
        System.out.println(root1.left.val);
        System.out.println(root1.right.val);
        System.out.println(root1.right.left.val);
        System.out.println(root1.right.right.val);

        System.out.println("".split(",").length);
    }
}
