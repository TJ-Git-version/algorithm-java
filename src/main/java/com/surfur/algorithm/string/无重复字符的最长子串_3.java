package com.surfur.algorithm.string;

import java.util.*;

/**
 * 题目：给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *     子串：子字符串 是字符串中连续的 非空 字符序列。
 * 示例 1:
 * left = 0;
 * maxLen = 0;
 * 输入: s = "abcabcbb"
 * maxLen = 3;
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class 无重复字符的最长子串_3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "bbbbb";
        String s2 = "pwwkew";
        String s3 = "ohomm";
        int maxLen = lengthOfLongestSubstring(s3);
        System.out.println(maxLen);
    }


    /**
     * 使用hash表进行优化，跳跃式移动左指针
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // 直接跳到当前重复位置，避免一次一次left++移动
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    /**
     * 使用移动窗口进行优化
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 1) {
            return 1;
        }
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s.length() == 1) {
            return 1;
        }
        // 使用list保证有序性
        List<Character> list = new ArrayList<>();
        int maxLen = 0;
        int index = 0;
        while (index < s.length()) {
            if (!list.contains(s.charAt(index))) {
                // 不包含添加到set集合中
                list.add(s.charAt(index));
                // 统计最长不重复子串
                maxLen = Math.max(maxLen, list.size());
                // 如果包含，指针不移动，停流当前继续判断是否有重复的
                index++;
            } else {
                list.remove(0);
            }
        }
        return maxLen;
    }

}
