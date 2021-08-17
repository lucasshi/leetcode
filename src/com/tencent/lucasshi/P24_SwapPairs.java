package com.tencent.lucasshi;

/**
 * Created by fzy on 17/3/27.
 */

public class P24_SwapPairs {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null) {
            // do swap
            int tmpVal = p1.val;
            p1.val = p2.val;
            p2.val = tmpVal;

            p1 = p2.next;
            if (p1 == null) {
                break;
            }

            p2 = p1.next;
        }

        return head;
    }

    public ListNode swapPairsV2(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        ListNode ret = head.next;
        ListNode retNext = ret.next;

        ret.next = head;
        head.next = swapPairsV2(retNext);

        return ret;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        P24_SwapPairs p24_swapPairs = new P24_SwapPairs();
        ListNode newHead = p24_swapPairs.swapPairsV2(head);
        System.out.println(newHead);

    }
}
