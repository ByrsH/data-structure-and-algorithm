package com.coding.basic.leetcode.array;

/***
 * @description:  https://leetcode.cn/problems/minimum-size-subarray-sum/
 * @author: yunhui
 * @create: 2023/4/8 1:48 PM
 **/
public class MinSubArrayLen209 {

    /**
     * 滑动窗口的方式
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (target == 0 || nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] >= target ? 1 : 0;
        }
        int result = Integer.MAX_VALUE;
        int i = 0;
        int j = 1;
        if (nums[i] >= target) {
            return 1;
        }
        int sum = nums[i] + nums[j];
        while (i <= j) {
            if (sum >= target) {
                int subLen = j-i + 1;
                result = result < subLen ? result : subLen;
                sum = sum - nums[i++];
            } else {
                j=j+1;
                if (i == nums.length || j == nums.length) {
                    break;
                }
                sum = sum + nums[j];
            }

        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
