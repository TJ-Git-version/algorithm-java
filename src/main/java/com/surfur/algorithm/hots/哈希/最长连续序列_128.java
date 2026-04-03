package com.surfur.algorithm.hots.哈希;

import java.util.*;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 示例 3：
 * 输入：nums = [1,0,1,2]
 * 输出：3
 */
public class 最长连续序列_128 {
    public static void main(String[] args) {
//        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
       // int[] nums = {1, 0, 1, 2};
//        int[] nums = {1, 2, 6, 7, 8};
        System.out.println(longestConsecutive1(nums));
    }

    /**
     * 暴力解：Collections.sort(list) 时间复杂度 O(n log n)
     */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int maxLen = 1;
        int currentLen = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) == 1) {
                currentLen++;
                maxLen = Math.max(currentLen, maxLen);
            } else {
                currentLen = 1;
            }
        }
        return maxLen;
    }

    /**
     * 最优解法（O (n) 时间，不排序）
     * 核心思路：
     * 只用 HashSet 存所有数字
     * 只从连续序列的起点开始遍历（num - 1 不在 set 里 才是起点）
     * 向后找连续数，统计长度
     */
    public static int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        // 去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num : set) {
            // 只处理连续节点
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }
                maxLen = Math.max(maxLen, currentLen);
            }
        }
        return maxLen;
    }


}
