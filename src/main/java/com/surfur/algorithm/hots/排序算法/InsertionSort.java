package com.surfur.algorithm.hots.排序算法;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 8, 2, 7, 6};
        new InsertionSort().sort2(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void sort2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 从第一个开始，往前找
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            // 前探指针
            int j = i - 1;
            // j >= 0 作为结束条件，防止nums访问越界
            while (j >= 0 && nums[j] > tmp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }
    }

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > tmp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }
    }
}
