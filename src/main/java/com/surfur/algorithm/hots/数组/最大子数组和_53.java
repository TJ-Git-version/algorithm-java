package com.surfur.algorithm.hots.数组;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class 最大子数组和_53 {
    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {1};
//        int[] nums = {5, 4, -1, 7, 8};
//        int[] nums = {-1, -2};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cur = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 要么从新开始，要么从前面之和开始
            cur = Math.max(nums[i], cur + nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }

    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int maxNums = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int left = i;
            int right = length;
            while (left < right) {
                int sum = 0;
                int index = left;
                while (index < right) {
                    sum += nums[index];
                    index++;
                }
                maxNums = Math.max(maxNums, sum);
                if (nums[left] >= nums[right - 1]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return maxNums;
    }
}
