package com.coding.basic.recursion;

import org.junit.Test;

/**
 * Created by yrs on 2017/7/16.
 */
public class FibonacciTest {

    @Test
    public void testRecursion() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        assert (fibonacci.recursion(3) == 2);
    }

    @Test
    public void testLoop() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        assert (fibonacci.loop(40) == fibonacci.recursion(40));
    }
}