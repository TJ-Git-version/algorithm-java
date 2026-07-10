package com.surfur.algorithm.hots.哈希.复习1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoSumSolution {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] nums1 = {3, 2, 4};
        int target1 = 6;

        int[] nums2 = {3, 3};
        int target2 = 6;

        TwoSumSolution solution = new TwoSumSolution();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
        System.out.println(Arrays.toString(solution.twoSum(nums1, target1)));
        System.out.println(Arrays.toString(solution.twoSum(nums2, target2)));
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        // A + B = C
        // A = C - B
        // B = C - A
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

}
