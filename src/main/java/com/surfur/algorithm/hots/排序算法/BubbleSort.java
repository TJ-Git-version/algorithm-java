package com.surfur.algorithm.hots.排序算法;

import java.util.Arrays;

/**
 * 冒泡排序，两两比较，大的互换位置，把最大的往后移动
 * 优点：稳定，简单，很慢
 * 时间复杂度：O(n2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {8, 1, 4, 2, 5, 7};
        new BubbleSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
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
