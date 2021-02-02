package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P919_CBTInserter {
    static class CBTInserter {
        public List<TreeNode> nodeList;
        public TreeNode root;

        public CBTInserter(TreeNode root) {
            nodeList = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode pNode = queue.poll();
                nodeList.add(pNode);
                if (pNode.left != null) {
                    queue.add(pNode.left);
                }
                if (pNode.right != null) {
                    queue.add(pNode.right);
                }
            }

            this.root = root;
        }

        public int insert(int v) {
            int size = nodeList.size();
            int index = (size - 1) / 2;

            TreeNode nodeToInsert = new TreeNode(v);
            TreeNode parent = nodeList.get(index);
            if (parent.left != null) {
                parent.left = nodeToInsert;
            } else {
                parent.right = nodeToInsert;
            }

            nodeList.add(nodeToInsert);
            return parent.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        P919_CBTInserter.CBTInserter cbtInserter = new CBTInserter(root);
        cbtInserter.insert(7);
        cbtInserter.insert(8);
    }
}
