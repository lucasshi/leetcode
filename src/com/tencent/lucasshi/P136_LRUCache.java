package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by fzy on 17/5/6.
 */
class P136_LRUCache {
    static class DoubleListNode {
        DoubleListNode prev;
        DoubleListNode next;
        int value;
        int key;

        DoubleListNode(final int key,
                       final int value) {
            this.value = value;
            this.key = key;
        }
    }


    static class LRUCache {
        private Map<Integer, DoubleListNode> cache;
        private DoubleListNode head;
        private DoubleListNode tail;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
        }

        public int get(int key) {
            final DoubleListNode valueNode = cache.getOrDefault(key, null);
            if (valueNode != null) {
                rearrange(valueNode);
                return valueNode.value;
            }

            return 0;
        }

        public void put(int key, int value) {
            cache.putIfAbsent(key, new DoubleListNode(key, value));
            final DoubleListNode node = cache.get(key);
            rearrange(node);
        }

        private void rearrange(final DoubleListNode node) {
            // rearrange
            if (node.next != null)
                node.next.prev = node.prev;
            if (node.prev != null)
                node.prev.next = node.next;

            // process head
            if (tail == null)
                tail = node;
            if (tail == node && tail.prev != null)
                tail = tail.prev;

            if (head != null) {
                node.next = head;
                node.prev = null;
                head.prev = node;
            }
            head = node;

            if (cache.size() > capacity) {
                cache.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
    }
}


