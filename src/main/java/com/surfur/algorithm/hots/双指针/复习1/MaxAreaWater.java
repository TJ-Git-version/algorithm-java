package com.surfur.algorithm.hots.双指针.复习1;

/**
 * 盛最多水的容器
 */
public class MaxAreaWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = new MaxAreaWater().maxArea2(height);
        System.out.println(maxArea);
    }

    public int maxArea2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int wide = right - left;
            maxArea = Math.max(maxArea, minHeight * wide);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    /**
     * 超时了
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        // slowIndex 是慢指针，fastIndex是快指针，用于计算最大的容量
        int maxArea = 0;
        for (int slowIndex = 0; slowIndex < height.length; slowIndex++) {
            int fastIndex = slowIndex + 1;
            while (fastIndex < height.length) {
                int minHeight = Math.min(height[slowIndex], height[fastIndex]);
                maxArea = Math.max(maxArea, minHeight * (fastIndex - slowIndex));
                fastIndex++;
            }
        }
        return maxArea;
    }
}
