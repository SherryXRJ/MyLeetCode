package com.sherry.leetcode._0049_GroupAnagrams.optimization;

import java.util.*;

/**
 * 49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagramsSort {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        GroupAnagramsSort demo = new GroupAnagramsSort();
        List<List<String>> lists = demo.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);

    }
}
