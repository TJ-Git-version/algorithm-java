package com.surfur.algorithm.hots.双指针;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 */
public class 移动零_283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums1 = {0};
        int[] nums2 = {0, 0, 1};
        int[] nums3 = {1, 0};
        moveZeroes4(nums3);
    }

    public static void moveZeroes4(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 左指针：指向当前要放置非0的位置
        int left = 0;
        // 右指针：探路指针
        int rigth = 0;

        // 右指针：遍历整个数组，找非0数字
        while (rigth < nums.length) {
            if (nums[rigth] != 0) {
                // temp可以处理第一个元素就不为0的情况，进行自交互
                int temp = nums[left];
                nums[left] = nums[rigth];
                nums[rigth] = temp;
                // 移动到下一个为0的索引
                left++;
            }
            rigth++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes3(int[] nums) {
        // 左指针：指向当前要放置非0的位置
        int left = 0;

        // 右指针：遍历整个数组，找非0数字
        for (int rigth = 0; rigth < nums.length; rigth++) {
            if (nums[rigth] != 0) {
                int temp = nums[left];
                nums[left] = nums[rigth];
                nums[rigth] = temp;
                // 移动到下一个为0的索引
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        // 特殊值情况
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 遍历数组
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 判断是否为0
            if (nums[i] == 0) {
                // 如果为0，将后面数组元素往前移动
                for (int j = i + 1; j < n; j++) {
                    nums[j - 1] = nums[j];
                }
                // 把最后一个设置为0
                nums[n - 1] = 0;
                // 回到上一次为0的位置，重新判断是否为0
                i--;
                // 为0元素不需要再遍历
                n--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes2(int[] nums) {
        // 特殊值情况
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 记录当前不为0元素下一个元素位置，用于替换元素
        int index = 0;
        // i 探路指针，找出不为0的元素往前挪
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        // index - 1 记录不为0的元素索引，将index往后的元素都设置为0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

}
