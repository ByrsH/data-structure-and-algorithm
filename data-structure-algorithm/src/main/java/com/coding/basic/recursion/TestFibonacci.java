package com.coding.basic.recursion;

/**
 * Created by yrs on 2017/7/16.
 */
public class TestFibonacci {
    public static void main(String [] args) {
        Fibonacci fibonacci = new Fibonacci();
        Long oneTime = System.currentTimeMillis();
        int recuResult = fibonacci.recursion(40);
        Long twoTime = System.currentTimeMillis();
        int loopResult = fibonacci.loop(40);
        Long threeTime = System.currentTimeMillis();
        System.out.println(recuResult + " " + loopResult);
        System.out.println(twoTime - oneTime);
        System.out.println(threeTime - twoTime);
    }
}
                