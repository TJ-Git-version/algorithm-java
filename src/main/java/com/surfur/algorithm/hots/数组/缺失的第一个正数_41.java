package com.surfur.algorithm.hots.数组;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 */
public class 缺失的第一个正数_41 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,0};
        int[] nums2 = {3,4,-1,1};
        int[] nums3 = {7,8,9,11,12};
        int[] nums4 = {3, 2, 1};
        System.out.println(firstMissingPositive1(nums2));
    }

    public static int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;

        // 将 1～N 的整数归位
        // 比如：3 2 1
        // 归位后：1 2 3
        for (int i = 0; i < length; i++) {
            // 3 - 1 = 2
            // 下标将在2
            // 2 - 1 = 1
            // 下标将在1，以此类推
            while (nums[i] > 0 && nums[i] < length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 比较归位后的nums，从数组索引0开始
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 都不满足则说明：长度 +1
        return length + 1;
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        LinkedHashSet<Integer> numSets = new LinkedHashSet<>();
        for (int num : nums) {
            numSets.add(num);
        }
        int firstMissing = 1;
        for (Integer numSet : numSets) {
            if (numSet <= 0) {
                continue;
            }
            if (numSet > firstMissing) {
                return firstMissing;
            } else {
                firstMissing++;
            }
        }
        return firstMissing;
    }
}
