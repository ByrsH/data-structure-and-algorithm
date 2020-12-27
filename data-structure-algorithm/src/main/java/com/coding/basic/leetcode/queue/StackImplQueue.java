package com.coding.basic.leetcode.queue;

import java.util.Stack;

/**
 * @program: data-structure-algorithm
 * @description: https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @author: yrs
 * @create: 2020-12-27 16:54
 **/
public class StackImplQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    /** Initialize your data structure here. */
    public StackImplQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        checkIsEmpty();
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        checkIsEmpty();
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }

    private void checkIsEmpty() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
