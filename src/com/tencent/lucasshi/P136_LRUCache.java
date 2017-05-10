package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by fzy on 17/5/6.
 */
class P136_LRUCache {
    class DoubleListNode {
        DoubleListNode prev;
        DoubleListNode next;
        int value;
        int key;
    }

    private HashMap<Integer, DoubleListNode> cache;
    private DoubleListNode head;
    private DoubleListNode tail;
    private int capacity;
    private int size;

    public P136_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, DoubleListNode>();
        this.size = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        // LRU Cache
        DoubleListNode node = cache.get(key);
        if (node == head) {
            return node.value;
        }

        if (node == tail) {
            tail = tail.prev;
            node.prev.next = node.next;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;

        return node.value;
    }

    public void put(int key, int value) {
        // contains
        if (cache.containsKey(key)) {
            DoubleListNode node = cache.get(key);
            if (node == head) {
                node.value = value;
                return;
            }

            if (node == tail) {
                tail = tail.prev;
                node.prev.next = node.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;

            node.value = value;
            return;
        }

        size++;
        DoubleListNode node = new DoubleListNode();
        node.value = value;
        node.key = key;

        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        cache.put(key, node);

        if (size > capacity) {
            size = capacity;
            int tailkey = tail.key;
            cache.remove(tailkey);
            tail = tail.prev;
            tail.next = null;
        }
    }

    public static void main(String[] args) {
        P136_LRUCache lruCache = new P136_LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));

    }
}


