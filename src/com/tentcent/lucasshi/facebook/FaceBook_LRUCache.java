package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.ListNode;

import java.util.HashMap;

/**
 * Created by fzy on 17/10/12.
 */
public class FaceBook_LRUCache {
    class DoubleListNode {
        public DoubleListNode prev;
        public DoubleListNode next;
        public int val;

        public DoubleListNode(int val) {
            this.val = val;
        }
    }

    class LRUCache {
        private HashMap<Integer, DoubleListNode> hashMap;
        private DoubleListNode head;

        public LRUCache() {
            hashMap = new HashMap<>();
            head = null;
        }

        public void put(int key, int value) {
            if (!hashMap.containsKey(key)) {
                DoubleListNode node = new DoubleListNode(value);
                hashMap.put(key, node);

                if (head == null) {
                    head = node;
                }

                node.next = head;
                head.prev = node;
                head = node;
                return;
            }

            DoubleListNode node = hashMap.get(key);
            node.val = value;

            if (node != head) {
                node.prev.next = node.next;
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        public int get(int key) {
            if (!hashMap.containsKey(key))
                return -1;

            DoubleListNode node = hashMap.get(key);

            if (node != head) {
                node.prev.next = node.next;
                node.next = head;
                head.prev = node;
                head = node;
            }

            return node.val;
        }


    }
}
