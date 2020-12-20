package com.coding.basic.leetcode.list;

import com.coding.basic.List;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: data-structure-algorithm
 * @description: https://leetcode-cn.com/problems/linked-list-cycle/
 * @author: yrs
 * @create: 2020-12-19 18:36
 **/
public class CycleList {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针，如果相遇则证明有环
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
