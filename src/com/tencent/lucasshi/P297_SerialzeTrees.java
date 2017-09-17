package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fzy on 17/9/16.
 */
public class P297_SerialzeTrees {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        List<String> nodesString = new ArrayList<>();
        queue.add(root);

        // queu
        while (!queue.isEmpty()) {
            ArrayList<TreeNode> childQueue = new ArrayList<>();
            boolean findNotNull = false;
            for (TreeNode treeNode : queue) {
                if (treeNode == null) {
                    nodesString.add("null");
                } else {
                    nodesString.add(String.valueOf(treeNode.val));
                }
                // left right
                if (treeNode == null) {
                    childQueue.add(null);
                    childQueue.add(null);
                    continue;
                }

                findNotNull = findNotNull || treeNode.left != null;
                childQueue.add(treeNode.left);

                findNotNull = findNotNull || treeNode.right != null;
                childQueue.add(treeNode.right);
            }

            if (!findNotNull) {
                break;
            }
            queue = childQueue;
        }

        return String.join(",", nodesString);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> stringList = Arrays.asList(data.split(","));
        LinkedList<TreeNode> nodesQueue = new LinkedList<>();

        if (stringList.get(0).equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(stringList.get(0)));
        nodesQueue.add(root);
        int index = 1;

        // startIndex
        while (index < stringList.size()) {
            TreeNode pNode = nodesQueue.poll();
            String leftString = stringList.get(index);
            String rightString = stringList.get(index + 1);

            if (pNode != null) {
                pNode.left = leftString.equals("null") ?
                        null : new TreeNode(Integer.parseInt(leftString));
                pNode.right = rightString.equals("null") ?
                        null : new TreeNode(Integer.parseInt(rightString));
                nodesQueue.add(pNode.left);
                nodesQueue.add(pNode.right);
            }

            // 肯定是null了
            if (pNode == null) {
                nodesQueue.add(null);
                nodesQueue.add(null);
            }

            index += 2;
        }

        return root;
    }

    //
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        P297_SerialzeTrees p = new P297_SerialzeTrees();
        System.out.println(p.serialize(root));
        TreeNode root2 = p.deserialize("1,2,3,null,null,4,5");
        System.out.println(root2.val);
        System.out.println(root2.left.val);
        System.out.println(root2.right.val);
        System.out.println(root2.left.left == null);
        System.out.println(root2.right.left.val);
        System.out.println(root2.right.right.val);


    }

}
