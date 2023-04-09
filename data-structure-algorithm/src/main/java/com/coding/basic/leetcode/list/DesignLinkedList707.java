package com.coding.basic.leetcode.list;

/***
 * @description:  https://leetcode.cn/problems/design-linked-list/
 * @author: yunhui
 * @create: 2023/4/9 3:51 PM
 **/
public class DesignLinkedList707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        System.out.println(myLinkedList.get(1));              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        System.out.println(myLinkedList.get(1));              // 返回 3
        System.out.println(myLinkedList);
    }
}

class NewListNode {
    int val;
    NewListNode next;
    NewListNode() {}
    NewListNode(int val) { this.val = val; }
    NewListNode(int val, NewListNode next) { this.val = val; this.next = next; }
}

class MyLinkedList {

    //虚拟都节点
    NewListNode head;
    int size;

    public MyLinkedList() {
        this.size = 0;
        this.head = new NewListNode(0);
    }

    public int get(int index) {
        if (index >= this.size || index < 0) {
            return -1;
        }
        NewListNode tmp = head.next;
        while (index-- > 0) {
            tmp = tmp.next;
        }
        return tmp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(this.size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > this.size || index < 0) {
            return;
        }
        NewListNode newListNode = new NewListNode(val);
        if (index == 0) {
            newListNode.next = head.next;
            head.next = newListNode;
            size++;
            return;
        }
        NewListNode tmp = head.next;
        while (--index > 0) {
            tmp = tmp.next;
        }
        newListNode.next = tmp.next;
        tmp.next = newListNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= this.size || index < 0) {
            return;
        }
        if (index == 0) {
            head.next = head.next.next;
            size--;
            return;
        }
        NewListNode tmp = head.next;
        while (--index > 0) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        size--;
    }
}
