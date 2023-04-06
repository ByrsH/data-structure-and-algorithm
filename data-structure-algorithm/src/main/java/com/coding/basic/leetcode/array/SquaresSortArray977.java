package com.coding.basic.leetcode.array;

import java.util.*;

/***
 * @description: https://leetcode.cn/problems/squares-of-a-sorted-array/
 * @author: yunhui
 * @create: 2023/4/6 10:25 PM
 **/
public class SquaresSortArray977 {

    /**
     * 利用Java 的排序方法，时间复杂度较高
     * @param nums
     * @return
     */
    public int[] sortedSquares(final int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            nums[i] *= nums[i];
            list.add(nums[i]);
        }
        Collections.sort(list);
        for (int i=0; i<nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    /**
     * 双指针方法，分别指向头尾，判断那个平方计算大就存储，然后移动指针。
     * @param nums
     * @return
     */
    public int[] sortedSquares2(final int[] nums) {
        // [-4,-1,0,3,10]
        // [16,1,0,9,100]
        // 输出：[0,1,9,16,100]
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] newNums = new int[nums.length];
        int index = newNums.length -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int startSquares = nums[start] * nums[start];
            int endSquares = nums[end] * nums[end];
            if (startSquares > endSquares) {
                newNums[index--] = startSquares;
                start++;
            } else {
                newNums[index--] = endSquares;
                end--;
            }
        }
        return newNums;
    }


}
