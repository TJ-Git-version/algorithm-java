package com.surfur.algorithm.hots.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 示例 1:
 * 输入: s = "cba eba bac d", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class 找到字符串中所有字母异位词_438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
//        String s = "abab";
//        String p = "ab";
//        String s = "aa";
//        String p = "bb";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length(), pLength = p.length();
        if (sLength < pLength) {
            return List.of();
        }
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        for (int left = 0; left < sLength; left++) {
            int right = left + pLength - 1;
            if (right >= sLength) {
                break;
            }
            int[] windowCount = new int[26];

            int cpLeft = left;
            while (cpLeft <= right) {
                windowCount[s.charAt(cpLeft) - 'a']++;
                cpLeft++;
            }
            if (Arrays.equals(pCount, windowCount)) {
                result.add(left);
            }
        }
        return result;
    }
}
