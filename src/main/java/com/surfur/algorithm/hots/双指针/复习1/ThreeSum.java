package com.surfur.algorithm.hots.双指针.复习1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums1 = {0, 0, 0, 0};
        List<List<Integer>> result = new ThreeSum().threeSum2(nums1);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int slowIndex = 0; slowIndex < nums.length; slowIndex++) {
            int slowVal = nums[slowIndex];
            // 固定指针去重：和上一个数字相同，跳过
            if (slowIndex > 0 && nums[slowIndex] == nums[slowIndex - 1]) {
                continue;
            }
            int leftIndex = slowIndex + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                int sum = slowVal + nums[leftIndex] + nums[rightIndex];
                if (sum == 0) {
                    // 记录合法的三元组
                    res.add(List.of(slowVal, nums[leftIndex], nums[rightIndex]));
                    // 左指针跳过全部重复值
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                        leftIndex++;
                    }
                    // 右指针跳过全部重复值
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                        rightIndex--;
                    }
                    // 收缩窗口
                    leftIndex++;
                    rightIndex--;
                } else if (sum < 0) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int slowIndex = 0; slowIndex < nums.length; slowIndex++) {
            int leftIndex = slowIndex + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                int leftNum = nums[leftIndex];
                int rightNum = nums[rightIndex];
                int slowNum = nums[slowIndex];
                int threeSum = slowNum + rightNum + leftNum;
                List<Integer> currentList = List.of(slowNum, leftNum, rightNum);
                if (threeSum == 0 && !res.contains(currentList)) {
                    res.add(currentList);
                    leftIndex++;
                    rightIndex--;
                } else if (threeSum < 0) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
        }
        return res;
    }
}
