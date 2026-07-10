package com.surfur.algorithm.hots.哈希.复习1;

import java.util.*;

/**
 * 字母异位词分组
 */
public class GroupAnagramsSolution {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs1 = {""};
        String[] strs2 = {"a"};

        GroupAnagramsSolution groupAnagramsSolution = new GroupAnagramsSolution();
        System.out.println(groupAnagramsSolution.groupAnagrams(strs));
        System.out.println(groupAnagramsSolution.groupAnagrams(strs1));
        System.out.println(groupAnagramsSolution.groupAnagrams(strs2));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
