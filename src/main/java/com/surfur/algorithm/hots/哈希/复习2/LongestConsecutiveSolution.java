package com.surfur.algorithm.hots.哈希.复习2;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 */
public class LongestConsecutiveSolution {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums1 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums2 = {1, 0, 1, 2};
        int[] nums3 = {1, -1, 3, 7};
        LongestConsecutiveSolution longestConsecutiveSolution = new LongestConsecutiveSolution();
        System.out.println(longestConsecutiveSolution.longestConsecutive(nums));
        System.out.println(longestConsecutiveSolution.longestConsecutive(nums1));
        System.out.println(longestConsecutiveSolution.longestConsecutive(nums2));
        System.out.println(longestConsecutiveSolution.longestConsecutive(nums3));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 1;
        for (int num : set) {
            // 如果不是序号，跳过
            if (set.contains(num - 1)) {
                continue;
            }
            int length = 0;
            while (set.contains(num++)) {
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}