package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by fzy on 17/3/27.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class P23_MergeSortedList {
    public static ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        if (lists.length < 1) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        return o1.val - o2.val;
                    }
                });

        for (int i = 0; i < lists.length; i++) {
            if (null != lists[i]) {
                pq.add(lists[i]);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            mergedList.add(node.val);

            node = node.next;
            if (node != null) {
                pq.add(node);
            }
        }

        if (mergedList.size() == 0) {
            return null;
        }

        ListNode head = new ListNode(mergedList.get(0));
        ListNode p = head;
        for (int i = 1; i < mergedList.size(); i++) {
            p.next = new ListNode(mergedList.get(i));
            p = p.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode[] a = {};
        P23_MergeSortedList.mergeKLists(a);
    }
}
