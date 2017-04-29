package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/29.
 */
public class P82_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode resultHead = null;
        ListNode resultP = null;
        ListNode p = head;

        // do
        while (p != null) {
            int value = p.val;
            int count = 0;
            for (; p != null; p = p.next) {
                if (p.val != value) {
                    break;
                }
                count += 1;
            }

            // 进行处理
            if (count == 1) {
                if (resultHead == null) {
                    resultHead = new ListNode(value);
                    resultP = resultHead;
                } else {
                    resultP.next = new ListNode(value);
                    resultP = resultP.next;
                }
            }
        }

        return resultHead;
    }
}
