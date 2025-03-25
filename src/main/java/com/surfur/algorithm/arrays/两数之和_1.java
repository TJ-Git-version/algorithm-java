package com.surfur.algorithm.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 *  给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回<p>它们的数组下标</p>。
 *  你可以假设每种输入<p>只会对应一个答案</p>，并且你不能使用<p>两次相同的元素</p>。
 *  你可以按<p>任意顺序返回答案</p>。
 */
public class 两数之和_1 {

    public static void main(String[] args) {
        // int[] nums = {2, 7, 11, 15};
        // int target = 9;
        int[] nums = {3, 2, 4};
        int target = 6;
        // int[] nums = {3, 3};
        // int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 通过测试：运行时间 2ms
     * 使用map底层结构来提高值的查找效率：数组+链表+红黑树
     *      两数之和 = n1 + n2 有两种排列组合
     *      n1 = 两数之和 - n2
     *      n2 = 两数之和 - n1
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                return new int[]{map.get(nums[i]), i};
            }
        }
        return new int[]{};
    }

    /**
     * 通过测试：运行时间 55ms
     * 有优化空间
     */
    public static int[] twoSum1(int[] nums, int target) {
        // 暴力解法
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
