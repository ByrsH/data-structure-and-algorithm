package com.coding.basic.leetcode.array;

/***
 * @description: https://leetcode.cn/problems/binary-search/description/
 * @author: yunhui
 * @create: 2023/4/3 11:16 PM
 **/
public class BinarySearch704 {
    public int search_for(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int search_binary(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 0 1 2 3 4 5 6
        // 1 3 4 5 6 7 9
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            // 0 + 1 / 2
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(9/2);
    }
}
