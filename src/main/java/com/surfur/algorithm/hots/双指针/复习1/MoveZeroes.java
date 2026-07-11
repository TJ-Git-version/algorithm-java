package com.surfur.algorithm.hots.双指针.复习1;

import java.util.Arrays;

/**
 * 移动0
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes().move02(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 一次遍历
     */
    public void move02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 记录为0指针位置，慢指针
        int zerosIndex = 0;
        // 快指针，提前找到不为0的元素
        for (int fastPoint = 0; fastPoint < nums.length; fastPoint++) {
            if (nums[fastPoint] != 0) {
                // 交换位置
                int tmp = nums[fastPoint];
                nums[fastPoint] = nums[zerosIndex];
                nums[zerosIndex++] = tmp;
            }
        }
    }


    /**
     * 两次遍历：
     *  第一次遍历将不为0的往前移动，记录不为0的个数
     *  第二次遍历跳过不为0的元素，把后面的元素设置为0
     * @param nums
     */
    public void move0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 找出有多少个非0的元素
        int notZeroesCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZeroesCount++] = nums[i];
            }
        }
        // 跳过非0的元素，把notZeroesCount后面的值都设置为0
        for (int i = notZeroesCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
