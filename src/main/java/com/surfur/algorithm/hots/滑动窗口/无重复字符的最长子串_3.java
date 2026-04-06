package com.surfur.algorithm.hots.滑动窗口;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 先理解什么是字串：子字符串 是字符串中连续的 非空 字符序列。
 */
public class 无重复字符的最长子串_3 {

    public static void main(String[] args) {
        //String s = "abcabcbb";
        //String s = "bbbbb";
        //String s = "pwwkew";
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * 暴力滑动窗口解法，时间复杂度 O (n²)
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] charArray = s.toCharArray();
        int maxLength = 0;
        // 左指针
        int left = 0;
        // 右指针
        int right = 1;
        int length = s.length() - 1;
        Set<Character> set = new HashSet<>();
        while (left < length) {
            int currentLength = 1;
            set.add(charArray[left]);
            while (right <= length) {
                if (!set.contains(charArray[right])) {
                    currentLength++;
                    set.add(charArray[right]);
                } else {
                    break;
                }
                right++;
            }
            left++;
            maxLength = Math.max(currentLength, maxLength);
            right = left + 1;
            set.clear();
        }
        return maxLength;
    }
}
