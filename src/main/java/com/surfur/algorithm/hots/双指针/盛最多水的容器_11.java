package com.surfur.algorithm.hots.双指针;

/**
 * 目的：求长方形的最大面积
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 */
public class 盛最多水的容器_11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {1, 1};
        System.out.println(maxArea1(height));
    }

    /**
     * 最优解是 O (n) 双指针，只遍历一次。
     */
    public static int maxArea1(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * h);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    /**
     * 暴力枚举法，复杂度是 O(n²)，数据量大一点必超时！
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int right = i + 1;
            while (right < height.length) {
                int minHeight = Math.min(height[right], height[i]);
                maxArea = Math.max(maxArea, minHeight * (right - i));
                right++;
            }
        }
        return maxArea;
    }
}
