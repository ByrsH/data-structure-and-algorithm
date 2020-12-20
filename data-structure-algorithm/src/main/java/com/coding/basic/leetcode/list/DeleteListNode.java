package com.coding.basic.leetcode.list;

/**
 * @program: data-structure-algorithm
 * @description: https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @author: yrs
 * @create: 2020-12-19 14:22
 **/
public class DeleteListNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        if (head.val == val) {
            node = head.next;
            head.next = null;
            return node;
        }
        while (node.next != null) {
            if (node.next.val == val) {
                if (node.next.next == null) {
                    node.next = null;
                    return head;
                } else {
                    node.next = node.next.next;
                    return head;
                }
            }
            node = node.next;
        }
        return head;
    }

}
