package com.coding.basic.leetcode.array;

/***
 * @description: https://leetcode.cn/problems/remove-element/
 * @author: yunhui
 * @create: 2023/4/6 9:39 PM
 **/
public class RemoveElement27 {

    /**
     * 两个for循环，发现相同元素，则移动后面所有元素
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        // [2,3,4,4,5]  4
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        for (int i=0; i < size; i++) {
            if (val == nums[i]) {
                for (int j = i; j < size; j++) {
                    nums[j] = nums[j+1];
                }
                size--;
                i--;
            }
        }
        return size;
    }

    /**
     * 快慢指针的方式
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        // [2,3,4,4,5,6,4,7]  4
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        int fast;
        int slow = 0;
        for (fast = 0;fast < size; fast++) {
            // 快指针不相等元素覆盖慢指针索引元素
            if (val != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }



    public static void main(String[] args) {
        int i = 3;
        for (i = 3; i < 3; i++) {
            System.out.println(i);
        }

    }

}
