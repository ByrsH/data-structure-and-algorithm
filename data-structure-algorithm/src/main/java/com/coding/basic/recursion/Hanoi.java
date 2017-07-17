package com.coding.basic.recursion;

/**
 * Created by yrs on 2017/7/16.
 */
public class Hanoi {
    public static int time = 0;
    public static void move(int n, char from, char to) {
        System.out.println("第" + (++time) + "次移动：把" + n + "号圆盘从 " + from + "-->移到" + to);
    }

    public static void hanoi(int n, char from, char temp, char to) {
        if (n==1) {
            move(1, from, to);
        }else {
            hanoi(n-1, from, to, temp);
            move(n, from, to);
            hanoi(n-1, temp, from, to);
        }
    }

    public static void main(String [] args) {
        char from = 'A';
        char temp = 'B';
        char to = 'C';
        hanoi(3, from, temp, to);
    }

}
                