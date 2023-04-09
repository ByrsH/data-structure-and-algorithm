package com.coding.basic.leetcode.list;

/***
 * @description: https://leetcode.cn/problems/swap-nodes-in-pairs/
 * @author: yunhui
 * @create: 2023/4/9 5:02 PM
 **/
public class SwapNodes24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // virtual --> 1  2  3  4  5
        //         --> 2   1  3  4
        ListNode virtual = new ListNode(-1);
        ListNode end = new ListNode(-1);
        virtual.next = head;
        end.next = head;
        ListNode pre = null;
        ListNode cur = head;
        boolean first = true;
        while (cur != null && cur.next != null) {
            pre = cur.next;
            cur.next = pre.next;
            if (first) {
                virtual.next = pre;
                first = false;
            }
            end.next = pre;
            pre.next = cur;
            end = cur;
            // 双指针前进
            cur = cur.next;
        }
        return virtual.next;

    }

}
