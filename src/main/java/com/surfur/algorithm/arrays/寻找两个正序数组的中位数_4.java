package com.surfur.algorithm.arrays;

import java.util.Arrays;

/**
 * 题目：给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *      算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例 1：
 *      输入：nums1 = [1,3], nums2 = [2]
 *      输出：2.00000
 *      解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *      输入：nums1 = [1,2], nums2 = [3,4]
 *      输出：2.50000
 *      解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 */
public class 寻找两个正序数组的中位数_4 {

    public static void main(String[] args) {
        // double res = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        double res = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(res);
    }

    /**
     * 暴力解法，时间o(2n) + o(n二次方)
     * 快一点
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sumArrLength = nums1.length + nums2.length;
        int[] sumArr = new int[sumArrLength];
        System.arraycopy(nums1, 0, sumArr, 0, nums1.length);
        int index = nums1.length;
        for (int k : nums2) {
            sumArr[index] = k;
            index++;
        }
        Arrays.sort(sumArr);
        int midNum = sumArrLength / 2;
        if (sumArrLength % 2 != 0) {
            return sumArr[midNum];
        }
        return (double) (sumArr[midNum] + sumArr[midNum - 1]) / 2;
    }

    /**
     * 暴力解法，时间o(2n) + o(n二次方)
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int sumArrLength = nums1.length + nums2.length;
        int[] sumArr = new int[sumArrLength];
        for (int i = 0; i < nums1.length; i++) {
            sumArr[i] = nums1[i];
        }
        int index = nums1.length;
        for (int i = 0; i < nums2.length; i++) {
            sumArr[index] = nums2[i];
            index++;
        }
        for (int i = 0; i < sumArrLength; i++) {
            for (int j = 0; j < sumArrLength - 1 - i; j++) {
                if (sumArr[j] > sumArr[j + 1]) {
                    int temp = sumArr[j];
                    sumArr[j] = sumArr[j + 1];
                    sumArr[j + 1] = temp;
                }
            }
        }
        int midNum = sumArrLength / 2;
        if (sumArrLength % 2 != 0) {
            return sumArr[midNum];
        }
        return (double) (sumArr[midNum] + sumArr[midNum - 1]) / 2;
    }

}
