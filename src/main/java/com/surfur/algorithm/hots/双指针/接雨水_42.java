package com.surfur.algorithm.hots.双指针;

/**
 * 求每根柱子能装多少水，这里比较特殊的点水第一根和最后一根柱子是装不了水的。
 * 如何算：算出当前柱子两边最小的柱子高度 - 自身柱子高度 = 装水量
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class 接雨水_42 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trap1(height));
    }

    public static int trap1(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        // 总雨水
        int sumTrap = 0;
        // 左边最高柱子
        int leftMax = 0;
        // 右边最高柱子
        int rightMax = 0;
        // 左指针
        int left = 0;
        // 右指针
        int right = height.length - 1;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // 左边柱子比右边低，先算左边，移动左指针
            if (leftMax < rightMax) {
                sumTrap += Math.max(leftMax - height[left], 0);
                left++;
            } else {
                // 右边柱子比左边低，先算右边，移动右指针
                sumTrap += Math.max(rightMax - height[right], 0);
                right--;
            }
        }
        return sumTrap;
    }

    /**
     * 暴力算法：O（n * ln * rn）
     *
     * @param height 柱高度
     * @return 能接的雨水
     */
    public static int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int sumTrap = 0;
        int h = height.length - 1;
        for (int i = 1; i < h; i++) {
            // 找出左边最高的高
            int leftMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(height[j], leftMax);
            }
            // 找出右边最高的高
            int rightMax = 0;
            for (int j = i + 1; j <= h; j++) {
                rightMax = Math.max(height[j], rightMax);
            }
            int trap = Math.min(leftMax, rightMax) - height[i];
            sumTrap += Math.max(trap, 0);

        }
        return sumTrap;
    }
}
