package com.surfur.algorithm.hots.哈希.复习1;

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
        LongestConsecutiveSolution longestConsecutiveSolution = new LongestConsecutiveSolution();
        System.out.println(longestConsecutiveSolution.longestConsecutive2(nums));
        System.out.println(longestConsecutiveSolution.longestConsecutive2(nums1));
        System.out.println(longestConsecutiveSolution.longestConsecutive2(nums2));
    }

        public int longestConsecutive2(int[] nums) {
            int maxLength = 0;
            if (nums == null || nums.length == 0) {
                return maxLength;
            }
            // 去重
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            for (Integer num : set) {
                // 如果num不是序列，则跳过自己
                if (set.contains(num - 1)) {
                    continue;
                }
                // 以num作为一个起点
                int y = num + 1;
                // 循环结束后，y-1才是最后的一个元素
                while (set.contains(y)) {
                    y++;
                }
                maxLength = Math.max(maxLength, y - num);
            }
            return maxLength;
        }

    /**
     * 出异常，超出时间限制
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        if (nums == null || nums.length == 0) {
            return maxLength;
        }
        if (nums.length == 1) {
            return 1;
        }
        // 先排序
        sort1(nums);
        int currentNum = nums[0];
        int currentNumLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (currentNum != nums[i]) {
                if (currentNum + 1 == nums[i]) {
                    currentNumLength++;
                } else {
                    currentNumLength = 1;
                }
            }
            currentNum = nums[i];
            maxLength = Math.max(maxLength, currentNumLength);
        }
        return maxLength;
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    private void sort1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}
