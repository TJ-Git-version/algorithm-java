package com.surfur.algorithm.hots.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class 三数之和_15 {
    public static void main(String[] args) {
        List<Integer> l1 = List.of(-1, 0, 1);
        List<Integer> l2 = List.of(0, 1, -1);
        System.out.println(l1.containsAll(l2));

        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {-4, -1, -1, 0, 1, 2};
//        int[] nums = {0,0,0};
        System.out.println(threeSum1(nums));
    }

    /**
     * 最优解（排序 + 双指针 O (n²)）
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return List.of();
        }
        // 先排序，把相同的数字挨在一起，方便去重
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        // 固定一轮循环，保证每个元素都遍历到
        for (int i = 0; i < nums.length; i++) {
            // 去重，如果当前数和前面数一样直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 定义双指针
            // left：从下一个元素开始
            int left = i + 1;
            // right：最大长度
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    rs.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    // 跳过重复的left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 跳过重复的right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 和太小，左边往右边移动
                    left++;
                } else {
                    // 和太大，右边往左边移动
                    right--;
                }
            }
        }
        return rs;
    }

    /**
     * 暴力解法：时间复杂度 O(n3)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return List.of();
        }
        List<List<Integer>> rs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    List<Integer> num = Arrays.asList(nums[i], nums[j], nums[k]); // 改用 Arrays.asList
                    Collections.sort(num);
                    if ((nums[i] + nums[j] + nums[k] == 0) && !rs.contains(num)) {
                        rs.add(num);
                    }
                }
            }
        }
        return rs;
    }
}
