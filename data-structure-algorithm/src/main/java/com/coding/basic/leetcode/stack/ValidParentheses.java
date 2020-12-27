package com.coding.basic.leetcode.stack;


import java.util.Stack;

/**
 * @program: data-structure-algorithm
 * @description: https://leetcode-cn.com/problems/valid-parentheses/
 * 遇到左字符入栈，遇到右字符，弹出栈顶元素比较
 *
 * @author: yrs
 * @create: 2020-12-27 15:46
 **/
public class ValidParentheses {

    /**
     * 字符串匹配
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.isEmpty();
    }

    /**
     * 利用栈实现，遇到左字符入栈，遇到右字符，弹出栈顶元素比较
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack();
        int lenth = s.length();
        for (int i = 0; i < lenth; i++) {
            Character c = s.charAt(i);
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                stack.push(c);
            } else {
                if (stack.empty()) return false;

                Character top = stack.pop();
                if (top.equals('(') && !c.equals(')')) return false;
                if (top.equals('[') && !c.equals(']')) return false;
                if (top.equals('{') && !c.equals('}')) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid2("()"));
    }

}
