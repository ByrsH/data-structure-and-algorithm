package com.coding.basic.leetcode.list;


/***
 * @description: https://leetcode.cn/problems/remove-linked-list-elements/
 * @author: yunhui
 * @create: 2023/4/9 3:05 PM
 **/
public class RemoveLinkedList203 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            if (head.val == val) {
                return null;
            } else {
                return head;
            }
        }
        // 虚拟头节点
        ListNode virtual = new ListNode();
        virtual.next = head;
        ListNode tmp = virtual;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return virtual.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        System.out.println(head);
        removeElements(head, 1);
    }


}
