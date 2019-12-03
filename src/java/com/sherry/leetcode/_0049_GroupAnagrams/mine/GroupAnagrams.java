package com.sherry.leetcode._0049_GroupAnagrams.mine;

import java.util.*;

/**
 * 49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagrams {

    /**
     * 事件复杂度 O(n^2)，太慢了
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Character, Integer>[] maps = new HashMap[strs.length];

        for (int i = 0; i < strs.length; i++) {
            maps[i] = new HashMap<>();
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            Map<Character, Integer> m = maps[i];

            for (char c : str.toCharArray()) {
                m.put(c, m.getOrDefault(c, 0) + 1);
            }


        }

        //  分组
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < maps.length; i++) {
            if (set.contains(i)) continue;

            List<String> l = new ArrayList<>();
            set.add(i);
            l.add(strs[i]);
            for (int j = i + 1; j < maps.length; j++) {
                if (set.contains(j)) continue;

                if (maps[i].equals(maps[j])) {
                    set.add(j);
                    l.add(strs[j]);
                }
            }
            result.add(l);
        }

        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams demo = new GroupAnagrams();
        List<List<String>> lists = demo.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);

    }
}
