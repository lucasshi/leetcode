package com.tencent.lucasshi;

public class P426_treeToDoublyList {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        Node[] result = helper(root);
        result[1].right = result[0];
        result[0].left = result[1];
        return result[0];
    }

    public Node[] helper(Node root) {
        if (root == null)
            return null;

        Node[] result = new Node[2];
        Node[] leftRes = helper(root.left);

        if (leftRes == null) {
            result[0] = root;
        } else {
            result[0] = leftRes[0];
            // double linked list
            leftRes[1].right = root;
            root.left = leftRes[1];
        }

        Node[] rightRes = helper(root.right);
        if (rightRes == null) {
            result[1] = root;
        } else {
            result[1] = rightRes[1];
            rightRes[0].left = root;
            root.right = rightRes[0];
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        // done
        P426_treeToDoublyList p426_treeToDoublyList = new P426_treeToDoublyList();
        Node head = p426_treeToDoublyList.treeToDoublyList(root);
        System.out.println(head.val);
    }
}
