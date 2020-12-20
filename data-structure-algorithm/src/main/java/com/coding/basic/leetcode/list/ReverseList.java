package com.coding.basic.leetcode.list;

/**
 * @program: data-structure-algorithm
 * @description: https://leetcode-cn.com/problems/reverse-linked-list/
 * @author: yrs
 * @create: 2020-12-19 17:11
 **/
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = null;
        ListNode tmp = null;
        while (head != null) {
            tmp = head.next;
            head.next = newNode;
            newNode = head;
            head = tmp;
        }
        return newNode;
    }

}
