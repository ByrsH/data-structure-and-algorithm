package com.coding.basic.recursion;

/**
 * 欧几里得算法
 *
 * @author ByrsH
 * @create 2017-09-04 22:13
 **/

public class GCD {
    public static int gcd(int p, int q) {
        if (q == 0){
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
    public static void main(String [] args){
        int p = 10;
        int q = 5;
        System.out.println(gcd(p, q));
    }
}
