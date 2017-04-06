package com.tencent.lucasshi;

/**
 * Created by fzy on 17/3/27.
 */
public class P25_ReverseKGroup {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 进行交换
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] kBuffer = new ListNode[k];
        ListNode pNode = head;
        // 初始化的方法
        for (int i = 0; i < k; i++) {
            if (pNode == null)
                return head;
            kBuffer[i] = pNode;
            pNode = pNode.next;
        }

        // 进行处理
        while (true) {
            // do swap
            for (int i = 0; i < k / 2; i++) {
                int tmpVal = kBuffer[i].val;
                kBuffer[i].val = kBuffer[k - i - 1].val;
                kBuffer[k - i - 1].val = tmpVal;
            }

            boolean shouldBreak = false;
            pNode = kBuffer[k - 1].next;
            for (int i = 0; i < k; i++) {
                if (pNode == null) {
                    shouldBreak = true;
                    break;
                }
                kBuffer[i] = pNode;
                pNode = pNode.next;
            }

            if (shouldBreak) {
                break;
            }
        }

        return head;
    }
}
