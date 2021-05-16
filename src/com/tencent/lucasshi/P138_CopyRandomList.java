package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 17/5/4.
 */
public class P138_CopyRandomList {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> mapping = new HashMap<>();
        return copyHelper(head, mapping);
    }

    public Node copyHelper(Node node, HashMap<Node, Node> mapping) {
        if (node == null)
            return null;

        if (mapping.containsKey(node)) {
            return mapping.get(node);
        }

        Node copyNode = new Node(node.val);
        mapping.put(node, copyNode);
        copyNode.random = copyHelper(node.random, mapping);
        copyNode.next = copyHelper(node.next, mapping);
        return copyNode;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.random = null;
        head.next = new Node(13);

        head.next.next = new Node(11);

        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        P138_CopyRandomList copyRandomList = new P138_CopyRandomList();
        Node result = copyRandomList.copyRandomList(head);
        System.out.println("wef");
    }
}
