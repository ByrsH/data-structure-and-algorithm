package com.coding.basic.recursion;

/**
 * Created by yrs on 2017/7/16.
 */
public class Fibonacci {
    public int recursion(int n) {
        if (n <= 1) {
            return n;
        }
        return recursion(n-1) + recursion(n-2);
    }

    public int loop(int n) {
        if (n <= 1) {
            return n;
        }
        int result=0;
        int a1 = 0;
        int a2 =1;
        for (int i=2; i<=n; i++) {
            result = a1 + a2;
            a1 = a2;
            a2 = result;
        }
        return result;
    }

}
                